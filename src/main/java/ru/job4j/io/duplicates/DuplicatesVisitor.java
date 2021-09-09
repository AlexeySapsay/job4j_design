package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * https://job4j.ru/profile/exercise/45/task-view/315
 * <p>
 * Нужно написать программу, которая принимает на вход
 * папку, просматривает все файлы в ней (и всех подпапках
 * и под-под-...папках) и сообщает, если находит дубликаты.
 * Дубликаты – это два файла с одинаковым именем и размером.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 06.09.2021
 */
public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    int counter = 0;
    List<FileProperty> filePropertyList = new ArrayList<>();
    Map<Path, FileProperty> hashMap = new HashMap<>();
    Map<FileProperty, Integer> hashMapWithCounter = new HashMap<>();

    Set<FileProperty> filePropertySet = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes atts)
            throws IOException {

        FileProperty fileProperty = new FileProperty(Files.size(file),
                file.getFileName().toString());

        if (!filePropertySet.add(fileProperty)) {
            System.out.println(fileProperty.getName() + " is a duplicate");
        }


        // сохраняем file и FileProperty в arrayList
        //filePropertyList.add(fileProperty);

        // сохраняем file и FileProperty в hashMap
        //hashMap.put(file, fileProperty);

        // сохраняем FileProperty в hashMapWithCounter
        // если значение присутствует, то увеличиваем counter на +1
        //hashMapWithCounter.computeIfPresent(fileProperty, (key, count) -> count + 1);

        // сохраняем FileProperty в hashMapWithCounter
        // если значение значение отсутствовало, то помещаем его в мапу
        // и увеличиваем counter +1
        //hashMapWithCounter.putIfAbsent(fileProperty, 1);

        // получаем мапу содержащую дубликаты
        // выводим на печать дубликаты
//        if (counter == 1710) {
//            hashMapWithCounter.entrySet()
//                    .stream()
//                    .filter(e -> e.getValue() > 1)
//                    .forEach(System.out::println);
//        }
//        System.out.println("counter: " + counter);
//        counter++;


        return super.visitFile(file, atts);

    }
}
