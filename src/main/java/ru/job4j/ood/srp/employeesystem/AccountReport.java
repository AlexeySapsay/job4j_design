package ru.job4j.ood.srp.employeesystem;

import java.util.function.Predicate;

import static ru.job4j.ood.srp.employeesystem.ReportEngine.DATE_FORMAT;

/**
 * Класс формирующий отчеты
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 15.10.2022
 */
public class AccountReport implements Report {

    private final Store store;

    public AccountReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(salaryWithoutTaxCalc(employee)).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static double salaryWithoutTaxCalc(Employee employee) {
        double dollarCurrency = 66.0;
        double tax = 0.13;
        double employeeSalaryRUB = employee.getSalary() * dollarCurrency;

        return (employeeSalaryRUB - (employeeSalaryRUB * tax));
    }
}
