
package Views;
import Models.Automaton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;

public class FXMLDocumentController implements Initializable {
    @FXML
    public String lstfile;
    @FXML
    public boolean gamemode;
    @FXML
    public boolean pause;
    
    Models.Automaton automaton;
    
    @FXML
    private Label labSingleFile;
    
    
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
       if(this.gamemode==false) {
           this.gamemode=true;               //tu powinna jeszcze zmieniać się nazwa przycisku
       }
       else
       {
           this.gamemode=false;
       }
    }
    
    @FXML
    private void StartStop(MouseEvent event) {  //działanie przycisku START
        if(this.pause==false) {
           this.pause=true;  
       }
       else
       {
           this.pause=false;
       }
    }
    
    @FXML
    private void RandomizeCells(MouseEvent event) {  //działanie przycisku RANDOMIZE
        // tutaj GUI wysyła wiadomość do kontrolera
        automaton.randomize();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
