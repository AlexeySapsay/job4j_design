package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, User> map = new HashMap<>();

        for (User element : previous) {
            map.put(element.getId(), element);
        }
        for (User element : current) {
            User previousUser = map.putIfAbsent(element.getId(), element);
            if (previousUser != null) {
                if (!element.equals(previousUser)) {
                    changed++;
                }
            } else {
                added++;
            }
        }
        deleted = previous.size() - current.size() + added;
        return new Info(added, changed, deleted);
    }
}