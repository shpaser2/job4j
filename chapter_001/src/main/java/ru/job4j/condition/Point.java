package ru.job4j.condition;

/**
 * Class Point описывает тип данных точка.
 *
 * @author Sergey Shpakovsky
 * @version 0.1
 * @since 25.11.2018
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор, задаем начальное значение полей.
     *
     * @param x координата.
     * @param y координата.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Вычисляем расстояние между точками.
     *
     * @param that координаты второй точки.
     * @return расстояние между заданной и точкой-параметром.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2)
        );
    }

    /**
     * Ручное тестирование. Вывод на консоль расстояния между
     * точками с заданными координатами.
     *
     * @param args Ничего не вводим.
     */
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(4, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }

}
