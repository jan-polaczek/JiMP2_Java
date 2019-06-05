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
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
/**
 *
 * @author 01133123
 */
public abstract class Automaton implements Observable {
    private List<Observer> observers = new ArrayList<>();
    Grid grid;
    private boolean isPaused;
    File inFile;
    InFileParser inparser;
    Outputter outputter;
    private final int REFRESH_TIME = 400;
    /**
     *
     * @param inFile plik wejściowy z planszą automatu
     */
    public Automaton()
    {
        this.isPaused = true;
        
    }
    public void setFile(File inFile)
    {
        this.inFile = inFile;
    }
    public abstract void parse();
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
    public void play()
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
         Platform.runLater(new Runnable() {
            public void run() {
                tick();
            }
            });
            }
        }, 0, REFRESH_TIME);
    }
}
