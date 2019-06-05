/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Models.Grid;
import Models.GridWW;
import Models.Cell;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;
/**
 *
 * @author 01133123
 */
public class InFileParserWW implements InFileParser {

    @Override
    public Grid parse(File inFile) throws FileNotFoundException {
        Scanner sc = new Scanner(inFile);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int[] dims = new int[2];
        dims[0] = width;
        dims[1] = height;
        Cell[][] cellsList = new Cell[width][height];
        for (int i=0; i<width; i++)
            for (int k=0; k<height; k++)
                cellsList[i][k] = new Cell('b');
        Grid grid = new GridWW(cellsList, dims);
        while (sc.hasNextLine())
        {
            String line[] = sc.nextLine().split(" ");
            String type = line[0];
            if(type == "Diode")
            {
                
            }
            else if(type == "AndGate")
            {
                
            }
            else if(type == "OrGate")
            {
                
            }
            else if(type == "XorGate")
            {
                
            }
            else if(type == "ElectronHead")
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                grid.getCell(x, y).setColor('l');
            }
            else if(type == "ElectronTail")
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                grid.getCell(x, y).setColor('r');
            }
            
        }
        return grid;
        
    }
    
}
