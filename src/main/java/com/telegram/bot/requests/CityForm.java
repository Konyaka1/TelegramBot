package com.telegram.bot.requests;

import lombok.Data;
import org.hibernate.HibernateException;

@Data
public class CityForm {
    private Integer id;
    private String name;
    private String info;

    public String getName() {
        if (name.isBlank())
            throw new HibernateException("City name is blank");
        name = name.trim();
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String getInfo() {
        return info.isBlank() ? "no info provided" : info.trim();
    }
}
