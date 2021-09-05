package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * https://job4j.ru/profile/exercise/45/task-view/314
 * <p>
 * Разработайте программу Search, которая будет искать
 * файлы только по определенному предикату.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 04.09.2021
 */
public class SearchFiles implements FileVisitor<Path> {
    Predicate<Path> predicate;
    List<Path> pathList = new ArrayList<>();

    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    /**
     * Ищет файл или дерикторию
     * @param file возвращает путь к файлу или деректории
     * @param attrs атрибуты создания файла или дериктории, дата создания,
     *              размер и т.д
     * @return возвращает путь к файлу
     * @throws IOException исключение ввода- вывода
     */
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        if (predicate.test(Paths.get((file.getFileName().toString())))) {
            pathList.add(Paths.get((file.getFileName().toString())));
            return CONTINUE;
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    /**
     * Метод получаения путь для подходящего по предикату
     *
     * @return возвращает путь до подвходящего по
     * предикату файла.
     */
    public List<Path> getPaths() {
        return pathList;
    }
}
