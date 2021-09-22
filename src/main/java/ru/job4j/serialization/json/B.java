package ru.job4j.serialization.json;

import org.json.JSONObject;

/**
 * https://job4j.ru/profile/exercise/174/task-view/330
 * JSON сериализация и десериализация
 * Преобразование JSON в POJO. JsonObject
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 22.09.2021
 */

public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void set(A a) {
        this.a = a;
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.set(a);

        System.out.println(new JSONObject(b));
    }
}
