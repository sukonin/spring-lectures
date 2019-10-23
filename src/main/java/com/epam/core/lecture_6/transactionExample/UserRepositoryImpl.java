package com.epam.core.lecture_6.transactionExample;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final String SELECT_BY_ID = "select id, name, surname from USER_T where id=?";
  private final String INSERT = "insert into USER_T (id, name, surname) values(?,?,?)";
  private final String UPDATE = "update USER_T set name=?, surname=? where id =? ";
  private final String DELETE = "delete from USER_T where id =? ";
  private final String SELECT_ALL = "select * from USER_T";

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<User> findAllById(Long id) {
    return jdbcTemplate.query(SELECT_BY_ID, new UserRowMapper(), id);
  }


  @Override
  public User findById(Long id) {
    return jdbcTemplate.queryForObject(SELECT_BY_ID, new UserRowMapper(), id);
  }

  @Override
  public int save(User user) {
    return jdbcTemplate.update(INSERT, user.getId(), user.getName(), user.getSurname());
  }

  @Override
  public int update(User user) {
    return jdbcTemplate.update(UPDATE, user.getName(), user.getSurname(), user.getId());
  }

  @Override
  public int deleteById(Long id) {
    return jdbcTemplate.update(DELETE, id);
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(SELECT_ALL, new UserRowMapper());
  }

  @Override
  public void clearDb() {
    jdbcTemplate.update("delete from USER_T");
  }


  public void createTable(String name) {
    jdbcTemplate.execute("create table " + name + " (id integer, name varchar2)");
  }
}
