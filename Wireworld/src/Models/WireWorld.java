/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Parsers.InFileParserWW;
import java.io.File;

/**
 *
 * @author 01133123
 */
public class WireWorld extends Automaton {
    
    public WireWorld(File inFile) {
        super(inFile);
        this.inparser = new InFileParserWW();
        this.grid = this.inparser.parse(this.inFile);
    }
    
}
