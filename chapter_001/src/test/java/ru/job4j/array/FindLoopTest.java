package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 3/12/2018
 */
public class FindLoopTest {

    /**
     * This method is the test with succesfully search.
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * This method is the test with unsuccesfully search.
     */
    @Test
    public void whenArrayHas5and10and3search8ThenMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}