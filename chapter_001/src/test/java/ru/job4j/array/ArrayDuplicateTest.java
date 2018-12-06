package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 06.12.2018
 */
public class ArrayDuplicateTest {

    /**
     * тест, проверяющий удаление дубликатов строк из массива строк.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"May", "Oleg", "Ivan", "Ivan", "Olga", "May"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[]{"May", "Oleg", "Ivan", "Olga"};
        assertThat(result, is(expect));
    }
}