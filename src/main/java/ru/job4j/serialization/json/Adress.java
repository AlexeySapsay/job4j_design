package ru.job4j.serialization.json;

import java.io.Serializable;

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
