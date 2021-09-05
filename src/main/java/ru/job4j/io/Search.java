package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

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

public class Search {
//        public static void main(String[] args) throws IOException {
//        Path start = Paths.get(".");
//        Files.walkFileTree(start, new PrintFiles());
//    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
//        search(start, p -> p.toFile()
//                .getName()
//                .endsWith("js"))
//                .forEach(System.out::println);
        search(start, p -> p.toFile()
                .getName()
                .endsWith("js"));
                //.forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition)
            throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
