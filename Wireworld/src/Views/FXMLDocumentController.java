
package Views;
import Models.Automaton;
import Models.Grid;
import Models.Cell;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

public class FXMLDocumentController implements Initializable {
    @FXML
    public String lstfile;
    public boolean gamemode = false;
    public boolean pause = true;
    private final float CANVAS_WIDTH = 850;
    private final float CANVAS_HEIGHT = 650;
    private float cellSizeX;
    private float cellSizeY;
    Models.Automaton automaton;
    
    @FXML
    private Button gamemodebtn;
    
    @FXML
    private Button pausebtn;
    
    @FXML
    private Label labSingleFile;
    
    @FXML
    private FlowPane board;
    
    private void setAutomaton(Automaton automaton)
    {
        this.automaton = automaton;
    }
    @FXML
    private void handleClose(MouseEvent event) {  //działanie przycisku EXIT
        System.exit(0);
    }
    
    @FXML
    private void FileChooser(MouseEvent event) {  //działanie przycisku LOAD FILE
     FileChooser fc = new FileChooser();
     File f = fc.showOpenDialog(null);
     
     if(f != null)
     {
         this.labSingleFile.setText(f.getAbsolutePath()); //tu powinno wysyłać plik do controllera, na razie tylko pobiera ścieżkę do pliku
         if(this.gamemode == false) this.automaton = new Models.WireWorld(f);
         else this.automaton = new Models.GoL(f);
     }
     
    }
    
    @FXML
    private void FileSaver(MouseEvent event) {  //działanie przycisku SAVE TO FILE
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);
        this.lstfile=f.getAbsolutePath();   //w stringu lstfile znajduje sie ścieżka do wybranego przez użytkownika pliku, program powinien zapisywać tam aktualne położenia komórek, ale nie zapisuje :(
    }
    
    @FXML
    private void GameChanger(MouseEvent event) { //działanie przycisku zmieniającego grę
       if(gamemode==false) {
           gamemode=true;               //tu powinna jeszcze zmieniać się nazwa przycisku
           gamemodebtn.setText("WIREWORLD");
       }
       else
       {
           gamemode=false;
           gamemodebtn.setText("GAME OF LIFE");
       }
    }
    
    @FXML
    private void StartStop(MouseEvent event) {  //działanie przycisku START
        if(this.pause==false) {
           this.pause=true;
           pausebtn.setText("START");
       }
       else
       {
           this.pause=false;
           pausebtn.setText("PAUSE");
       }
    }
    
    @FXML
    private void RandomizeCells(MouseEvent event) {  //działanie przycisku RANDOMIZE
        // tutaj GUI wysyła wiadomość do kontrolera
        this.automaton.randomize();
    }
    
    public boolean isPaused()
    {
        return this.pause;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void initializeBoard()
    {
        board.getChildren().clear();
        Grid grid = automaton.getGrid();
        int width = grid.getDimensions()[0];
        int height = grid.getDimensions()[1];
        this.cellSizeX = CANVAS_WIDTH/width;
        this.cellSizeY = CANVAS_HEIGHT/height;
        for (int i=0; i<width; i++)
        {
            for(int k=0; k<height; k++)
            {
                Rectangle r = new Rectangle();
                Cell cell = automaton.getGrid().getCell(i, k);
                r.setWidth(this.cellSizeX);
                r.setHeight(this.cellSizeY);
                switch(cell.getColor())
                {
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
                        r.setFill(Paint.valueOf("00FFFF"));
                    break;
                    case 'r':
                        r.setFill(Paint.valueOf("FF0000"));
                    break;
                }
                board.getChildren().add(r);
            }
        }
    }
}
