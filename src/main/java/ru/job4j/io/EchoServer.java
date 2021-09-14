package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * https://job4j.ru/profile/exercise/46/task-view/320
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 14.09.2021
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        //Сначала нам нужно создать сервер.
        try (ServerSocket server = new ServerSocket(9000)) {
            //Следующее условие говорит о том, что сервер работает,
            // пока его принудительно не закроют
            while (!server.isClosed()) {
                //ServerSocket создает сервер. Чтобы клиент мог узнать,
                // где находится сервер ему нужен адрес и порт.
                // По аналогии с людьми мы обращаемся по имени,
                // чтобы начать разговор.
                //
                //9000 - это порт. По умолчанию адрес будет localhost.
                //server.acсept - ожидает, когда к нему обратиться клиент.
                // Программа переходит в режим ожидания.
                Socket socket = server.accept();
                //Когда клиент обратился к серверу программа получает
                // входной поток и может отправить данные в выходной поток.
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String string = in.readLine();
                    String serverAnswer = "";
                    String[] bufferArray = new String[0];
                    if (!string.isEmpty() && string.contains("?msg=")) {
                        bufferArray = string.split(" ");
                    }
                    // Если "Bye" то завершаем соединение и закрываем сервер
                    if (bufferArray[1].substring(6).equals("Bye")) {
                        serverAnswer = "Byeeeeeeeee!\r\n\r\n";
                        out.write(serverAnswer.getBytes());
                        out.flush();
                        server.close();
                    }

                    //В ответ мы записываем строчку.
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    //В программе читается весь входной поток.
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    //После чтения отправляем ответ окончательно.
                    out.flush();
                }
            }
        }
    }
}

