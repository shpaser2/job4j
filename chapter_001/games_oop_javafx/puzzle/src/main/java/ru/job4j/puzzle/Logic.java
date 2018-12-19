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
     *
     * @param size of table
     */
    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    /**
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
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
        int counter = 0;
        for (; column < this.size; column++) {
            if(row == 0) if (table[row][column] == 1) row++;
            if(row == 1) if (table[row][column] == 1) row++;
            if(row == 2) if (table[row][column] == 1) row++;
            if(row == 3) if (table[row][column] == 1) row++;
            if(row == 4) if (table[row][column] == 1) row++;
            if(row == this.size){ result = true; break;}
        }
        if(!result){
            row = 0; column = 0;
            for (; row < this.size; row++) {
                if(column == 0) if (table[row][column] == 1) column++;
                if(column == 1) if (table[row][column] == 1) column++;
                if(column == 2) if (table[row][column] == 1) column++;
                if(column == 3) if (table[row][column] == 1) column++;
                if(column == 4) if (table[row][column] == 1) column++;
                if(column == this.size){ result = true; break;}
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
