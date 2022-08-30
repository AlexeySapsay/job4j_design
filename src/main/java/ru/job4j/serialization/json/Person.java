package ru.job4j.serialization.json;

import org.json.JSONObject;

import java.util.Arrays;
public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public boolean getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public static void main(String[] args) {
        final Person person = new Person(false,
                30, new Contact("11-111"),
                "Worker", "Married");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.getSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", person.getContact());
        jsonObject.put("statuses", person.getStatuses());
        System.out.println(jsonObject);
        System.out.println(new JSONObject(person));
    }
}
