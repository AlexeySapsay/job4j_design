package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
     * после сохраняет диалог в txt файле.
     */
    public void run() {
        List<String> botAnswersList = readPhrases();
        StringBuilder stringBuilder = new StringBuilder();
        String str;

        try (BufferedReader obj = new BufferedReader(new InputStreamReader(System.in))) {
            do {
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

                int randomNum = (int) (Math.random() * botAnswersList.size());
                String answerBot = botAnswersList.get(randomNum);
                System.out.println(answerBot);
                stringBuilder.append(System.lineSeparator()).append(answerBot);

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
