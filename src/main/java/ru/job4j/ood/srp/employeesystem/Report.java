package ru.job4j.ood.srp.employeesystem;

import java.util.function.Predicate;

/**
 * Интерфейс, содержащий метод генерации отчетной формы
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 15.10.2022
 */
public interface Report {
    String generate(Predicate<Employee> filter);
}