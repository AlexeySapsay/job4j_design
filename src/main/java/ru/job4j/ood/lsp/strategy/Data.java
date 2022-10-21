package ru.job4j.ood.lsp.strategy;

import java.util.Objects;

/**
 * LSP практика на примере логистической компании
 * реализация шаблона стратегия
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 22.10.2022
 */

public class Data {
    private int distance;
    private float fuelUsage;
    private int popularity;

    public Data(int distance, float fuelUsage, int popularity) {
        this.distance = distance;
        this.fuelUsage = fuelUsage;
        this.popularity = popularity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getFuelUsage() {
        return fuelUsage;
    }

    public void setFuelUsage(float fuelUsage) {
        this.fuelUsage = fuelUsage;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return distance == data.distance
                && Float.compare(data.fuelUsage, fuelUsage) == 0
                && popularity == data.popularity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, fuelUsage, popularity);
    }

    @Override
    public String toString() {
        return "Data{" + "distance=" + distance
                + ", fuelUsage=" + fuelUsage
                + ", popularity=" + popularity + '}';
    }
}
