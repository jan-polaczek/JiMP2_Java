/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Views.Observer;
/**
 *
 * @author 01133123
 */
public interface Observable {
    public abstract void registerObserver(Views.Observer observer);
    public abstract void notifyObservers();
    public abstract Grid getGrid();
}
