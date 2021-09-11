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
    Set<FileProperty> filePropertySet = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes atts) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file),
                file.getFileName().toString());
        if (!filePropertySet.add(fileProperty)) {
            System.out.println(fileProperty.getName() + " is a duplicate");
        }

        return super.visitFile(file, atts);
    }
}
