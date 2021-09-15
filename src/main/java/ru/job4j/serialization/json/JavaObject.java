package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * https://job4j.ru/profile/exercise/174/task-view/327
 * JSON сериализация и десериализация
 * Придумайте Java объект, объект должен иметь поля булево,
 * какой-нибудь числовой тип, строковый тип,
 * вложенный объект и массив.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 15.09.2021
 */

public class JavaObject {
    private boolean gender;
    private long salary;
    private String name;
    private final Adress adress;
    private final String[] skills;

    public JavaObject(boolean gender,
                      long salary,
                      String name,
                      Adress adress,
                      String... skills) {
        this.gender = gender;
        this.salary = salary;
        this.name = name;
        this.adress = adress;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JavaObject{"
                + "gender=" + gender
                + ", salary=" + salary
                + ", name='" + name + '\''
                + ", adress=" + adress
                + ", skills=" + Arrays.toString(skills)
                + '}';
    }

    public static void main(String[] args) {
        final JavaObject javaObject = new JavaObject(
                true,
                300000,
                "Alex",
                new Adress("RnD", "000.000.000", "+7 999 756 451"),
                "JavaCore", "GoF Design Patterns", "SQL", "GitHub", "Maven",
                "jUnit", "Intellij Idea", "Checkstyle", "JaCoCo", "Travic CI",
                "Englis(pre- intermediate)", "PostgreSQL");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(javaObject));

        /* Модифицируем json-строку */
        final String javaObjectJson =
                "{"
                        + "\"gender\":false,"
                        + "\"salary\":400000,"
                        + "\"name\":Alex , "
                        + "\"adress\":"
                        + "{"
                        + "\"street\":\"RnD\","
                        + "\"ip\":\"000.000.000\","
                        + "\"mobilePhone\":\"+7 999 756 451\""
                        + "},"
                        + "\"skills\":"
                        + "[\"JavaCore\",\"GoF Design Patterns\",\"SQL\",\"GitHub\""
                        + ",\"Maven\",\"jUnit\",\"Intellij Idea\",\"Checkstyle\",\"JaCoCo\""
                        + ",\"Travic CI\",\"Englis(pre- intermediate)\",\"PostgreSQL\""
                        + ",\"Spring\",\"Hibernate\",\"Kubernetis\"]"
                        + "}";
        final JavaObject javaObjectModified = gson.fromJson(javaObjectJson, JavaObject.class);
        System.out.println(javaObjectModified);
    }
}

