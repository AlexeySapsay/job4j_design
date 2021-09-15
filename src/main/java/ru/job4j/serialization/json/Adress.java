package ru.job4j.serialization.json;

import java.io.Serializable;

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
public class Adress implements Serializable {
    private final String street;
    private final String ip;
    private final String mobilePhone;

    public Adress(String street, String ip, String mobilePhone) {
        this.street = street;
        this.ip = ip;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "Adress{"
                + "street='" + street + '\''
                + ", ip='" + ip + '\''
                + ", mobilePhone='" + mobilePhone + '\''
                + '}';
    }
}
