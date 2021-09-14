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
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String string = in.readLine();
                    String serverAnswer = "";
                    String[] bufferArray = new String[0];
                    if (!string.isEmpty() && string.contains("?msg=")) {
                        bufferArray = string.split(" ");
                    }
                    if (bufferArray[1].substring(6).equals("Bye")) {
                        serverAnswer = "Byeeeeeeeee!\r\n\r\n";
                        out.write(serverAnswer.getBytes());
                        out.flush();
                        server.close();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}

