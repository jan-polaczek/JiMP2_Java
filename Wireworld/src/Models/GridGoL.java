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
public class GridGoL extends Grid {

    private static final int ALIVE_MIN = 2;
    private static final int ALIVE_MAX = 3;
    private static final int COL_NUM = 2;

    /**
     *
     */
    public GridGoL() {
        super();
        this.countedColor = 'w';
    }

    @Override
    void tick() {
        boolean[][] cellsToChange = new boolean[dimensions[0]][dimensions[1]];
        for (int i = 0; i < this.dimensions[0]; i++) {
            for (int k = 0; k < this.dimensions[1]; k++) {
                cellsToChange[i][k] = false;
                Cell cell = this.cellsList[i][k];
                int neighborCount = this.checkNeighbors(i, k);
                if (cell.getColor() == 'w') {
                    if (neighborCount != ALIVE_MIN && neighborCount != ALIVE_MAX) {
                        cellsToChange[i][k] = true;
                    }
                } else if (neighborCount == ALIVE_MAX) {
                    cellsToChange[i][k] = true;
                }
            }
        }
        for (int i = 0; i < this.dimensions[0]; i++) {
            for (int k = 0; k < this.dimensions[1]; k++) {
                if (cellsToChange[i][k]) {
                    this.cellsList[i][k].changeState();
                }
            }
        }
    }

    @Override
    void randomize() {
        Random rand = new Random();
        this.dimensions[0] = RAND_SIZE_MIN + rand.nextInt(RAND_SIZE_RANGE);
        this.dimensions[1] = RAND_SIZE_MIN + rand.nextInt(RAND_SIZE_RANGE);
        this.cellsList = new Cell[dimensions[0]][dimensions[1]];
        for (int i = 0; i < this.dimensions[0]; i++) {
            for (int k = 0; k < this.dimensions[1]; k++) {
                int colNum = rand.nextInt(COL_NUM);
                char color = 'b';
                if (colNum == 1) {
                    color = 'w';
                }
                Cell cell = new Cell(color);
                this.cellsList[i][k] = cell;
            }
        }
    }

}
