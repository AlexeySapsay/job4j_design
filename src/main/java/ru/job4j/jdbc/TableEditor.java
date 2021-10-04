package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * https://job4j.ru/profile/exercise/55/task-view/345
 * Изучение работы с JDBC. Подключение JDBC и чтение файла app.properties
 * в качестве настроечного файла. Работа с DDL-
 * создание, обновление, удаление таблиц/ баз данных.
 * <p>
 * Реализовать методы каркасного класса
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 28.09.2021
 */
public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    /**
     * Метод устанавливает соединение с базой данных по
     * аргументам, полученным из app.properties
     *
     * @throws SQLException An exception that provides
     *                      information on a database access
     *                      error or other errors.
     */
    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
        System.out.println("Connection estalished......");
    }

    /**
     * Метод создает пустую таблицу без столбцов с указанным именем;
     *
     * @param tableName имя таблицы
     */
    public void createTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table if not exists %s (%s, %s);",
                    tableName,
                    "id serial primary key",
                    "name varchar(255)");
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет таблицу по указанному имени;
     *
     * @param tableName имя таблицы для удаления
     */
    public void dropTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table %s;", tableName);
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавляет столбец в таблицу;
     *
     * @param tableName  имя таблицы, в которую будет добавлен столбец
     * @param columnName имя столбца
     * @param type       тип данных добавленного столбца
     */
    public void addColumn(String tableName, String columnName, String type) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s ADD %s %s",
                    tableName,
                    columnName,
                    type);
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаляет столбец из таблицы
     *
     * @param tableName  имя таблицы, в которую будет добавлен столбец
     * @param columnName имя столбца
     */
    public void dropColumn(String tableName, String columnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s DROP COLUMN %s",
                    tableName,
                    columnName);
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод переименовывает столбец
     *
     * @param tableName     имя таблицы, в которой будет переименован столбец
     * @param columnName    имя столбца для переименования
     * @param newColumnName новое имя столбца
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s",
                    tableName,
                    columnName,
                    newColumnName);
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTableScheme(Connection connection, String tableName)
            throws Exception {
        var rowSeparator = "_".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i),
                        metaData.getColumnTypeName(i)));
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./data/app.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        TableEditor tableEditor = new TableEditor(properties);
        System.out.println("--- Создаем тестовую таблицу без полей---");
        tableEditor.createTable("user1");
        System.out.println("--- Таблица созданна ---");

//        System.out.println("--- Удаляем таблицу Test_table1---");
//        tableEditor.dropTable("Test_table1");
//        System.out.println("--- Таблица удаленна---");

//        System.out.println("--- Создаем тестовую таблицу без полей---");
//        tableEditor.createTable("Test_table1");
//        System.out.println("--- Таблица созданна ---");

//        System.out.println("--- Добравляем колонку в таблицу ---");
//        tableEditor.addColumn("Test_table1", "adding", "INT");
//        System.out.println("--- Колонка добавленна ---");

//        System.out.println("--- Удаляем колонку  ---");
//        tableEditor.dropColumn("Test_table1", "xxx");
//        System.out.println("--- Колонка удалена ---");

//        System.out.println("--- Переименновываем колонку  ---");
//        tableEditor.renameColumn("Test_table1", "adding1", "XXX");
//        System.out.println("--- Колонка переименнованна ---");
    }
}
