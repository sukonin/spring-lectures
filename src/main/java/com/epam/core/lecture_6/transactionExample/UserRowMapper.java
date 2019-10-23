package com.epam.core.lecture_6.transactionExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {

    long id = rs.getLong("ID");
    String name = rs.getString("NAME");
    String surname = rs.getString("SURNAME");

    return User.builder()
        .id(id)
        .name(name)
        .surname(surname)
        .build();
  }
}
