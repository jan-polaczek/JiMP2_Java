
package Views;

import java.util.Timer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.TimerTask;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
public class Main extends Application {
    private static final int REFRESH_TIME = 400;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Group mainGroup = new Group();
        mainGroup.getChildren().add( root );
        float x = 100, y = 100;
        Rectangle rectangle = new Rectangle(x, y, 50, 50);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rectangle.setX(rectangle.getX()+50f);
            }
        }, 0, REFRESH_TIME);
        
        mainGroup.getChildren().add(rectangle);
        
        Scene scene = new Scene(mainGroup);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
    
}
