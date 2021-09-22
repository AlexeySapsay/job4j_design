package ru.job4j.serialization.xml;
/**
 * https://job4j.ru/profile/exercise/174/task-view/328
 * POJO (Plain Old Java Object) — «старый добрый Java-объект»,
 * простой Java-объект. Термин впервые начал употребляться Мартином
 * Фаулером и его коллегами как результат поиска способов упрощения
 * разработки. Нет формального определения, какие объекты являются POJO,
 * обычно руководствуются следующими соглашениями для класса:
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 16.09.2021
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;

    private Contact contact;

    @XmlElementWrapper
    @XmlElement(name = "status")
    private String[] statuses;

    public Person() {
    }

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

    public static void main(String[] args) throws JAXBException {

        final Person person = new Person(false, 30, new Contact(
                "11-111"), "Worker", "Married");
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(Person.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}