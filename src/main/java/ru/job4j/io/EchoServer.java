package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://job4j.ru/profile/exercise/46/task-view/320
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 14.09.2021
 */
public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String string = in.readLine();
                    String serverAnswer = "";
                    String[] bufferArray = new String[0];
                    boolean serverClose = false;

                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    while (!(string).isEmpty()) {
                        System.out.println(string);
                        if (string.contains("?msg=")) {
                            bufferArray = string.split(" ");
                            if (bufferArray[1].substring(6).equals("Exit")) {
                                serverAnswer = "Byeeeeeeeee!";
                                serverClose = true;
                            } else if (bufferArray[1].substring(6).equals("Hello")) {
                                serverAnswer = "Hello";
                            } else {
                                serverAnswer = "What";
                            }
                        }
                        string = in.readLine();
                    }
                    out.write(serverAnswer.getBytes());
                    if (serverClose) {
                        server.close();
                    }
                } catch (Exception e) {
                    LOG.error("Exception in log example: ", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example: ", e);
        }
    }
}

