package com.telegram.bot.service.impl;

import com.telegram.bot.daos.ICityDAO;
import com.telegram.bot.models.City;
import com.telegram.bot.models.dtos.CityVO;
import com.telegram.bot.requests.CityForm;
import com.telegram.bot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedList;
import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    ICityDAO cityDAO;

    @Override
    public String getByCityName(String cityName) {
        return cityDAO.getByCityName(cityName);
    }

    @Override
    public List<CityVO> getAll() {
        List<CityVO> data = new LinkedList<>();
        for (City it : cityDAO.getAll()) {
            data.add(CityVO.fromEntity(it));
        }
        return data;
    }

    @Override
    public CityVO addCity(CityForm cityForm) {
        return CityVO.fromEntity(cityDAO.save(new City(cityForm.getName(), cityForm.getInfo())));
    }

    @Override
    public CityVO updateCity(CityForm cityForm) {
        cityDAO.update(new City(cityForm.getId(), cityForm.getName(), cityForm.getInfo()));
        return CityVO.fromEntity(cityDAO.get(cityForm.getId()));
    }

    @Override
    public Boolean deleteCity(int id) {
        cityDAO.delete(cityDAO.get(id));
        return true;
    }

    public List<String> getAllNames(){
        return cityDAO.getAllNames();
    }

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(){
        return "qwe";
    }
}
