package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlRootElement(name = "contact")
public class Contact {
    @XmlAttribute
    private String phone;

    public Contact() {
    }

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
