package ru.job4j.serialization.xml;

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
