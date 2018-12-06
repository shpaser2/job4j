package ru.job4j.array;

import java.util.Arrays;

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
        int newArrayLength = array.length;
        for (int index = 0; index < newArrayLength; index++) {
            for (int indexOfComparison = index + 1; indexOfComparison < newArrayLength; indexOfComparison++) {
                if (array[index].equals(array[indexOfComparison])) {
                    if (indexOfComparison < newArrayLength - 1) {
                        for (int indexForSort = indexOfComparison; indexForSort < newArrayLength - 1; indexForSort++) {
                            String buff = array[indexForSort];
                            array[indexForSort] = array[indexForSort + 1];
                            array[indexForSort + 1] = buff;
                        }
                    }
                    newArrayLength--;
                }
            }
        }
        return Arrays.copyOf(array, newArrayLength);
    }
}
