package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
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
        DuplicatesFinder duplicatesFinder = new DuplicatesFinder();
        duplicatesFinder.validate(args);

        Path start = Path.of(args[0]);
        Files.walkFileTree(start, new DuplicatesVisitor());
    }

    private void validate(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "You have a mistake in line:"
                            + System.lineSeparator()
                            + "Use : java -jar duplicatesFinder.jar directoryName_for_scan");
        }
        try {
            if (!Files.exists(Path.of(args[0]))) {
                throw new Exception("Directory not found: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
