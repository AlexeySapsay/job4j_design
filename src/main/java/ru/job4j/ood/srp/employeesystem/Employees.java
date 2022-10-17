package ru.job4j.ood.srp.employeesystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Модель формирования отчетов с сереализацией в XML
 * с возможностью сериализации и десиариализации
 *
 * @author Alexey Sapsay (sapsayalexey@gmail.com)
 * @version 2.0
 * @since 17.10.2022
 */
@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    @XmlElement(name = "employees")
    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

}
