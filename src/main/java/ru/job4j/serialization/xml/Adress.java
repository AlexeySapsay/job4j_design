package ru.job4j.serialization.xml;

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
public class Adress {
    private final String street;

    public Adress(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Adress{"
                + "street='" + street + '\''
                + '}';
    }
}
