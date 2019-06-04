/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.Random;
/**
 *
 * @author 01133123
 */
public class GridWW extends Grid {
    
    private static final int ELECTRON_MIN = 1;
    private static final int ELECTRON_MAX = 2;
    private static final int RAND_SIZE_MIN = 5;
    private static final int RAND_SIZE_RANGE = 25;
    
    public GridWW(Cell[][] cellsList, int[] dimensions) {
        super(cellsList, dimensions);
        this.countedColor = 'l';
    }

    @Override
    void tick() {
        for(int i = 0; i < this.dimensions[0]; i++)
        {
            for(int k = 0; k < this.dimensions[1]; k++)
            {
                Cell cell = cellsList[i][k];
                if(cell.getColor() == 'y')
                {
                    int neighborCount = this.checkNeighbors(i, k);
                    if(neighborCount >= ELECTRON_MIN && neighborCount <= ELECTRON_MAX)
                        cell.changeState();
                }
                else
                    cell.changeState();
            }
        }
    }
    
    @Override
    void randomize() {
        Random rand = new Random();
        this.dimensions[0] = RAND_SIZE_MIN + rand.nextInt(RAND_SIZE_RANGE);
        this.dimensions[1] = RAND_SIZE_MIN + rand.nextInt(RAND_SIZE_RANGE);
         for(int i = 0; i < this.dimensions[0]; i++)
        {
            for(int k = 0; k < this.dimensions[1]; k++)
            {
                int colNum = rand.nextInt(4);
                char color = 'b';
                switch (colNum) {
                    case 0:
                        color = 'y';
                        break;
                    case 1:
                        color = 'l';
                        break;
                    case 2:
                        color = 'r';
                        break;
                    case 3:
                        color = 'b';
                        break;
                }
                Cell cell = new Cell(color);
                this.cellsList = new Cell[i][k];
                cellsList[i][k] = cell;
            }
        }
    }
}
