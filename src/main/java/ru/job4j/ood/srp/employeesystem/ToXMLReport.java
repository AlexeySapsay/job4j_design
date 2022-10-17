package ru.job4j.ood.srp.employeesystem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

/**
 * Модель формирования отчетов с сереализацией в XML
 * с возможностью сериализации и десиариализации
 *
 * @author Alexey Sapsay (sapsayalexey@gmail.com)
 * @version 2.0
 * @since 17.10.2022
 */
public class ToXMLReport implements Report {
    private final Store store;
    private final JAXBContext context;
    private final Marshaller marshaller;

    public ToXMLReport(Store store) {
        this.store = store;
        try {
            this.context = JAXBContext.newInstance(Employees.class);
            this.marshaller = context.createMarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var xml = "";
        try {
            marshaller.setProperty(
                    Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            try (var writer = new StringWriter()) {
                marshaller.marshal(new Employees(
                        store.findBy(filter)), writer);
                xml = writer.getBuffer().toString();
            }
        }  catch (IOException | JAXBException ex) {
            ex.printStackTrace();
        }
        return xml;
    }
}
