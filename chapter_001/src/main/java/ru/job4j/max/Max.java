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
     * Вычисляем расстояние между точками.
     *
     * @param first  - первое число для сравнения.
     * @param second - второе число дял сравнения.
     * @return Наибольшее число из first и second.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }
}
