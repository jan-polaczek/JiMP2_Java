package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 01133123
 */
public class Main extends Application {
    FXMLDocumentController controller;

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/Views/FXMLDocument.fxml"));
        Parent root = loader.load();
        controller = (FXMLDocumentController) loader.getController();
        stage.initStyle(StageStyle.UNDECORATED);
        Group mainGroup = new Group();
        mainGroup.getChildren().add(root);

        mainGroup.getChildren().add(controller.getBoard());
        Scene scene = new Scene(mainGroup, Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.show();

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        launch(args);
    }

}
