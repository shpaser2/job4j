package ru.job4j.loop;

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
public class FactorialTest {

    /**
     * Test calc method - calc 0 factorial.
     */
    @Test
    public void whenFactorialZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

    /**
     * Test calc method - calc 5 factorial.
     */
    @Test
    public void whenFactorialFiveThenOneHundrendAndTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }
}
