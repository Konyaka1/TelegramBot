package com.telegram.bot.daos.impl;

import com.telegram.bot.daos.IBasicDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public abstract class AbstractDAO<T> implements IBasicDAO<T> {

    protected final Class<T> persistenceType;

    public AbstractDAO(Class<T> persistenceType) {
        this.persistenceType = persistenceType;
    }

    @Autowired
    @Qualifier(value = "entityManagerFactory")
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createQuery("from " + persistenceType.getName(), persistenceType).list();
    }

    @Override
    public T save(T t) {
       return get((Integer) getCurrentSession().save(t));
    }

    @Override
    public void update(T t) {
        getCurrentSession().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        getCurrentSession().delete(t);
    }

    @Override
    public T get(int id) {
        return getCurrentSession().get(persistenceType, id);
    }
}
