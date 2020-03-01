package com.telegram.bot.daos.impl;

import com.telegram.bot.daos.ICityDAO;
import com.telegram.bot.models.City;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CityDAO extends AbstractDAO<City> implements ICityDAO {

    public CityDAO() {
        super(City.class);
    }

    @Override
    public String getByCityName(String cityName) {
        return (String) getCurrentSession()
                .createQuery("SELECT information FROM City where name = '" + cityName + "'").uniqueResultOptional().orElse("no city provided");
    }

    @Override
    public List<String> getAllNames() {
        return getCurrentSession().createQuery("SELECT name FROM City ORDER BY name").list();
    }

    @Override
    public List<City> getAll() {
        return getCurrentSession().createQuery("FROM City ORDER BY name").list();
    }
}
