package ru.job4j.ood.srp.metheostation;

import java.sql.Timestamp;

/**
 * OCP практика на примере калькулятора матриц
 *
 * @author Alexey Sapsay
 * @version 1.0
 * @since 16.10.2022
 */
public class WiHuTePrTime {
    private float windSpeed = 0;
    private float humidity = 0;
    private float temperatureCelsius = 0;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public double measureWindSpeed(ConnectionToSensor windSpeedSensor) {
        return windSpeedSensor.measureWind();
    }

    public double measureHumidity(ConnectionToSensor humiditySensor) {
        return humiditySensor.measureHumidity();
    }

    public double measureTemperature(ConnectionToSensor temperatureSensor) {
        return temperatureSensor.measureTemperature();
    }

    public WiHuTePrTime(float windSpeed,
                        float humidity,
                        float temperatureCelsius,
                        Timestamp timestamp) {
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.temperatureCelsius = temperatureCelsius;
        this.timestamp = timestamp;
    }

    public static void saveToDB() {
        /**
         * save measure object in DB
         */
    }
}