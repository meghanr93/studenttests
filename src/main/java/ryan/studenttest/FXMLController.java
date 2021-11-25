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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
    @FXML
    private Button btnList;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtTest1;
    @FXML
    private TextField txtTest2;
    @FXML
    private TextField txtTest3;
    @FXML
    private TextField txtTest4;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnStudentAverage;
    @FXML
    private Button btnCourseAverage;
    @FXML
    private Button btnExit;
   
    double buttonSetHeight=0;
    double buttonSetWidth=0;
    
    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        Button button = (Button) event.getSource();
        buttonSetHeight=button.getPrefHeight();
        buttonSetWidth=button.getPrefWidth();
        button.setPrefHeight(buttonSetHeight*1.1);
        button.setPrefWidth(buttonSetWidth*1.1);
        button.setTranslateX((buttonSetWidth-buttonSetWidth*1.1)/2);
        button.setTranslateY((buttonSetHeight-buttonSetHeight*1.1)/2);
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
    
    @FXML
    void btnAddClick(ActionEvent event) {

    }
    
    @FXML
    void btnStudentAverageClick(ActionEvent event) {

    }

    @FXML
    void btnCourseAverageClick(ActionEvent event) {

    }

    @FXML
    void btnExitClick(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //TODO
    }    
}
