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
    private int REFRESH_TIME = 400;

    /**
     *
     * @param inFile plik wejściowy z planszą automatu
     */

    public void setPause(boolean pause) {
        this.isPaused = pause;
    }

    public void setFile(File inFile) throws ArrayIndexOutOfBoundsException{
        this.inFile = inFile;
        this.parse();
    }

    public void parse() throws ArrayIndexOutOfBoundsException{
        try {
            this.grid = this.inparser.parse(this.inFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WireWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param observer obserwator
     */
    @Override
    public void registerObserver(Views.Observer observer) {
        observers.add(observer);
    }

    /**
     *
     */
    @Override
    public void notifyObservers() {
        observers.forEach((observer) -> {
            observer.update();
        });
    }

    /**
     *
     * @return dwuwymiarową listę komórek
     */
    @Override
    public Grid getGrid() {
        return this.grid;
    }

    /**
     *
     * @return 0 jeśli automat działa, 1 jeśli jest zatrzymany
     */
    public boolean isPaused() {
        return this.isPaused;
    }

    /**
     * zapisuje obecny stan automatu do pliku tekstowego
     */
    public String saveFile() {
        return this.outputter.saveFile(this.grid);
    }

    /**
     * wykonuje jedno przejście pomiędzy generacjami i powiadamia obserwatorów
     */
    public void tick() {
        this.grid.tick();
        this.notifyObservers();
    }

    public void randomize() {
        this.grid.randomize();
    }

    public void play() {
        int period = REFRESH_TIME;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (!isPaused) {
                        tick();
                    }
                    if(period != REFRESH_TIME)
                    {
                        timer.cancel();
                        play();
                    }
                });
            }
        }, 0, period);
    }
    
   public void setSpeed(int speed) {
       switch(speed)
       {
           case 0:
               this.REFRESH_TIME = 800;
                break;
           case 1:
               this.REFRESH_TIME = 400;
               break;
           case 2:
               this.REFRESH_TIME = 200;
               break;
       }
   }
}
