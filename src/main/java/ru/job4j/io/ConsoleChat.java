package ru.job4j.io;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
     */
    public void run() throws IOException {
        List<String> botAnswersList = new ArrayList<>();
        botAnswersList = readPhrases();


        //не плохой вариат но не работает со всеми маркерами
//        while (true) {
//            List<String> userAnswer = talkWithUser();
//            System.out.println(userAnswer);
//
//            генератор случайных ответов на фразы пользователя
//            int randomNum = ThreadLocalRandom.current().nextInt(1, botAnswersList.size());
//            //System.out.println(randomNum);
//            System.out.println(botAnswersList.get(randomNum));
//
//        }


        // читаем сообщение из консоли
        // И делаем проверку на управляющие фразу

        // выводим рандомную фразу из буфера фраз

        // если управляющих враз не найденно
        // продолжаем работу
        //String str;

//        try (BufferedReader obj = new BufferedReader(new InputStreamReader(System.in))) {
//            str = "";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            // читаем фразу пользователя
            str = obj.readLine();
            stringBuilder.append(System.lineSeparator() + str);
            while (str.contains(STOP)) {
                str = obj.readLine();
                stringBuilder.append(System.lineSeparator() + str);
                while (!str.contains(CONTINUE)) {
                    str = obj.readLine();
                    stringBuilder.append(System.lineSeparator() + str);
                }
            }
            // генератор случайных ответов на фразы пользователя
            int randomNum = ThreadLocalRandom.current().nextInt(1, botAnswersList.size());
            String answerBot = botAnswersList.get(randomNum);
            System.out.println(answerBot);
            stringBuilder.append(System.lineSeparator() + answerBot);

        } while (!str.contains(OUT));
        // читам здесь стринг билдер и пишем его в файл! Вуаля!!! хахахах
        //System.out.println(stringBuilder.toString());
        // при завершении работы записываем лог в файл
        //saveLog(Collections.singletonList(path));

        saveLog(Collections.singletonList(stringBuilder.toString()));
    }

    /**
     * readPhrases(), читает фразы из файла
     *
     * @return возвращает лист фраз ответов для бота
     */
    private List<String> readPhrases() {
        List<String> botAnswersList = new ArrayList<>();
        //прочитали файла и записали в botAnswersList
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
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Файл сохранен!");
    }

//    private List<String> talkWithUser() {
//        List<String> listUserPhrase = new ArrayList<>();
//        try (BufferedReader obj = new BufferedReader(
//                new InputStreamReader(System.in))) {
//            String str;
//
//            do {
//                str = obj.readLine();
//                System.err.println(str);
//            } while (!str.equals("закончить"));
//            return listUserPhrase;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listUserPhrase;
//    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\projects\\job4j_design\\data\\DialogLog.txt";
        String botAnswers = "C:\\projects\\job4j_design\\data\\phraseForChatBot.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        cc.run();
    }
}
