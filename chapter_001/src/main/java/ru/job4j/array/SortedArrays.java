package ru.job4j.array;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 11.12.2018
 */
public class SortedArrays {

    /**
     * @param first  sorted array
     * @param second sorted array
     * @return one sorted array from two sorted arrays.
     */
    public int[] AddArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int fIndex = 0, sIndex = 0, rIndex = 0;
        while (fIndex < first.length && sIndex < second.length) {
            result[rIndex++] = first[fIndex] < second[sIndex] ? first[fIndex++] : second[sIndex++];
        }
        while (rIndex < result.length) {
            if (fIndex < first.length) {
                result[rIndex++] = first[fIndex++];
            } else {
                result[rIndex++] = second[sIndex++];
            }
        }
        return result;
    }
}
