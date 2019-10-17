package com.epam.core.lecture_5.pureJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

  public User findUserById(Long id) {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      /*Step #1*/
      /*Load driver*/
      Class.forName("org.h2.Driver");

      /*Open connection*/
      connection = DriverManager.getConnection("jdbc:h2:~/testdb", "user", "user");

      /*Step #2*/
      /*Create Statement*/
      preparedStatement = connection
          .prepareStatement("select * from User where id = ?" + id);
      preparedStatement.setLong(1, id);

      /*Step #3*/
      /*Execute Statement*/
      /*Return resultSet(cursor)*/
      resultSet = preparedStatement.executeQuery();

      /*Step #4*/
      /*Map resultSet to our entity*/
      if (resultSet.next()) {
        long selectedId = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");

        return User.builder()
            .id(selectedId)
            .name(name)
            .surname(surname).build();
      }
    } catch (SQLException e) {
      throw new RuntimeException("Unexpected problem when" +
          " extracting users from database!", e);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return null;
  }

}
