package com.telegram.bot.daos;

import com.telegram.bot.models.City;

import java.util.List;


public interface ICityDAO extends IBasicDAO<City> {

    String getByCityName(String cityName);

    List<String> getAllNames();
}
