package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Жёлтый", "Микеланджело", (byte) 15);
        userService.saveUser("Красный", "Рафаэль", (byte) 15);
        userService.saveUser("Синий", "Леонардо", (byte) 15);
        userService.saveUser("Фиолетовый", "Донателло", (byte) 15);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
