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
            if("Diode".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                String z = String.valueOf(line[3]);
                if("Normal".equals(z))
                {
                grid.getCell(x, y).setColor('y');
                grid.getCell(x+1, y).setColor('y');
                grid.getCell(x, y-1).setColor('y');
                grid.getCell(x, y-2).setColor('y');
                grid.getCell(x+1, y-2).setColor('y');
                }
                else if("Reversed".equals(z))
                {
                grid.getCell(x, y).setColor('y');
                grid.getCell(x+1, y).setColor('y');
                grid.getCell(x+1, y-1).setColor('y');
                grid.getCell(x, y-2).setColor('y');
                grid.getCell(x+1, y-2).setColor('y'); 
                }
            }
            else if("Conductor".equals(type))
            {
                int x1 = Integer.valueOf(line[1]);
                int y1 = Integer.valueOf(line[2]);
                int x2 = Integer.valueOf(line[3]);
                int y2 = Integer.valueOf(line[4]);
                if(x1 <= x2)
                {
                    for(int i=x1;i<=x2;i++)
                    {
                        grid.getCell(i, y1).setColor('y');
                    }
                }
                else
                {
                    for(int i=x2;i<=x1;i++)
                    {
                        grid.getCell(i, y1).setColor('y');
                    }  
                }
                if(y1 <= y2)
                {
                    for(int i=y1;i<=y2;i++)
                    {
                        grid.getCell(x2, i).setColor('y');
                    }
                }
                else
                {
                    for(int i=y1;i>=y2;i--)
                    {
                        grid.getCell(i, y1).setColor('y');
                    }  
                }
                
            }
            else if("AndGate".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                String z = String.valueOf(line[3]);
                if("Normal".equals(z))
                    {
                    grid.getCell(x, y).setColor('y');
                    grid.getCell(x, y-1).setColor('y');
                    grid.getCell(x, y-2).setColor('y');
                    grid.getCell(x, y-4).setColor('y');
                    grid.getCell(x, y-5).setColor('y');
                    grid.getCell(x, y-6).setColor('y');
                    grid.getCell(x+1, y).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-4).setColor('y');
                    grid.getCell(x+1, y-6).setColor('y');
                    grid.getCell(x+2, y-1).setColor('y');
                    grid.getCell(x+2, y-5).setColor('y');
                    grid.getCell(x+3, y-1).setColor('y');
                    grid.getCell(x+3, y-2).setColor('y');
                    grid.getCell(x+3, y-3).setColor('y');
                    grid.getCell(x+3, y-4).setColor('y');
                    grid.getCell(x+3, y-5).setColor('y');
                    grid.getCell(x+4, y-2).setColor('y');
                    grid.getCell(x+4, y-4).setColor('y');
                    grid.getCell(x+5, y-3).setColor('y');
                    }
                else if("Reversed".equals(z))
                {
                    grid.getCell(x, y-3).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-4).setColor('y');
                    grid.getCell(x+2, y-1).setColor('y');
                    grid.getCell(x+2, y-2).setColor('y');
                    grid.getCell(x+2, y-3).setColor('y');
                    grid.getCell(x+2, y-4).setColor('y');
                    grid.getCell(x+2, y-5).setColor('y');
                    grid.getCell(x+3, y-1).setColor('y');
                    grid.getCell(x+3, y-5).setColor('y');
                    grid.getCell(x+4, y).setColor('y');
                    grid.getCell(x+4, y-2).setColor('y');
                    grid.getCell(x+4, y-4).setColor('y');
                    grid.getCell(x+4, y-6).setColor('y');
                    grid.getCell(x+5, y).setColor('y');
                    grid.getCell(x+5, y-1).setColor('y');
                    grid.getCell(x+5, y-2).setColor('y');
                    grid.getCell(x+5, y-4).setColor('y');
                    grid.getCell(x+5, y-5).setColor('y');
                    grid.getCell(x+5, y-6).setColor('y');
                    
                }
            }
            else if("OrGate".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                String z = String.valueOf(line[3]);
                if("Normal".equals(z))
                {
                    grid.getCell(x, y).setColor('y');
                    grid.getCell(x, y-2).setColor('y');
                    grid.getCell(x, y-4).setColor('y');
                    grid.getCell(x+1, y-1).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-3).setColor('y');
                }
                else if("Reversed".equals(z))
                {
                    grid.getCell(x, y-1).setColor('y');
                    grid.getCell(x, y-2).setColor('y');
                    grid.getCell(x, y-3).setColor('y');
                    grid.getCell(x+1, y).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-4).setColor('y');
                }
            }
            else if("XorGate".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                String z = String.valueOf(line[3]);
                if("Normal".equals(z))
                {
                    grid.getCell(x, y).setColor('y');
                    grid.getCell(x, y-2).setColor('y');
                    grid.getCell(x, y-3).setColor('y');
                    grid.getCell(x, y-4).setColor('y');
                    grid.getCell(x, y-6).setColor('y');
                    grid.getCell(x+1, y-1).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-4).setColor('y');
                    grid.getCell(x+1, y-5).setColor('y');
                    grid.getCell(x+2, y-2).setColor('y');
                    grid.getCell(x+2, y-4).setColor('y');
                    grid.getCell(x+3, y-2).setColor('y');
                    grid.getCell(x+3, y-3).setColor('y');
                    grid.getCell(x+3, y-4).setColor('y');
                }
                else if("Reversed".equals(z))
                {
                    grid.getCell(x, y-2).setColor('y');
                    grid.getCell(x, y-3).setColor('y');
                    grid.getCell(x, y-4).setColor('y');
                    grid.getCell(x+1, y-2).setColor('y');
                    grid.getCell(x+1, y-4).setColor('y');
                    grid.getCell(x+2, y-1).setColor('y');
                    grid.getCell(x+2, y-2).setColor('y');
                    grid.getCell(x+2, y-4).setColor('y');
                    grid.getCell(x+2, y-5).setColor('y');
                    grid.getCell(x+3, y).setColor('y');
                    grid.getCell(x+3, y-2).setColor('y');
                    grid.getCell(x+3, y-3).setColor('y');
                    grid.getCell(x+3, y-4).setColor('y');
                    grid.getCell(x+3, y-6).setColor('y'); 
                }
            }
            else if("ElectronHead".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                grid.getCell(x, y).setColor('l');
            }
            else if("ElectronTail".equals(type))
            {
                int x = Integer.valueOf(line[1]);
                int y = Integer.valueOf(line[2]);
                grid.getCell(x, y).setColor('r');
            }
            
        }

        return grid;
        
    }
    
}
