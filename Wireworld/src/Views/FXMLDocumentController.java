
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


public class FXMLDocumentController implements Initializable {
    
    public String lstfile;
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
    
    /*@FXML
    private void FileChooser(ActionEvent event) {
     FileChooser fc = new FileChooser();
     fc.getExtensionFilters().add(new ExtensionFilter("Word Files", lstFile));
     
     
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
