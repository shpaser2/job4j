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
        HashSet<String> hashSet = new HashSet<>();
        for (int index = 0; index < array.length - 1; index++) {
            hashSet.add(array[index]);
        }
        return hashSet.toArray(new String[hashSet.size()]);
    }
}
