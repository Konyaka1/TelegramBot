package com.telegram.bot.service;

import com.telegram.bot.models.dtos.CityVO;
import com.telegram.bot.requests.CityForm;

import java.util.List;

public interface ICityService {

    String getByCityName(String cityName);

    List<CityVO> getAll();

    CityVO addCity(CityForm cityForm);

    CityVO updateCity(CityForm cityForm);

    Boolean deleteCity(int id);

    List<String> getAllNames();
}
