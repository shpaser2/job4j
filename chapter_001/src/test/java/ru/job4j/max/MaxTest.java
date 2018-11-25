package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test of the Max class method.
 *
 * @author Sergey Shpakovsky
 * @version $Id$
 * @since 25.11.2018
 */
public class MaxTest {

    /**
     * Test max method - compare 2 numbers.
     */
    @Test
    public void whenMaxFrom1And2Then2() {
        int first = 1;
        int second = 2;
        Max compare = new Max();
        int result = compare.max(first, second);
        assertThat(result, is(2));

    }
}
