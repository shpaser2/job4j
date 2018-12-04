package ru.job4j.array;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class BubbleSort {

    /**
     * Sort array by bubble algorithm.
     *
     * @param array array to bubble sort.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        int arrayLength = array.length - 1;
        for (int indexCycle = arrayLength; indexCycle >= 1; indexCycle--) {
            for (int indexArray = 0; indexArray < indexCycle; indexArray++) {
                if (array[indexArray] > array[indexArray + 1]) {
                    int buffer = array[indexArray];
                    array[indexArray] = array[indexArray + 1];
                    array[indexArray + 1] = buffer;
                }
            }
        }
        return array;
    }
}
