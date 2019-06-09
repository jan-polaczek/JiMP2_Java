package Controllers;

import Models.Observable;
import Views.Observer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static final int REFRESH_TIME = 400;
    Observer genView;
    Observable automaton;
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

    public static void main(String[] args) {

        launch(args);
    }

}
