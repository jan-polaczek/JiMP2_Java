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
public class GridWW extends Grid {
    
    private static final int ELECTRON_MIN = 1;
    private static final int ELECTRON_MAX = 2;
            
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
    
}
