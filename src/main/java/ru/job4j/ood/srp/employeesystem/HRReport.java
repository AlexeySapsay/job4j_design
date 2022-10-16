package ru.job4j.ood.srp.employeesystem;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static ru.job4j.ood.srp.employeesystem.Constants.SYSLIN;

public class HRReport implements Report {

    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(SYSLIN);

        for (Employee employee : sortedSalary(store.findBy(filter))) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(SYSLIN);
        }
        return text.toString();
    }

    private List<Employee> sortedSalary(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        return employeeList;
    }
}
