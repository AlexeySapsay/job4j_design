package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://job4j.ru/profile/exercise/44/task-view/304
 * Это задание сводится к определению разницы между
 * начальным и измененным состояниями множества.
 *
 * @author AlexSapsay (sapsayalexey@gmail.com)
 * @version 1.0
 * @since 31.10.2021
 */
public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;


        Map<Integer, String> hashMapPrev = new HashMap();
        for (User user : previous) {
            hashMapPrev.put(user.getId(), user.getName());
        }

        /**
         * map текущих пользователей
         */
//        Map<Integer, String> hashMapCurrent = new HashMap();
//        for (User user : current) {
//            hashMapCurrent.put(user.getId(), user.getName());
//
//            if (previous.contains(user.getId())) {
//                changed += 1;
//            }
//        }

        /**
         * {@code true} if this set did not already contain the specified
         *  element
         */
//        for (User user : previous) {
//            if (current.add(user)) {
//                System.out.println("user exist");
//                current.add(user);
//            } else {
//                System.out.println("User not exist and will be added");
//            }
//        }

        /**
         * достаточно создать одну карту, допустим, текущих пользователей,
         * и добавлять в нее предыдущих, и в зависимости от результата
         * добавления - производить необходимые проверки и изменять нужные счетчики.
         */
//        for (User user : current) {
//            if (previous.contains(user.getId())
//            && (!previous.contains(user.getName()))) {
//                changed += 1;
//            }
//        }

        for (User user : current) {
            if (hashMapPrev.containsKey(user.getId())
                    && (!user.getName().equals(hashMapPrev.get(user.getId())))) {
                changed += 1;
            }
        }

        /**
         *  - Сколько изменено пользователей. Изменённым считается объект,
         *  в котором изменилось имя, а id осталось прежним.
         */
//        for (User user : current) {
//            if (hashMapPrev.containsKey(user.getId())
//                    && (!user.getName().equals(hashMapPrev.get(user.getId())))) {
//                changed += 1;
//            }
//        }

        /**
         *  - Сколько добавлено новых пользователей. Добавленным считается такой
         *  пользователь, что ранее его не было в множестве previous, но в
         *  множестве current он есть.
         */
        for (User user : current) {
            if (!previous.contains(user)
                    && !hashMapPrev.containsKey(user.getId())) {
                added += 1;
            }
        }


        /**
         *  Сколько удалено пользователей. Удаленным считается такой пользователь,
         *  что ранее он был в множестве previous, но теперь в множестве
         *  current его нет.
         */
//        for (User user : previous) {
//            if (!current.contains(user)
//                    && !hashMapCurrent.containsKey(user.getId())) {
//                deleted += 1;
//            }
//        }


        for (User user : previous) {
            if (!current.contains(user)
                    && (current.contains(user.getId()))) {
                deleted += 1;
            }
        }
        return new Info(added, changed, deleted);
    }
}
