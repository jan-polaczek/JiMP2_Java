package Controllers;

import Models.Cell;
import Models.Grid;
import Views.GenerationView;
import Views.Observer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {

    public String saveFilePath;
    public boolean gamemode = false;
    public boolean pause = true;
    private final int CANVAS_WIDTH = 800;
    private final int CANVAS_HEIGHT = 700;
    private final int MARGIN_LEFT = 40;
    private final int MARGIN_TOP = 10;
    private final int CELL_GAP = 1;
    private float cellSizeX;
    private float cellSizeY;
    private int speed = 1;
    Models.Automaton automaton;
    Observer genView;

    @FXML
    private Button gamemodebtn;

    @FXML
    private Button speedbtn;
    
    @FXML
    private Button pausebtn;

    @FXML
    private Label labSingleFile;

    @FXML
    private FlowPane board = new FlowPane(0, 0);

    @FXML
    private void handleClose(MouseEvent event) {  //działanie przycisku EXIT
        System.exit(0);
    }

    @FXML
    private void FileChooser(MouseEvent event) {  //działanie przycisku LOAD FILE
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);

        if (f != null) {
            if (!this.gamemode) {
                this.automaton = new Models.WireWorld();
            } else {
                this.automaton = new Models.GoL();
            }
            try {
                this.automaton.setFile(f);
            } catch (Exception ex) {
                this.showException(ex);
            }
            this.createBoard();
            this.genView = new GenerationView(this.automaton, this);
            this.genView.register();
            this.automaton.setPause(this.pause);
            this.automaton.play();
        }

    }
    @FXML
    private void speedChange(MouseEvent event) {
        switch(this.speed)
        {
            case 0:
                this.speed = 1;
                speedbtn.setText("SPEED: NORMAL");
                break;
            case 1:
                this.speed = 2;
                speedbtn.setText("SPEED: FAST");
                break;
            case 2:
                this.speed = 0;
                speedbtn.setText("SPEED: SLOW");
                break;
        }
        this.automaton.setSpeed(this.speed);
    }
    @FXML
    private void FileSaver(MouseEvent event) {  //działanie przycisku SAVE TO FILE
        FileChooser fc = new FileChooser();
        String saveText = this.automaton.saveFile();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fc.getExtensionFilters().add(extFilter);
 
            //Show save file dialog
            File file = fc.showSaveDialog(null);
 
            if (file != null) {
                saveTextToFile(saveText, file);
            }
    }
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            
        }
    }
    @FXML
    private void GameChanger(MouseEvent event) { //działanie przycisku zmieniającego grę
        if (gamemode == false) {
            gamemode = true;               //tu powinna jeszcze zmieniać się nazwa przycisku
            gamemodebtn.setText("WIREWORLD");
        } else {
            gamemode = false;
            gamemodebtn.setText("GAME OF LIFE");
        }
    }

    @FXML
    private void StartStop(MouseEvent event) {  //działanie przycisku START
        if (this.pause == false) {
            this.pause = true;
            pausebtn.setText("START");
        } else {
            this.pause = false;
            pausebtn.setText("PAUSE");
        }
        this.automaton.setPause(this.pause);
    }

    @FXML
    private void RandomizeCells(MouseEvent event) {  //działanie przycisku RANDOMIZE
        // tutaj GUI wysyła wiadomość do kontrolera
        if (!this.gamemode) {
            this.automaton = new Models.WireWorld();
        } else {
            this.automaton = new Models.GoL();
        }
        this.automaton.randomize();
        this.createBoard();
        this.genView = new GenerationView(automaton, this);
        this.genView.register();
        this.automaton.setPause(this.pause);
        this.automaton.play();
    }

    public boolean isPaused() {
        return this.pause;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void createBoard() {
        if (this.pause == false) {
            pausebtn.setText("PAUSE");
        } else {
            pausebtn.setText("START");
        }
        board.getChildren().clear();
        board.setHgap(CELL_GAP);
        board.setVgap(CELL_GAP);
        board.setPadding(new Insets(MARGIN_TOP, 0, 0, MARGIN_LEFT));
        board.setMaxWidth(CANVAS_WIDTH + MARGIN_LEFT);
        board.setPrefWidth(CANVAS_WIDTH + MARGIN_LEFT);
        board.setMinWidth(CANVAS_WIDTH + MARGIN_LEFT);
        board.setPrefHeight(CANVAS_HEIGHT);
        board.setMinHeight(CANVAS_HEIGHT);
        board.setMaxHeight(CANVAS_HEIGHT);
        board.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                changeCell(mouseEvent);
            }
        });
        Grid grid = automaton.getGrid();
        int width = grid.getDimensions()[0];
        int height = grid.getDimensions()[1];
        this.cellSizeX = (CANVAS_WIDTH - MARGIN_LEFT) / width;
        this.cellSizeY = (CANVAS_HEIGHT - MARGIN_TOP) / height;
        for (int i = 0; i < height; i++) {
            for (int k = 0; k < width; k++) {
                Rectangle r = new Rectangle();
                Cell cell = automaton.getGrid().getCellReversed(i, k);
                r.setWidth(this.cellSizeX);
                r.setHeight(this.cellSizeY);
                switch (cell.getColor()) {
                    case 'b':
                        r.setFill(Paint.valueOf("000000"));
                        break;
                    case 'w':
                        r.setFill(Paint.valueOf("FFFFFF"));
                        break;
                    case 'l':
                        r.setFill(Paint.valueOf("0000FF"));
                        break;
                    case 'y':
                        r.setFill(Paint.valueOf("FFFF00"));
                        break;
                    case 'r':
                        r.setFill(Paint.valueOf("FF0000"));
                        break;
                }
                board.getChildren().add(r);
            }
        }

    }

    @FXML
    FlowPane getBoard() {
        return this.board;
    }

    private void showException(Exception ex) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("An exception has occured: ");
        alert.setContentText("Input file contains incorrect data" + ex);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
    @FXML
    void changeCell(MouseEvent event)
    {
        int x = ((int)event.getX() - MARGIN_LEFT)/(int)this.cellSizeX;
        int y = ((int)event.getY() - MARGIN_TOP)/(int)this.cellSizeY;
        if(this.gamemode)
        {
            this.automaton.getGrid().getCell(x, y).changeState();
        }
        else
        {
            if(event.getButton() == MouseButton.PRIMARY && !event.isShiftDown())
                this.automaton.getGrid().getCell(x, y).setColor('l');
            else if(event.getButton() == MouseButton.SECONDARY)
                this.automaton.getGrid().getCell(x, y).setColor('y');
            else if(event.getButton() == MouseButton.PRIMARY)
                this.automaton.getGrid().getCell(x, y).setColor('b');
        }
        this.createBoard();
    }
}
