package ru.job4j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "1234";
        connection = DriverManager.getConnection(url, login, password);
    }

    /**
     * Метод вставки. Помещает объект в базу данных city
     *
     * @param city объект для добавления
     */
    public void insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для проверки обновления таблицы
     *
     * @param city Во-первых, метод update() возвращает boolean, это нужно для того,
     *             чтобы узнать произошло обновление или нет.
     * @return Во-вторых, чтобы узнать произошло само обновление мы используем
     * метод executeUpdate(), если это метод возвращает 0,
     * то значит оно не произошло, поэтому мы проверяем, что результат больше 0.
     */
    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод удаления элемента по id
     *
     * @param id удаляемый элемент по id
     * @return возвращает true при успехе и false при провале
     */
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод получения всех элементов.
     *
     * @return возвращает все элементы, хранимые в таблице.
     * <p>
     * Обратите внимание. Во-первых, ResultSet мы использовали вместе
     * с try-with-resources. Во-вторых, чтобы получить доступ к элементу
     * записи используем метод «getТип(имя_столбца)».
     * В-третьих, чтобы сдвинуть курсор используется метод next(),
     * если он возвращает true, то сдвиг произошел и мы можем получить данные.
     */
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}
