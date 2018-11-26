package ru.job4j.condition;



/**
 * Class Triangle возвращает площадь треугольника образованного тремя точками.
 *
 * @author Sergey Shpakovsky
 * @version $Id$
 * @since 26.11.2018
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     * p = (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return p Полупериметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том. что треугольника нет.
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc, p)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * //(ab+ac+bc - max(ab, ac, bc)) > (ab+ac+bc)/2 if true - this is triangle
     *
     * @param ab Длина отрезка ab.
     * @param ac Длина отрезка ac.
     * @param bc Длина отрезка bc.
     * @param p Полупериметр.
     * @return boolean треугольник это или нет.
     */
    private boolean exist(double ab, double ac, double bc, double p) {
        double maxAbAc = ab >= ac ? ab : ac;
        double maxTriangleSide = maxAbAc >= bc ? maxAbAc : bc;
        return (ab + ac + bc - maxTriangleSide) > p;
    }
}