package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Изучение работы с потоками ввода- вывода
 * Чтение файла логов и определения периодов недоступности
 * сервера
 * https://job4j.ru/profile/exercise/45/task-view/311
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 01.09.2021
 */

public class Analizy {
    /**
     * Метод определяет перид недоступности сервера.
     * Сервер не работал, если status = 400 или 500.
     * Диапазоном считается последовательность статусов 400 и 500
     * <p>
     * Сервер не работал, если status = 400 или 500. Диапазоном считается последовательность статусов 400 и 500
     * <p>
     * Пример #1:
     * <p>
     * 200 10:56:01
     * 500 10:57:01
     * 400 10:58:01
     * 200 10:59:01
     * 500 11:01:02
     * 200 11:02:02
     * <p>
     * тут два периода - 10:57:01 до 10:59:01 и 11:01:02 до 11:02:02. Поэтому результат должен быть:
     * <p>
     * 10:57:01;10:59:01;
     * 11:01:02;11:02:02;
     * <p>
     * Начальное время - это время когда статус 400 или 500. Конечное время это когда статус меняется с
     * 400 или 500 на 200 или 300.
     *
     * @param source путь к файлу логов.
     * @param target имя целевого файла, путь к файлу результата анализа.
     */
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public void unavailable(String source, String target) {
        // чтение файла с логами
        List<String> buffer = new ArrayList<>();
        List<String> unavailableLogList = new ArrayList<>();
        List<String> unavailableLogListTimeStamp = new ArrayList<>();

        //  читаем фильтруем условия отключения сервера и выводим на консоль
        //  и пишем в буфер для дальнейшей фильтрации.
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                List<String> lineSplited = Arrays.asList(line.split(" "));
                buffer.add(lineSplited.get(0));
                buffer.add(lineSplited.get(1));
                //System.out.println(lineSplited.get(0) + " " + lineSplited.get(1));
            }

            // Фильтр, извлекает значения из buffer и добавляем в unavailableLogList
            // Сервер не работал, если status = 400 или 500.
            // Диапазоном считается последовательность статусов 400 и 500
            // формирование периодов недоступности сервера
            for (int i = 0; i < buffer.size(); i++) {
                boolean flagNextAdd = false;
                if (buffer.get(i).equals("400")
                        || buffer.get(i).equals("500")) {
                    unavailableLogList.add(buffer.get(i + 1));
                    flagNextAdd = true;
                }
                if (flagNextAdd
                        && !buffer.get(i + 2).equals("400")
                        && !buffer.get(i + 2).equals("500")) {
                    unavailableLogList.add(buffer.get(i + 3));
                    unavailableLogList.add("\n");
                }
            }

            // выделение начала и конца периода недоступности сервера
            // удаление промежуточных значений между концом и началом периода
            unavailableLogListTimeStamp.add(unavailableLogList.get(0));
            for (int i = 0; i < unavailableLogList.size(); i++) {
                if (unavailableLogList.get(i).equals("\n")) {
                    unavailableLogListTimeStamp.add(unavailableLogList.get(i - 1));
                    if (i + 1 < unavailableLogList.size()) {
                        unavailableLogListTimeStamp.add(unavailableLogList.get(i + 1));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // запись отфильтрованных логов в target файл
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (int i = 0; i < unavailableLogListTimeStamp.size(); i += 2) {
                out.append(unavailableLogListTimeStamp.get(i)).append(";");
                out.append(unavailableLogListTimeStamp.get(i + 1)).append(";")
                        .append(System.lineSeparator());
                //out.append(System.lineSeparator());
                //out.append(System.lineSeparator());
                //System.out.println();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("serverLogsUnavailable1.txt", "unavailable1.csv");

        System.out.println("Done!");
    }
}