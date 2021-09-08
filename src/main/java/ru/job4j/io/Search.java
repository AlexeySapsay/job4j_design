package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://job4j.ru/profile/exercise/45/task-view/314
 * https://job4j.ru/profile/exercise/45/task-view/316
 * <p>
 * Разработайте программу Search, которая будет искать
 * файлы только по определенному предикату.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 04.09.2021
 */

public class Search {
    public static void main(String[] args) throws IOException {
        // валидация входных параметров
        validation((args[0]), args[1]);

        // чтобы начальная папка передавалась через аргументы запуска
        // указываемый параметры в  терминале или командной строке.
        Path start = Paths.get(args[0]);
        String word = args[1];

        System.out.println(search(start, p -> p.toFile()
                .getName()
                .endsWith(word)));
    }

    public static List<Path> search(Path root, Predicate<Path> condition)
            throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Метод валидации входных параметров, заданных через терминал
     * или командную строку
     * @param first имя папки с которой начать поиск
     * @param second расширение файлов, которые будем искать
     */
    public static void validation(String first, String second) {
        if (first.length() == 0 || second.length() == 0) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar dir.jar ROOT_FOLDER."
                            + System.lineSeparator()
                            + "Enter path to dir search and extension of file like:"
                            + System.lineSeparator()
                            + "/some/path extension");
        }
    }
}
