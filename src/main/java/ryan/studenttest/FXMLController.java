package ryan.studenttest;
/*
Meghan Ryan
11/25/2021
List student names and their four test scores in a 2D array.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
    @FXML
    private Button btnList;
   
    boolean hovered=false;
    double buttonSetHeight=0;
    double buttonSetWidth=0;
    
    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        hovered=true;
        Button button = (Button) event.getSource();
        buttonSetHeight=button.getPrefHeight();
        buttonSetWidth=button.getPrefWidth();
        button.setPrefHeight(buttonSetHeight*1.1);
        button.setPrefWidth(buttonSetWidth*1.1);
        button.setTranslateX((buttonSetWidth-buttonSetWidth*1.1)/2);
        button.setTranslateY((buttonSetWidth-buttonSetWidth*1.1)/2);
        button.toFront();     
    }
    
    @FXML
    void btnUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(buttonSetHeight);
        button.setPrefWidth(buttonSetWidth);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
    }
    
    @FXML
    void btnListClick(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //TODO
    }    
}
