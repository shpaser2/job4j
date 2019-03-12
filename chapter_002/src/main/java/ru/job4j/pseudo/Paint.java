package ru.job4j.pseudo;

/**
 *
 * Выводим фигуру в виде строки используя паттерн "Стратегия".
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 12.03.2019
 */
public class Paint {

    /**
     * Выводим строку с фигурой в псевдографике.
     *
     * @param shape - определяет выводимую фигуру
     */
    public final void draw(final Shape shape) {
        System.out.println(shape.draw());
    }
}
