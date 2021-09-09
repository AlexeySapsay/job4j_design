package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        // видимо понадобится добавить сканер
        // нет добавляем запрос данных из args

        Path start = Path.of("./");
        Files.walkFileTree(start, new DuplicatesVisitor());


    }
}
