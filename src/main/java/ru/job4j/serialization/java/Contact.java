package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact contact = (Contact) o;

        if (zipCode != contact.zipCode) {
            return false;
        }
        return phone != null ? phone.equals(contact.phone) : contact.phone == null;
    }

    @Override
    public int hashCode() {
        int result = zipCode;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123568, "+7 (111) 111-11-11");

        /* Запись объекта во временный файл, который удалится системой */
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
        }

        /* Чтение объекта из файла */
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
            System.out.println("contact.equals(contactFromFile): "
                    + contact.equals(contactFromFile));
        }

    }
}

