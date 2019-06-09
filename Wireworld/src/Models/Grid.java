/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
/**
 *
 * @author 01133123
 */
public abstract class Grid {

    static final int RAND_SIZE_MIN = 3;
    static final int RAND_SIZE_RANGE = 5;
    Cell[][] cellsList;
    protected int[] dimensions;
    protected char countedColor;

    public Grid() {
        this.setDimensions(new int[2]);
    }

    public Cell[][] getCellsList() {
        return this.cellsList;
    }

    public void setCellsList(Cell[][] cellsList) {
        this.cellsList = cellsList;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    int checkNeighbors(int x, int y) {
        int counter = 0;
        if (x > 0 && y > 0) {
            if (this.cellsList[x - 1][y - 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (y > 0) {
            if (this.cellsList[x][y - 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (x < this.dimensions[0] - 1 && y > 0) {
            if (this.cellsList[x + 1][y - 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (x > 0) {
            if (this.cellsList[x - 1][y].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (x < this.dimensions[0] - 1) {
            if (this.cellsList[x + 1][y].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (x > 0 && y < this.dimensions[1] - 1) {
            if (this.cellsList[x - 1][y + 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (y < this.dimensions[1] - 1) {
            if (this.cellsList[x][y + 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        if (x < this.dimensions[0] - 1 && y < this.dimensions[1] - 1) {
            if (this.cellsList[x + 1][y + 1].getColor() == this.countedColor) {
                counter++;
            }
        }
        return counter;
    }

    public int[] getDimensions() {
        return this.dimensions;
    }

    public Cell getCell(int x, int y) {
        return this.cellsList[x][y];
    }
    
    public Cell getCellReversed(int x, int y) {
        return this.cellsList[y][x];
    }

    abstract void tick();

    abstract void randomize();
}
