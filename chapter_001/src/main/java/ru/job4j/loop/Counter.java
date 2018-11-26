package ru.job4j.loop;

/**
 * Class to summ even numbers in selected range.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 26.11.2018
 */
public class Counter {

    /**
     * Method summ even numbers in selected range.
     *
     * @param start  from this number it start add new even numbers to sum.
     * @param finish at this number it stop add new even numbers to sum.
     * @return sum of even numbers from start number to finish number.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int index = start; index <= finish; index++) {
            if ((index % 2) == 0) {
                sum += index;
            }
        }
        return sum;
    }
}
