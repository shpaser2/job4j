package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 12.03.2019
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+")
                                .append("++")
                                .append("+++")
                                .append("++++")
                                .toString()
                )
        );
    }
}