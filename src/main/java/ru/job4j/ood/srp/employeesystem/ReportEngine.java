package ru.job4j.ood.srp.employeesystem;

import java.util.function.Predicate;

import static ru.job4j.ood.srp.employeesystem.Constants.DATE_FORMAT;
import static ru.job4j.ood.srp.employeesystem.Constants.SYSLIN;

/**
 * Класс формирующий отчеты
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 15.10.2022
 */
public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(SYSLIN);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(SYSLIN);
        }
        return text.toString();
    }
}