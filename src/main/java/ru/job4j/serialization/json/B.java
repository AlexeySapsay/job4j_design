package ru.job4j.serialization.json;

import org.json.JSONObject;
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
