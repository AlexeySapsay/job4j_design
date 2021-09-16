package ru.job4j.serialization.xml;

import java.util.Arrays;

/**
 * https://job4j.ru/profile/exercise/174/task-view/328
 * XML — расширяемый язык разметки. Данный язык очень похож на HTML, только в отличии от него является расширяемым, что
 * <p>
 * значит, мы можем писать свои теги, а не использовать зарезервированные.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 16.09.2021
 */
public class People {
    private final boolean sex;
    private final int age;
    private final String degree;
    private final Adress adress;
    private final String[] children;

    public People(boolean sex,
                  int age,
                  String degree,
                  Adress adress,
                  String... children) {
        this.sex = sex;
        this.age = age;
        this.degree = degree;
        this.adress = adress;
        this.children = children;
    }

    @Override
    public String toString() {
        return "People{"
                + "sex=" + sex
                + ", age=" + age
                + ", degree='" + degree + '\''
                + ", adress=" + adress
                + ", children=" + Arrays.toString(children)
                + '}';
    }

    public static void main(String[] args) {
        People people1 = new People(true, 50,
                "Master", new Adress("Baker Street"),
                "Jonik", "Eva", "Linda");

    }
}


