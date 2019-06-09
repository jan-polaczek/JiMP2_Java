/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.InFileParserGoL;
import Parsers.OutputterGoL;
/**
 *
 * @author 01133123
 */
public class GoL extends Automaton {

    /**
     * klasa reprezentująca automat komórkowy - grę w życie
     */
    public GoL() {
        super();
        this.grid = new GridGoL();
        this.inparser = new InFileParserGoL();
        this.outputter = new OutputterGoL();
    }

}
