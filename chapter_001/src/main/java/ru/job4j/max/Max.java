package ru.job4j.max;

/**
 * Class Max возвращает большее из двух заданных чисел.
 *
 * @author Sergey Shpakovsky
 * @version $Id$
 * @since 25.11.2018
 */
public class Max {

    /**
     * Находим большее из двух чисел.
     *
     * @param first  - первое число для сравнения.
     * @param second - второе число дял сравнения.
     * @return Наибольшее число из first и second.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Находим большее из трех чисел.
     *
     * @param first  - первое число для сравнения.
     * @param second - второе число дял сравнения.
     * @param third  - третье число дял сравнения.
     * @return Наибольшее число из first, second, third.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}
