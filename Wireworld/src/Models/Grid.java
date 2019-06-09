/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
/**
 * klasa abstrakcyjna reprezentująca siatkę komórek
 * @author 01133123
 */
public abstract class Grid {

    static final int RAND_SIZE_MIN = 3;
    static final int RAND_SIZE_RANGE = 5;
    Cell[][] cellsList;

    /**
     * wymiary siatki
     */
    protected int[] dimensions;

    /**
     * kolor(stan) komórek, które zliczane są w danym automacie;
     * żywa(biała) komórka w grze w życie,
     * przewodnik(żółta komórka) w Wireworld
     */
    protected char countedColor;

    /**
     * konstruktor
     */
    public Grid() {
        this.setDimensions(new int[2]);
    }

    /**
     *
     * @return listę komórek
     */
    public Cell[][] getCellsList() {
        return this.cellsList;
    }

    /**
     *
     * @param cellsList
     */
    public void setCellsList(Cell[][] cellsList) {
        this.cellsList = cellsList;
    }

    /**
     *
     * @param dimensions
     */
    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }
    
    /**
     * zlicza liczbę sąsiadów o danym kolorze
     * @param x
     * @param y
     */
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

    /**
     *
     * @return
     */
    public int[] getDimensions() {
        return this.dimensions;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Cell getCell(int x, int y) {
        return this.cellsList[x][y];
    }
    
    /**
     *
     * @param x
     * @param y
     * @return zwraca komórkę o współrzędnych odwrotnych do podanych
     * @throws ArrayIndexOutOfBoundsException
     */
    public Cell getCellReversed(int x, int y) throws ArrayIndexOutOfBoundsException{
        return this.cellsList[y][x];
    }

    abstract void tick();

    abstract void randomize();
}
