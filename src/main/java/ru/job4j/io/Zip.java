package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
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
    public static void packFiles(List<File> sources, File target) {

    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void validationArgsAndDir(String[] args, Path dirPath) {
        // Валидация агрументов. В args должно присутствовать 4 аргумента
        if (args.length != 4) {
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
        ArgsName.validation(args);
//        ArgsName.of(args).;
        //ArgsName.
        // Валидация существования архивируемой дирректориии.
    }

    public static void main(String[] args) {
        packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
    }
}
