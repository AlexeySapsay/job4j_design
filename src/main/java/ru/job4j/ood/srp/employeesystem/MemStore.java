package ru.job4j.ood.srp.employeesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Хранилище в памяти данных о работниках
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 15.10.2022
 */
public class MemStore implements Store {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void add(Employee em) {
        employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}