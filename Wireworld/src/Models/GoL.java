/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.InFileParserGoL;

/**
 *
 * @author 01133123
 */
public class GoL extends Automaton {

    public GoL() {
        super();
        this.grid = new GridGoL();
        this.inparser = new InFileParserGoL();
    }

}
