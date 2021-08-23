package ru.job4j.collection;

import java.util.Date;

/**
 * Модель User
 * Задача: Создать модель User и три поля String name,
 * int children, Calendar birthday.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 0.1
 * @since 23.08.2021
 */
public class User {
    private String name;
    private int children;
    private Date calendarBirthday;

    public User(String name, int children, Date calendarBirthday) {
        this.name = name;
        this.children = children;
        this.calendarBirthday = calendarBirthday;
    }
}
