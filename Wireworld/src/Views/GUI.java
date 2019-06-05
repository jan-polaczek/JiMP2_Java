/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Models.Grid;
import Models.Automaton;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author 01133123
 */
public class GUI {
    Group mainGroup = new Group();
    public void drawGrid(){
        float x = 100, y = 100;
        Rectangle rectangle = new Rectangle(x, y, 50, 50);
        mainGroup.getChildren().add(rectangle);
    }
}
