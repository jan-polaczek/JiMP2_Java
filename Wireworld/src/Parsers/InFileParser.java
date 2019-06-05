/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;
import Models.Grid;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author 01133123
 */
public interface InFileParser {
    public abstract Grid parse (File inFile) throws FileNotFoundException ;
}
