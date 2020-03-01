class CityListener {

    EDIT_BTN = '<input type="button" value="edit" class="edit-btn">';
    DELETE_BTN = '<input type="button" value="delete" class="delete-btn">';
    static EDIT_FORM = '<form class="form" id="edit-form" action="#" onsubmit="return false">\n' +
        '        <input type="text" name="name">\n' +
        '        <textarea name="info"></textarea>\n' +
        '        <input type="submit" value="edit" class="edit-form-btn">\n' +
        '    </form>';


    constructor(container) {
        this.container = container;
        container.addEventListener('click', this.eventManage)
    }

    static eventManage(event) {
        var target = event.target;
        if (target.className === 'delete-btn') {
            var id = target.parentElement.id;
            fetch('/info?id=' + id, {
                method: 'DELETE',
            })
                .then(response => response.json())
                .then(result => result.obj === true ? this.removeChild(document.getElementById(id.toString())) : alert('Can\'t delete'));
        }
        if (target.className === 'edit-btn') {
            var elem = target.parentElement;
            elem.removeChild(elem.lastChild);
            if (elem.lastChild.tagName !== 'FORM') {
                elem.innerHTML += CityListener.EDIT_FORM;
                elem.lastChild.elements[0].value = elem.firstChild.innerText;
                elem.lastChild.elements[1].value = elem.childNodes[1].innerText;
            } else {
                elem.removeChild(elem.lastChild);
            }
            elem.appendChild(document.createElement('hr'));
        }
        if (target.className === 'edit-form-btn') {
            var elem = target.parentElement.parentElement;
            var form = target.parentElement;
            fetch('/info', {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({id: elem.id, name: form.elements[0].value, info: form.elements[1].value})
            })
                .then(response => response.json())
                .then(result => {
                    if (result.status === 200) {
                        elem.firstChild.innerText = result.obj.name;
                        elem.childNodes[1].innerText = result.obj.info;
                        elem.removeChild(form);
                    } else {
                        alert(result.msg);
                    }

                })
        }
    }

    addCity() {
        var form = document.getElementById('form');
        fetch('/info', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id: 0, name: form.elements[0].value, info: form.elements[1].value})
        })
            .then(response => response.json())
            .then(result => {
                if (result.status === 200) {
                    this.addLine(result.obj);
                    form.elements[0].value = '';
                    form.elements[1].value = '';
                } else {
                    alert(result.msg);
                }
            });
    }

    addLine(data) {
        var line = document.createElement('div');
        line.className = 'city';

        var pName = document.createElement('p');
        pName.innerText = data.name;
        var pInfo = document.createElement('p');
        pInfo.innerText = data.info;

        line.appendChild(pName);
        line.appendChild(pInfo);

        line.innerHTML += this.EDIT_BTN;
        line.innerHTML += this.DELETE_BTN;

        line.appendChild(document.createElement('hr'));

        line.id = data.id;

        this.container.appendChild(line);
    }

    addAllCity() {
        fetch('/info')
            .then(response => response.json())
            .then(result => {
                if (result.status === 200) {
                    result.obj.forEach(data => this.addLine(data))
                } else {
                    alert(result.msg);
                }
            });
    }
}

let cityListener;

function onload() {
    let container = document.getElementById('container');
    cityListener = new CityListener(container);
    cityListener.addAllCity();
    container.addEventListener('click', CityListener.eventManage)
}
