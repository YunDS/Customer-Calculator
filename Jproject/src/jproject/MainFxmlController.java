/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author yds92
 */
public class MainFxmlController implements Initializable {
    @FXML private Button mlbutton;
    
    public void MLButtonAction(ActionEvent event) throws IOException{
        Parent MlCalc = FXMLLoader.load(getClass().getResource("MlCalc.fxml"));
        Scene scene = new Scene(MlCalc);
        Stage primaryStage = (Stage)mlbutton.getScene().getWindow();
        primaryStage.setScene(scene);
       
    }
    
    @FXML private Button grambutton;
    public void GramButtonAction(ActionEvent event) throws IOException{
        Parent GramCalc = FXMLLoader.load(getClass().getResource("GramCalc.fxml"));
        Scene scene = new Scene(GramCalc);
        Stage primaryStage = (Stage)grambutton.getScene().getWindow();
        primaryStage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}