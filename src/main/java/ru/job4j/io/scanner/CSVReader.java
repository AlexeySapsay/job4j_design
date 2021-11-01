package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

/**
 * https://job4j.ru/profile/exercise/45/task-view/786
 * <p>
 * 1. Ознакомиться с форматом CSV.
 * <p>
 * 2. Создать класс CSVReader. Задача класса прочитать данные из CSV файла и
 * вывести их.
 * В качестве входных данных задается путь к файлу path, разделитель delimiter,
 * приемник данных out и фильтр по столбцам filter. Ключ -out имеет только два
 * <p>
 * допустимых значения stdout или путь к файлу, куда нужно вывести. Например,
 * если есть файл CSV со столбцами name, age, birthDate, education, children и
 * программа запускается таким образом:
 * <p>
 * java -jar target/csvReader.jar -path=file.csv -delimiter=";"  -out=stdout -filter=name,age
 * <p>
 * то программа должна прочитать файл по пути file.txt и вывести только столбцы name,
 * age в консоль. В качестве разделителя данных выступает ;
 *
 * @since 13.09.2021
 */

public class CSVReader {
/**
 * public static void handle(ArgsName argsName) throws Exception {
 *     return;
 * }
 */
}
