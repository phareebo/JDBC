package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "CREATE  TABLE IF NOT EXISTS usersTable(id INT AUTO_INCREMENT," +
                    "name VARCHAR(50), lastName VARCHAR (50), age INT not NULL, PRIMARY KEY (id));";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.createConnection();   //объект для соединения с БД = соединение с БД
             Statement statement = connection.createStatement()) { //объект state для исполнения запросов к базе данных
            String SQL = "DROP TABLE IF EXISTS usersTable;";  //команда SQL
            statement.executeUpdate(SQL);   //метод state'a для выполнения команды SQL
        } catch (SQLException e) {          //ловим исключение для создания подключения
            throw new RuntimeException(e);
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "INSERT INTO usersTable(name, lastName, age)"
                    + "VALUES (\"" + name + "\"," + " \"" + lastName + "\"," + age + ")";
            System.out.println("User с именем " + name + " добавлен в базу данных");
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "DELETE FROM usersTable WHERE ID = (" + id + ")";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "SELECT * FROM usersTable;";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
                System.out.println(user.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            String SQL = "DELETE FROM usersTable";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
