/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 01133123
 */
public abstract class Grid {
    static final int RAND_SIZE_MIN = 5;
    static final int RAND_SIZE_RANGE = 25;
    Cell[][] cellsList;
    protected final int[] dimensions;
    protected char countedColor;
    public Grid(Cell[][] cellsList, int[] dimensions)
    {
        this.cellsList = cellsList;
        this.dimensions = dimensions;
    }
    public Cell[][] getCellsList()
    {
        return this.cellsList;
    }
    int checkNeighbors(int x, int y) {
        int counter = 0;
        if(x > 0 && y > 0) if(this.cellsList[x-1][y-1].getColor() == this.countedColor) 
            counter ++;
        if(y > 0) if(this.cellsList[x][y-1].getColor() == this.countedColor) 
            counter ++;
        if(x < this.dimensions[0] - 1 && y > 0) if(this.cellsList[x+1][y-1].getColor() == this.countedColor) 
            counter ++;
        if(x > 0) if(this.cellsList[x-1][y].getColor() == this.countedColor) 
            counter ++;
        if(x < this.dimensions[0] - 1) if(this.cellsList[x+1][y].getColor() == this.countedColor) 
            counter ++;
        if(x > 0 && y < this.dimensions[1] - 1) if(this.cellsList[x-1][y+1].getColor() == this.countedColor) 
            counter ++;
        if(y < this.dimensions[1] - 1) if(this.cellsList[x][y+1].getColor() == this.countedColor) 
            counter ++;
        if(x < this.dimensions[0] - 1 && y < this.dimensions[1] - 1) if(this.cellsList[x+1][y+1].getColor() == this.countedColor) 
            counter ++;
        return counter;
    }
    abstract void tick();
    abstract void randomize();
}
