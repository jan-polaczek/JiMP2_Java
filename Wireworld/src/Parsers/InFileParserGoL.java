/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Models.Cell;
import Models.Grid;
import Models.GridGoL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 01133123
 */
public class InFileParserGoL implements InFileParser {

    /**
     *
     * @param inFile
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public Grid parse(File inFile) throws FileNotFoundException {
        Scanner sc = new Scanner(inFile);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int[] dims = new int[2];
        int counter = 0;
        dims[0] = width;
        dims[1] = height;
        Cell[][] cellsList = new Cell[width][height];
        for (int i = 0; i < height; i++) {
            for (int k = 0; k < width; k++) {
                cellsList[k][i] = new Cell('b');
            }
        }
        Grid grid = new GridGoL();
        grid.setCellsList(cellsList);
        grid.setDimensions(dims);
        while (sc.hasNextLine()) {
            int cellType = sc.nextInt();
            if (cellType == 1) {
                grid.getCellReversed(counter / width, counter % width).setColor('w');
            }
            counter++;

        }
        return grid;

    }

}
