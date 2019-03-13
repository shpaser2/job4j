package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
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
        String[] expect = new String[]{"Olga", "May", "Ivan", "Oleg"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * тест, проверяющий удаление дубликатов строк из массива строк.
     */
    @Test
    public void whenRemoveManyDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"1", "1", "1"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[]{"1"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * тест, проверяющий удаление дубликатов строк из массива строк.
     */
    @Test
    public void whenRemoveDifferentDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"2", "1", "1", "2", "1", "2"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[]{"1", "2"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}