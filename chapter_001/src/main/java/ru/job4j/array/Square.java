package ru.job4j.array;

/**
 * Class with method wich return array with squared numbers
 * from 1 to selected number.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 3/12/2018
 */
public class Square {

    /**
     * Make array with squared numbers from 1 to bound.
     *
     * @param bound maximal squared number.
     *              Also number of cells in array.
     * @return array with squared numbers from 1 to bound.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index < bound; index++) {
            rst[index] = (index + 1) * (index + 1);
        }
        return rst;
    }

}
