/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.InFileParserGoL;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 01133123
 */
public class GoL extends Automaton {
    
    public GoL() {
        super();
    }

    @Override
    public void parse() {
        this.inparser = new InFileParserGoL();
        try {
            this.grid = this.inparser.parse(this.inFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WireWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
