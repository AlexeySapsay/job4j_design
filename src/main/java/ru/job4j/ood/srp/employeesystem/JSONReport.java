package ru.job4j.ood.srp.employeesystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

/**
 * Модель формирования отчетов с сереализацией в JSON
 * с возможностью сериализации и десиариализации
 *
 * @author Alexey Sapsay (sapsayalexey@gmail.com)
 * @version 2.0
 * @since 17.10.2022
 */

public class JSONReport implements Report {
    private final Store store;
    private Gson gson;

    public JSONReport(Store store) {
        this.store = store;
        try {
            this.gson = new GsonBuilder().create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gson.toJson(store.findBy(filter));
    }
}
