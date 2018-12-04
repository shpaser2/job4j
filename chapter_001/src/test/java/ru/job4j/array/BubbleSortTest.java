package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class BubbleSortTest {

    /**
     * Тест, проверяющий сортировку массива из 10 элементов методом пузырька,
     * например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] array = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] resultArray = bubble.sort(array);
        int[] expectArray = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(resultArray, is(expectArray));
    }
}
