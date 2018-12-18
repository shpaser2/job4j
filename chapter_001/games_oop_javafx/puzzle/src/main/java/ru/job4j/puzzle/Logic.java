package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    /**
     * Constructor with fields initialization
     * @param size of table
     */
    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    /**
     *
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     *
     * @param source
     * @param dest
     * @return
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        int column = 0, row = 0;

        for (; column < (this.size - 1); column++) {
            if (table[row][column] == 1) {
                for (; row < (this.size - 1); row++) {
                    if (table[row][column] == 0) {
                        break;
                    }
                }
                if (row == (this.size - 1)) {
                    result = true;
                }
            }
        }
        row = 0;
        column = 0;
        if (!result) {
            for (; row < (this.size - 1); row++) {
                if (table[row][column] == 1) {
                    for (; column < (this.size - 1); column++) {
                        if (table[row][column] == 0) {
                            break;
                        }
                    }
                    if (column == (this.size - 1)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}