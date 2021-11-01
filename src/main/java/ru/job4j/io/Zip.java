package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * https://job4j.ru/profile/exercise/45/task-view/318
 * <p>
 * Утилита для архивации папки.
 * 1. При запуске указывается папка, которую мы хотим архивировать, например: c:\project\job4j\
 * 2. В качестве ключа передается  расширения файлов, которые не нужно включать в архив.
 * 3. Архив должен сохранять структуру проекта. То есть содержать подпапки.
 * 4. Запуск проекта.
 * <p>
 * java -jar pack.jar -d=c:\project\job4j\ -e=class -o=project.zip
 * <p>
 * -d - directory - которую мы хотим архивировать
 * -e - exclude - исключить файлы *.xml
 * -o - output - во что мы архивируем.
 * <p>
 * 5. Для работы с входными аргументами используйте класс ArgsName из прошлого задания.
 * Важно! Перед запуском проекта нужно делать валидацию аргументов, проверив что они все присутствуют. Также нужно проверить, что архивируемая директория существует.
 * <p>
 * 6. Для архивации использовать классы ZipOutputStream.java. Создайте класс Zip.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 09.09.2021
 */
public class Zip {
    private static List<Path> fileList = new ArrayList<>();

    /**
     * Метод получает arrayList файлов для упаковки и поочередно упаковывает
     * каждый файл
     *
     * @param sources возможно лист файлов, найденный Search
     * @param target  файл после упаковки
     */
    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(String.valueOf(target))))) {
            for (Path file : sources) {
                zip.putNextEntry(new ZipEntry(file.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(file)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * В метод передаю единичный файл, на выходе получаю его зип архив
     *
     * @param source источник, файл для архивации
     * @param target целевой, файл после архивации
     */
    public static void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(String.valueOf(source)))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Валидация входных параметров, именнованных аргументов и пути директории
     *
     * @param args    массив String именнованных аргументов, получаемых
     *                с консоли
     * @param dirPath путь к директории, для архивации
     * @throws FileNotFoundException исплючение,
     *                               когда директория не существует
     */
    public static void validationArgsAndDir(String[] args, Path dirPath) throws IOException {
        /**
         * Валидация агрументов. В args должно присутствовать 3 аргумента
         */
        if (args.length != 3) {
            throw new IllegalArgumentException(" Arguments is not correct:"
                    + System.lineSeparator()
                    + "Example:"
                    + System.lineSeparator()
                    + "java -jar pack.jar -d=c:\\project\\job4j\\ -e=class -o=project.zip"
                    + System.lineSeparator()
                    + "-d - directory - которую мы хотим архивировать"
                    + System.lineSeparator()
                    + " -e - exclude - исключить файлы *.xml"
                    + System.lineSeparator()
                    + "-o - output - во что мы архивируем.");
        }
        /**
         *Валидация существования архивируемой дирректориии.
         */
        if (!dirPath.toFile().isDirectory()) {
            throw new FileNotFoundException("The Director or file not exist");
        }
        /**
         * Валидация корректности расположения аргументов
         */
        ArgsName argsName = new ArgsName();
        ArgsName argsMap = argsName.of(args);
        Set<String> argsKeysSet = argsMap.getKeys();
        for (String key : argsKeysSet) {
            if (!"d".equals(key) && !"e".equals(key) && !"o".equals(key)) {
                throw new IllegalArgumentException("Use like: "
                        + System.lineSeparator()
                        + "-d= directory for arhivation, -e= exclude files, -o= output file name ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = new ArgsName();
        ArgsName argsMap2 = argsName.of(args);
        validationArgsAndDir(args, Path.of(argsMap2.get("d")));

        Search search = new Search();
        fileList = search.search(Path.of(argsMap2.get("d")),
                p -> !p.toFile().getName().endsWith(argsMap2.get("e")));
        Zip zip = new Zip();
        zip.packFiles(fileList, Path.of(argsName.of(args).get("o")));
    }
}
