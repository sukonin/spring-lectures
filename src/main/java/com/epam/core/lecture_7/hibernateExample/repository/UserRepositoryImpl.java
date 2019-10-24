package com.epam.core.lecture_7.hibernateExample.repository;

import com.epam.core.lecture_7.hibernateExample.domain.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

  private SessionFactory sessionFactory;

  @Autowired
  public UserRepositoryImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Session session() {
    try {
      return sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
      return sessionFactory.openSession();
    }
  }

  @Override
  public User findById(Long id) {
    return session().find(User.class, id);
  }

  @Override
  public void save(User user) {
    session().saveOrUpdate(user);
  }

  @Override
  public void update(User user) {
    session().update(user);
  }

  @Override
  public void deleteById(Long id) {
    session().createNativeQuery("delete from USER where ID = " + id);
  }

  @Override
  public List<User> findAll() {
    return session().createQuery("from User u").list();
  }
}
