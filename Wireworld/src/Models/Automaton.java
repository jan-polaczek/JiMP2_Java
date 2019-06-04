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
import Parsers.Outputter;
/**
 *
 * @author 01133123
 */
public abstract class Automaton implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private Grid grid;
    private boolean isPaused;
    private File inFile;
    InFileParser inparser;
    Outputter outputter;
    
    /**
     *
     * @param inFile plik wejściowy z planszą automatu
     */
    public Automaton(File inFile)
    {
        this.inFile = inFile;
        this.grid = this.inparser.parse(this.inFile);
        this.isPaused = true;
    }
    
    /**
     *
     * @param observer obserwator
     */
    @Override
    public void registerObserver(Views.Observer observer)
    {
        observers.add(observer);
    }
    
    /**
     *
     */
    @Override
    public void notifyObservers()
    {
        observers.forEach((observer) -> {
            observer.update();
        });
    }
    
    /**
     *
     * @return dwuwymiarową listę komórek
     */
    
    @Override
    public Grid getGrid()
    {
        return this.grid;
    }
    
    /**
     *
     * @return 0 jeśli automat działa,
     * 1 jeśli jest zatrzymany
     */
    public boolean isPaused()
    {
        return this.isPaused;
    }
    
    /**
     * zatrzymuje działanie automatu jeżeli automat działa,
     * wznawia działanie, jeśli jest zatrzymany
     */
    public void pause()
    {
        this.isPaused = !this.isPaused;
    }

    /**
     * zapisuje obecny stan automatu do pliku tekstowego
     */
    public void saveFile()
    {
        outputter.saveFile(this.grid);
    }

    /**
     * wykonuje jedno przejście pomiędzy generacjami
     * i powiadamia obserwatorów
     */
    public void tick()
    {
        this.grid.tick();
        this.notifyObservers();
    }
    public void randomize()
    {
        this.grid.randomize();
    }
}
