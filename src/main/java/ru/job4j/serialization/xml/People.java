package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * https://job4j.ru/profile/exercise/174/task-view/328
 * XML — расширяемый язык разметки. Данный язык очень похож на HTML, только в отличии от него является расширяемым, что
 * <p>
 * значит, мы можем писать свои теги, а не использовать зарезервированные.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 16.09.2021
 */

@XmlRootElement(name = "People")
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
    @XmlElement(name = "sex")
    private final boolean sex;

    @XmlElement(name = "age")
    private final int age;

    @XmlElement(name = "degree")
    private final String degree;

    @XmlElement(name = "adress")
    private final Adress adress;

    @XmlElementWrapper(name = "children")
    @XmlElement(name = "child")
    private final String[] children;

    public People(boolean sex,
                  int age,
                  String degree,
                  Adress adress,
                  String... children) {
        this.sex = sex;
        this.age = age;
        this.degree = degree;
        this.adress = adress;
        this.children = children;
    }

    @Override
    public String toString() {
        return "People{"
                + "sex=" + sex
                + ", age=" + age
                + ", degree='" + degree + '\''
                + ", adress=" + adress
                + ", children=" + Arrays.toString(children)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        People people1 = new People(true, 50,
                "Master", new Adress("Baker Street"),
                "Jonik", "Eva", "Linda");

        JAXBContext context = JAXBContext.newInstance(People.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result = "";

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(people1, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            People unmarshalPeople = (People) unmarshaller.unmarshal(reader);
            System.out.println(unmarshalPeople);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


