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
    FXMLDocumentController controller;
    public GenerationView(Observable observable, FXMLDocumentController controller)
    {
        this.observable = observable;
        this.controller = controller;
    }
    @Override
    public void register()
    {
        this.observable.registerObserver(this);
    }
    @Override
    public void update() {
        this.grid = this.observable.getGrid();
        this.controller.createBoard();
    }
    
}
