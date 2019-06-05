
package Views;

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
    private Label label;
    @FXML
    public boolean gamemode;
    @FXML
    public boolean pause;
    
    
    @FXML
    private Label labSingleFile;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
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
         labSingleFile.setText(f.getAbsolutePath()); //tu powinno wysyłać plik do controllera, na razie tylko pobiera ścieżkę do pliku
         // Automaton automaton = new Models.WireWorld(f);
     }
     
    }
    
    @FXML
    private void FileSaver(MouseEvent event) {  //działanie przycisku SAVE TO FILE
        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);
        lstfile=f.getAbsolutePath();   //w stringu lstfile znajduje sie ścieżka do wybranego przez użytkownika pliku, program powinien zapisywać tam aktualne położenia komórek, ale nie zapisuje :(
    }
    
    @FXML
    private void GameChanger(MouseEvent event) { //działanie przycisku zmieniającego grę
       if(gamemode==false) {
           gamemode=true;               //tu powinna jeszcze zmieniać się nazwa przycisku
       }
       else
       {
           gamemode=false;
       }
    }
    
    @FXML
    private void StartStop(MouseEvent event) {  //działanie przycisku START
        if(pause==false) {
           pause=true;  
       }
       else
       {
           pause=false;
       }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
