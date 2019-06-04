/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Views.Observer;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 01133123
 */
public abstract class Automaton implements Observable {
    protected List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Views.Observer observer)
    {
        observers.add(observer);
    }
    
    @Override
    public void notifyObservers()
    {
        observers.forEach((observer) -> {
            observer.update();
        });
    }
}
