package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 06.12.2018
 */
public class MatrixCheckTest {

    /**
     * Test check method for boolean of one type diagonals in matrix.
     */
    @Test
    public void whenDataMonoByTrueThenTrueThreeElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test check method for boolean of one type diagonals in matrix.
     */
    @Test
    public void whenDataMonoByTrueThenTrueFourElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true},
                {false, true, true, true},
                {false, true, true, true},
                {true, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test check method for boolean of different types diagonals in matrix.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalseThreeElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test check method for boolean of different types diagonals in matrix.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalseFourElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, false},
                {false, true, true, true},
                {false, true, false, true},
                {true, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}