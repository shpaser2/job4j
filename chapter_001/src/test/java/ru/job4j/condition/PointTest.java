package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test of the Point class method .
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 25.11.2018
 */
public class PointTest {
    /**
     * Test distanceTo.
     */
    @Test
    public void distanceBetweenTwoPoints() {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(4, 5);
        double result = firstPoint.distanceTo(secondPoint);
        double expected = 5D;
        assertThat(result, is(expected));
    }

}
