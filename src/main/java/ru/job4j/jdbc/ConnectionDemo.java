package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * https://job4j.ru/profile/exercise/55/task-view/344
 * Изучение работы с JDBC. Подключение JDBC и чтение файла app.properties
 * в качестве настроечного файла.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 27.09.2021
 */
public class ConnectionDemo {
    public static void main(String[] args) {
        Config config = new Config("./data/app.properties");
        config.load();

        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
