/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jproject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yds92
 */
public class MlCalcController implements Initializable {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MlCalc.fxml"));
    
    @FXML private Label CompareResult;
    @FXML private TextField FirMl, SecMl; 
    @FXML private TextField FirPrice, SecPrice; 
    @FXML private TextField FirPerprice, SecPerprice;
    
    double sum, sesum;
    @FXML
    public void CalculateButtonAction (ActionEvent event) throws IOException{

        int ml, seml;
        int price, seprice;
        
        ml = Integer.parseInt(FirMl.getText());
        price = Integer.parseInt(FirPrice.getText());
        seml = Integer.parseInt(SecMl.getText());
        seprice = Integer.parseInt(SecPrice.getText());
        
        sum = price*100/ml;
        sesum = seprice*100/seml;
        
        FirPerprice.setText(String.valueOf(sum));    
        SecPerprice.setText(String.valueOf(sesum));
    }
    
    @FXML private TextField FirName, SecName;
    
    public void CompareButtonAction(ActionEvent event) throws IOException{
        String FirstN = FirName.getText();
        String SecN = SecName.getText();
        if(sum >= sesum)
            CompareResult.setText(SecN + "이(가) " + FirstN + "보다 " + (sum-sesum) + "원 더 저렴 합니다.");
        else
            CompareResult.setText(FirstN + "이(가) " + SecN + "보다 " + (sesum-sum) + "원 더 저렴 합니다.");
    }
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    @FXML private Button BacktoMain;
    public void BacktoMainButtonAction(ActionEvent event) throws IOException{
        Parent MainFxml = FXMLLoader.load(getClass().getResource("MainFxml.fxml"));
        Scene scene = new Scene(MainFxml);
        Stage primaryStage = (Stage)BacktoMain.getScene().getWindow();
        primaryStage.setScene(scene);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
