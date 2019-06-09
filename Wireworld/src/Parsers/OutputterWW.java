/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Models.Grid;

/**
 *
 * @author 01133123
 */
public class OutputterWW implements Outputter {

    /**
     *
     * @param grid
     * @return
     */
    @Override
    public String saveFile(Grid grid) {
        String result = "";
        int width = grid.getDimensions()[0];
        int height = grid.getDimensions()[1];
        result += width + " ";
        result += height + "\n";
        for(int i = 0; i < height; i++)
        {
            for(int k = 0; k < width; k++)
            {
                if(grid.getCellReversed(i, k).getColor() == 'y') result += "Conductor " + k + " " + i + " " + k + " " + i + "\n";
                else if(grid.getCellReversed(i, k).getColor() == 'r') result += "ElectronTail " + k + " " + i + " " + k + " " + i + "\n";
                else if(grid.getCellReversed(i, k).getColor() == 'l') result += "ElectronHead " + k + " " + i + " " + k + " " + i + "\n";
            }
        }
        return result;
    }
}
