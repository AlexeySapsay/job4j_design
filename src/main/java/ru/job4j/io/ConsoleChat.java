package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://job4j.ru/profile/exercise/45/task-view/319
 * Изучение работы с потоками ввода- вывода.
 * Кодировка UTF-8
 * <p>
 * 1. В этом задании необходимо создать программу 'Консольный чат'.
 * Некоторое описание:
 * <p>
 * - пользователь вводит слово-фразу, программа берет случайную фразу
 * из текстового файла и выводит в ответ.
 * - программа замолкает если пользователь вводит слово «стоп», при этом
 * он может продолжать отправлять сообщения в чат.
 * - если пользователь вводит слово «продолжить», программа снова начинает
 * отвечать.
 * - при вводе слова «закончить» программа прекращает работу.
 * - запись диалога, включая слова-команды стоп/продолжить/закончить должны
 * быть записаны в текстовый лог.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 10.09.2021
 */

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    /**
     * run(), содержит логику чата;
     * Читаем фразы пользователя.
     * после сохраняем диалов в txt файле.
     */
    public void run() {
        List<String> botAnswersList = readPhrases();
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        try (BufferedReader obj = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                // читаем фразу пользователя, пока не введено управляющее слово
                str = obj.readLine();
                stringBuilder.append(System.lineSeparator()).append(str);

                if (str.contains(STOP)) {
                    str = obj.readLine();
                    stringBuilder.append(System.lineSeparator()).append(str);
                    while (!str.contains(CONTINUE)) {
                        str = obj.readLine();
                        stringBuilder.append(System.lineSeparator()).append(str);
                    }
                }

                // генератор случайных ответов на фразы пользователя
                int randomNum = ThreadLocalRandom.current().nextInt(1, botAnswersList.size());
                String answerBot = botAnswersList.get(randomNum);
                System.out.println(answerBot);
                stringBuilder.append(System.lineSeparator()).append(answerBot);
                //находим "закончить" true+true= true, делаем !true = false, завершит цилк на out слове
            } while (!(str.trim().length() == 9 && str.contains(OUT)));

            System.out.println("str.length(): " + str.length());
            saveLog(Collections.singletonList(stringBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * readPhrases(), читает фразы из файла
     * прочитали файл и записали в botAnswersList
     *
     * @return возвращает лист фраз ответов для бота
     */
    private List<String> readPhrases() {
        List<String> botAnswersList = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            in.lines().forEach(botAnswersList::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botAnswersList;
    }

    /**
     * saveLog(), сохраняет лог чата в файл.
     *
     * @param log лог для сохранения
     */
    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл сохранен!");
    }

    public static void main(String[] args) {
        String path = ".\\data\\DialogLog.txt";
        String botAnswers = ".\\data\\phraseForChatBot.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        cc.run();
    }
}
