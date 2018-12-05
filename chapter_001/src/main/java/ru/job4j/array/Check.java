package ru.job4j.array;

/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 04.12.2018
 */
public class Check {

    /**
     * Method check boolean array: does it contain false/true only.
     *
     * @param input array for turn.
     * @return turned array.
     */
    public boolean mono(boolean[] input) {
        int arrayLength = input.length - 1;
        boolean result = true;
        for (int index = 1; index <= arrayLength; index++) {
            if (input[index] != input[index - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
