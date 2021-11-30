package ryan.studenttest;
/*
Meghan Ryan
11/25/2021
List student names and their four test scores in a 2D array.
 */

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblList;
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
    private Button btnList;
    @FXML
    private Button btnStudentAverage;
    @FXML
    private Button btnCourseAverage;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnClear;
   
    double buttonSetHeight=0;
    double buttonSetWidth=0;
    
    String studentgrade[][]=new String[15][6];
    int student=-1;
    
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
        lblList.setText("Names               Test Scores");
        for( int i=0; i < student+1; i++) {
               lblList.setText(lblList.getText()+"\n" +"Student Number "+(i+1)+":  "+ studentgrade[i][0]+ " " + studentgrade[i][1]+ "   " + studentgrade[i][2]+ "   "+ studentgrade[i][3]+ "   "+ studentgrade[i][4]+ "   "+ studentgrade[i][5]);
           }
    }
    
    @FXML
    void btnAddClick(ActionEvent event) {
        if (student!=14){
            if (!txtFirstName.getText().equals("")&&!txtLastName.getText().equals("")&&!txtTest1.getText().equals("")&&!txtTest2.getText().equals("")&&!txtTest3.getText().equals("")&&!txtTest4.getText().equals("")){
                student++;
                studentgrade[student][0]=txtFirstName.getText();
                studentgrade[student][1]=txtLastName.getText();
                studentgrade[student][2]=txtTest1.getText();
                studentgrade[student][3]=txtTest2.getText();
                studentgrade[student][4]=txtTest3.getText();
                studentgrade[student][5]=txtTest4.getText();
            }
            else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("One or more text fields are empty.");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Student list is full! Clear list to add more students.");
            alert.showAndWait();
        }
    }
    
    @FXML
    void btnStudentAverageClick(ActionEvent event) {
        if (student==-1){
            noStudents();
        }
        else{
            int studentnum;
            int studentaverage;
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Student Test Score Average");
            dialog.setHeaderText("Input student number for their test scores average (1-15)");
            dialog.setContentText("Student Number Here:");
            Optional<String> result = dialog.showAndWait();
            studentnum=Integer.parseInt(dialog.getEditor().getText());
            if ((studentnum>=0)&&(studentnum<16)){
                int i = (studentnum-1);
                studentaverage=(Integer.parseInt(studentgrade[i][2])+Integer.parseInt(studentgrade[i][3])+Integer.parseInt(studentgrade[i][4])+ Integer.parseInt(studentgrade[i][5]))/4;
                lblList.setText(""+studentaverage);
                
            }
            else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid student number.");
                alert.showAndWait(); 
            }
        }
    }

    @FXML
    void btnCourseAverageClick(ActionEvent event) {
        int courseaverage=0;
        if (student==-1){
            noStudents();
        }
        else{
            for( int i=0; i < student+1; i++) {
                courseaverage=courseaverage+(Integer.parseInt(studentgrade[i][2])+Integer.parseInt(studentgrade[i][3])+Integer.parseInt(studentgrade[i][4])+ Integer.parseInt(studentgrade[i][5]));
            }
        lblList.setText(""+courseaverage/((student+1)*4));
        }
    }
    
    void noStudents(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("No students in the list.");
        alert.showAndWait();
    }
    
    @FXML
    void btnClearClick(ActionEvent event) {
        student=-1;
        for( int i=0; i < 15; i++) {
        studentgrade[i][0]=("No");    
        studentgrade[i][1]=("Name");
        studentgrade[i][2]=("0");
        studentgrade[i][3]=("0");
        studentgrade[i][4]=("0");
        studentgrade[i][5]=("0");
    }
    }

    @FXML
    void btnExitClick(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblList.setText("Names               Test Scores");
    }    
}
