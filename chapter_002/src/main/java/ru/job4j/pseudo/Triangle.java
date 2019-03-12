package ru.job4j.pseudo;

/**
 * class Triangle переопределяет метод интерфейса Shape для
 * отрисовки треугольника в псевдографике.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 12.03.2019
 */
public class Triangle implements Shape {
    @Override
    public final String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+");
        pic.append("++");
        pic.append("+++");
        pic.append("++++");
        return pic.toString();
    }
}
