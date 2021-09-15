package ru.job4j.serialization.json;
/**
 * https://job4j.ru/profile/exercise/174/task-view/327
 JSON сериализация и десериализация
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 15.09.2021
 */
public class Contact {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}