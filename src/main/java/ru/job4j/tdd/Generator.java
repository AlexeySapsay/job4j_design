package ru.job4j.tdd;

import java.util.Map;

/**
 * https://job4j.ru/profile/exercise/63/task-view/381
 * 2. Программа должна учитывать, что в шаблоне есть ключи,
 * которых нет в карте и кидать исключение.
 *
 * 3. Программа должна учитывать, что в карте есть
 * лишние ключи и тоже кидать исключение.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 05.01.2022
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}

