package ru.job4j.jdbc;

/**
 * https://job4j.ru/profile/exercise/55/task-view/346
 * Изучение работы с JDBC. Подключение JDBC и чтение файла app.properties
 * в качестве настроечного файла. Ранее мы говорили про Statement.
 * В этом уроке мы познакомимся с PrepareStatement.
 * Данный класс в отличии от Statement предназначен для DML операций
 * – INSERT, SELECT, UPDATE, DELETE.
 * <p>
 * Реализовать методы каркасного класса
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 04.10.2021
 */

public class City {
    private int id;
    private String name;
    private int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
