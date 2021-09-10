package ru.job4j.io;

import java.io.*;
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
    public void run() {
        List<String> botAnswersList = new ArrayList<>();
        botAnswersList = readPhrases();

        // генератор случайных ответов на фразы пользователя
        int randomNum = ThreadLocalRandom.current().nextInt(1, botAnswersList.size());
        //System.out.println(randomNum);
        System.out.println(botAnswersList.get(randomNum));


        // читаем сообщение из консоли
        // И делаем проверку на управляющие фразу

        // выводим рандомную фразу из буфера фраз

        // если управляющих враз не найденно
        // продолжаем работу


//        for (String fraze : botAnswersList) {
//            System.out.println(fraze);
//        }

        // при завершении работы записываем лог в файл
        saveLog(Collections.singletonList(path));
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

    }

    private List<String> talkWithUser() {
        List<String> listUserPhrase = new ArrayList<>();
//        InputStream stream = System.in;
//        Scanner console = new Scanner(stream);
//        String line = console.nextLine();
//        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)))) {
//        }))) {
////            InputStream stream = System.in;
////            InputStreamReader reader = new InputStreamReader(stream);
////            BufferedReader bufferedReader = new BufferedReader(reader);
////            String line = bufferedReader.readLine();
////            return line;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try (BufferedReader obj = new BufferedReader(
                new InputStreamReader(System.in))) {
            String str;
            System.out.println("Enter lines of text");
            System.out.println("Enter 'stop' to quit");
            do {
                str = obj.readLine();
                System.err.println(str);
            } while (!str.equals("stop"));
            return listUserPhrase;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String path = "C:\\projects\\job4j_design\\data\\DialogLog.txt";
        String botAnswers = "C:\\projects\\job4j_design\\data\\phraseForChatBot.txt";
        ConsoleChat cc = new ConsoleChat(path, botAnswers);
        cc.run();
    }
}
