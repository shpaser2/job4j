package ru.job4j.loop;

/**
 * Class for factorial calculation.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 26.11.2018
 */
public class Factorial {

    /**
     * Find factorial of n number.
     *
     * @param n number for factorial.
     * @return factorial of number from 0 to 12, all higher 12 will overflow int - so error.
     */
    public int calc(int n) {
        int factorial = 1;
        if (n == 0) return factorial;
        else if (n <= 12) {
            for (int index = 1; index <= n; index++) {
                factorial *= index;
            }
            return factorial;
        } else return -1;
    }
}
