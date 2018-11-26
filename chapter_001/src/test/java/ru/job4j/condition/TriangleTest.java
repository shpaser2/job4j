package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test of the Triangle class methods.
 *
 * @author Sergey Shpakovsky
 * @version $Id$
 * @since 26.11.2018
 */
public class TriangleTest {

    /**
     * Test Triangle methods.
     */
    @Test
    public void whenABCpointsOfSquareWithSideEqual2ThenTriangleSquareEqual2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 2);

        Triangle triangle = new Triangle(a, b, c);

        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));

    }
}
