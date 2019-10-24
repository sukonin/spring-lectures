package com.epam.core.lecture_7.jpaExample.repository;

import com.epam.core.lecture_7.jpaExample.domain.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

  private EntityManager entityManager;

  @PersistenceContext
  void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public User findById(Long id) {
    return entityManager.find(User.class, id);
  }

  @Override
  public void saveOrUpdate(User user) {
    if (user.getId() == null) {
      entityManager.persist(user);
    } else {
      entityManager.merge(user);
    }
  }

  @Override
  public void update(User user) {
    entityManager.merge(user);
  }

  @Override
  public void deleteById(User user) {
    entityManager.remove(user);
  }

  @Override
  public List<User> findAll() {
    return entityManager.createQuery("select u from User u").getResultList();
  }
}
