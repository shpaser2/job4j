package ru.job4j.array;


/**
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 06.12.2018
 */
public class Matrix {

    /**
     * Create multiplication table (square) with selected size.
     * @param size maximal number for multiplication .
     * @return multiplication  table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                table[rowIndex][columnIndex] = (rowIndex + 1) * (columnIndex + 1);
            }
        }
        return table;
    }
}