package com.telegram.bot.daos;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBasicDAO<T> {

    List<T> getAll();

    T save(T t);

    void update(T t);

    void saveOrUpdate(T t);

    void delete(T t);

    T get(int id);
}
