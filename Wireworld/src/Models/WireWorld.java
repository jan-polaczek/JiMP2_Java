/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.InFileParserWW;
import Parsers.OutputterWW;
/**
 *
 * @author 01133123
 */
public class WireWorld extends Automaton {

    /**
     *
     */
    public WireWorld() {
        super();
        this.grid = new GridWW();
        this.inparser = new InFileParserWW();
        this.outputter = new OutputterWW();
    }

}
