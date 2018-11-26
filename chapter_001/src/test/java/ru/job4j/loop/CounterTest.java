package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test of the class which method summ even numbers in selected range.
 *
 * @author Sergey Shpakovsky
 * @version $Id$
 * @since 26.11.2018
 */
public class CounterTest {

    /**
     * Test add method - sum numbers from 1 to 10.
     */
    @Test
    public void evenNumbersSumFrom1To10Then30() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
