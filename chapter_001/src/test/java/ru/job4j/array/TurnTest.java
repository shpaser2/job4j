package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class TurnTest {
    /**
     * Test turn method with even array.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Test turn method with odd array.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //{1, 2, 3, 4, 5}.
        Turn turner = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expect = new int[]{5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}