package ru.job4j.array;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class Turn {

    /**
     *  Method turn array around center.
     * @param array array for turn.
     * @return turned array.
     */
    public int[] back(int[] array) {
        int arrayLength = array.length - 1;
        for (int index = 0; index <= (arrayLength / 2); index++) {
            int buffer;
            buffer = array[index];
            array[index] = array[arrayLength - index];
            array[arrayLength - index] = buffer;
        }
        return array;
    }
}
