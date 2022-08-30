package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * метод читает файл базу спамеров и возвращает List Users- спаммеров
     * @return возвращает List Users- спаммеров
     * @throws IOException в случае когда что- то пошло не по плану
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(string -> {
                String[] buffer = string.split(";");
                if (buffer.length != 2) {
                    throw new IllegalArgumentException();
                }
                users.add(new User(buffer[0], buffer[1]));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Метод устанавливает соединение с базой данных,
     * параметры соединения получаются из файла app2.properties
     * И спамеры сохраняются в базу данных spammer, таблица users
     *
     * @param users - лист спамеров для сохранения в базе данных
     * @throws ClassNotFoundException когда класс не найдет
     * @throws SQLException если sql запрос невозможно выполнить
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users (name, email) values(?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "ImportDB{"
                + "cfg=" + cfg
                + ", dump='" + dump + '\''
                + '}';
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("./data/app2.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}