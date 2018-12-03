package ru.job4j.array;

/**
 * Search element in array with simple loop.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 3/12/2018
 */
public class FindLoop {
    /**
     * Search element in array with simple loop.
     *
     * @param data array with elements.
     * @param el   element for search in data.
     * @return index of el.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}