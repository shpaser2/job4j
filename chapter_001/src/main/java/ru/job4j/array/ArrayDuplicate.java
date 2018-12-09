package ru.job4j.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 06.12.2018
 */
public class ArrayDuplicate {

    /**
     * Throw duplicates out of the array.
     *
     * @param array array for sort and cut off duplicates.
     * @return array without duplicates of elements.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
