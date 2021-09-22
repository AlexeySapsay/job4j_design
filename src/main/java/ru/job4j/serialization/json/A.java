package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;
/**
 * https://job4j.ru/profile/exercise/174/task-view/330
 * JSON сериализация и десериализация
 * Преобразование JSON в POJO. JsonObject
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 22.09.2021
 */

public class A {
    private B b;

    @JSONPropertyIgnore
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getHello() {
        return "Hello";
    }
}
