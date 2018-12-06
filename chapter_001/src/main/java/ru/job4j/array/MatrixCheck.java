package ru.job4j.array;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 06.12.2018
 */
public class MatrixCheck {

    /**
     * Check 2 diagonals for difference in elements on them. (in matrix)
     *
     * @param data matrix with boolean elements.
     * @return true if diagonals are one type of boolean.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int arrayEndIndex = data.length - 1;
        for (int index = 0; index < arrayEndIndex; index++) {
            if (data[index][index] != data[index + 1][index + 1]) {
                result = false;
                break;
            }
            if (data[arrayEndIndex - index][index] != data[arrayEndIndex - index - 1][index + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
