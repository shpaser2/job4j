package ru.job4j.pseudo;

/**
 * interface Shape определяет названия методов интерфейса для
 * отрисовки фигур псевдографики с использованием паттерна "Стратегия".
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 10.03.2019
 */
public interface Shape {
    /**
     * Определяет параметры и возвращаемое из метода draw().
     * @return Возвращает строку с фигурой в псевдографике.
     */
    String draw();
}
