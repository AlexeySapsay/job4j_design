package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseThenEmpty() {
        NameLoad nameLoad = new NameLoad();
        String word = "Names";
        int number = 5;
        assertThatThrownBy(nameLoad::parse)
                /*проверяем класс исключения: */
                .isInstanceOf(IllegalArgumentException.class)
                /*с помощью регулярного выражения проверяем факт наличия сообщения*/
                .hasMessageMatching("^.+")
                /*проверяем, что в сообщении есть соответствующие параметры:*/
                .hasMessageContaining(word, number)
                /*проверяем наличие конкретного слова в сообщении:*/
                .hasMessageContaining("Names");
    }

    @Test
    void checkvalidateThenThrowException() {
        NameLoad nameLoad = new NameLoad();
        String word = "Names";
        int number = 5;
        assertThatThrownBy(nameLoad::parse)
                /*проверяем класс исключения: */
                .isInstanceOf(IllegalArgumentException.class)
                /*с помощью регулярного выражения проверяем факт наличия сообщения*/
                .hasMessageMatching("^.+")
                /*проверяем, что в сообщении есть соответствующие параметры:*/
                .hasMessageContaining(word, number)
                /*проверяем наличие конкретного слова в сообщении:*/
                .hasMessageContaining("Names");
    }
}