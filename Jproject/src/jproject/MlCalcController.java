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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yds92
 */
public class MlCalcController implements Initializable {
    @FXML private Label FirstOneName;
    @FXML private TextField FirName;
    @FXML private TextField FirMl; 
    @FXML private TextField FirPrice; 
    @FXML private TextField FirPerprice; 
    
    @FXML
    public void CalculateButtonAction (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MlCalc.fxml"));
        int  ml = Integer.parseInt(FirMl.getText());
        int price = Integer.parseInt(FirPrice.getText());
        int div, sum;
        div = ml/100;
        sum = price/div;
        FirPerprice.setText(String.valueOf(sum));
        FirstOneName.setText(FirName.getText());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
