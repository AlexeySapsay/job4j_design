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
        Search searchInstance = new Search();
        // валидация входных параметров
        searchInstance.validation(args);

        // Начальная папка передавалась через аргументы запуска,
        // указываемыми параметроами в  терминале или командной строке.
        Path start = Paths.get(args[0]);
        String word = args[1];

        System.out.println(searchInstance.search(start, p -> p.toFile()
                .getName()
                .endsWith(word)));
    }

    /**
     * Метод рекурсивно обходит дирректорию и добавляет в List
     * файлы, удовлятворяющие условияю condition
     *
     * @param root      дирректория с которой начнется поиск
     * @param condition условие для поиска файлов
     * @return List путей до найденных файлов, удовлетворяющих condition
     * @throws IOException выкидывается в случае, когда все плохо.
     */
    public List<Path> search(Path root, Predicate<Path> condition)
            throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Метод валидации входных параметров, заданных через терминал
     * или командную строку
     *
     * @param argsArr параметры для валидации.
     *                argsArr[0] имя папки с которой начать поиск
     *                argsArr[1] расширение файлов, которые будем искать
     */
    public void validation(String[] argsArr) {
        Path dir = Paths.get(String.valueOf(argsArr[0]));
        if (argsArr.length != 2
                || argsArr[0] == null
                || argsArr[1] == null
                || !Files.exists(dir)) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar dir.jar ROOT_FOLDER."
                            + System.lineSeparator()
                            + "Enter path to dir search and extension of file like:"
                            + System.lineSeparator()
                            + "/some/path extension");
        }
    }
}
