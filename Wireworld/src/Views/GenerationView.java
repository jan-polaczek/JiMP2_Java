/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Models.Grid;
import Models.Observable;
/**
 *
 * @author 01133123
 */
public class GenerationView implements Observer {
    Observable observable;
    Grid grid;
    GUI gui;
    @SuppressWarnings("LeakingThisInConstructor")
    public GenerationView(Observable observable, GUI gui)
    {
        this.observable = observable;
        this.observable.registerObserver(this);
        this.gui = gui;
    }
    @Override
    public void update() {
        this.grid = this.observable.getGrid();
        this.gui.drawGrid();
    }
    
}
