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
public class GridGoL extends Grid {
    
    private static final int ALIVE_MIN = 2;
    private static final int ALIVE_MAX = 3;
    
    public GridGoL(Cell[][] cellsList, int[] dimensions) {
        super(cellsList, dimensions);
        this.countedColor = 'w';
    }

    @Override
    void tick() {
        for(int i = 0; i < this.dimensions[0]; i++)
        {
            for(int k = 0; k < this.dimensions[1]; k++)
            {
                Cell cell = cellsList[i][k];
                int neighborCount = this.checkNeighbors(i, k);
                if(cell.getColor() == 'w')
                {
                    if(neighborCount  != ALIVE_MIN && neighborCount != ALIVE_MAX)
                        cell.changeState();
                }
                else if (neighborCount == ALIVE_MAX)
                    cell.changeState();
            }
        }
    }

    @Override
    void randomize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
