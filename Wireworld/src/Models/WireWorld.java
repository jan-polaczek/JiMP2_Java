/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Parsers.InFileParserWW;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 01133123
 */
public class WireWorld extends Automaton {
    
    public WireWorld() {
        super();
        int[] dims = new int[2];
        dims[0] = 5;
        dims[1] = 5;
        Cell[][] cellsList = new Cell[5][5];
        for (int i=0; i<5; i++)
            for (int k=0; k<5; k++)
                cellsList[i][k] = new Cell('b');
        this.grid = new GridWW(cellsList, dims);
    }

    @Override
    public void parse() {
        this.inparser = new InFileParserWW();
        try {
            this.grid = this.inparser.parse(this.inFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WireWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
