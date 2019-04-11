package com.dao;

import com.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import java.util.List;

public class UserDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory (SessionFactory sessionFactory) {
        this.sessionFactory  = sessionFactory;
    }

    public List search (UserEntity condition) {
        List list = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        try
        {
            Criteria c = session.createCriteria(UserEntity.class);
            Example example = Example.create(condition);
            c.add(example);
            list = c.list();
            tx.commit();
        }catch (Exception e)
        {
            tx.rollback();
        }

        return list;
    }
}
