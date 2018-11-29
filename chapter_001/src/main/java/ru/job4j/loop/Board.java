package ru.job4j.loop;

/**
 * Class for chess board string paint.
 *
 * @author Sergey Shpakovsky (shpaser2@yandex.ru)
 * @version $Id$
 * @since 29.11.2018
 */
public class Board {
    /**
     * paint chess board with selected width and height
     * @param width  of board
     * @param height of board
     */
    public String paint(int width, int height) {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (((i + j) % 2) == 0) {
                    result.append('X');
                } else {
                    result.append(' ');
                }
            }
            result.append(ln);
        }
        return result.toString();
    }
}