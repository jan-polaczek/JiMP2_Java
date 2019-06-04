/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Views.Observer;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import Parsers.InFileParser;
/**
 *
 * @author 01133123
 */
public abstract class Automaton implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private Grid grid;
    private boolean isPaused;
    private File inFile;
    private InFileParser inparser;
    
    public Automaton(File inFile)
    {
        this.inFile = inFile;
        this.grid = this.inparser.parse(this.inFile);
        this.isPaused = true;
    }
    
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
    
    public Grid getGrid()
    {
        return this.grid;
    }
    
    public boolean isPaused()
    {
        return this.isPaused;
    }
    
    public void pause()
    {
        this.isPaused = !this.isPaused;
    }
}
