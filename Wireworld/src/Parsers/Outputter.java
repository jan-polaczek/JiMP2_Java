/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;
import Models.Grid;
import java.io.File;
/**
 *
 * @author 01133123
 */
public interface Outputter {
    public abstract void saveFile(Grid grid);
}
