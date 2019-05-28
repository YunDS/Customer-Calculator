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
    @FXML private Label CompareResult;
    @FXML private TextField FirMl, SecMl; 
    @FXML private TextField FirPrice, SecPrice; 
    @FXML private TextField FirPerprice, SecPerprice; 
    
    int div, sum, sediv, sesum;
    @FXML
    public void CalculateButtonAction (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MlCalc.fxml"));
        int ml, seml;
        int price, seprice;
        
        ml = Integer.parseInt(FirMl.getText());
        price = Integer.parseInt(FirPrice.getText());
        seml = Integer.parseInt(SecMl.getText());
        seprice = Integer.parseInt(SecPrice.getText());
        
        div = ml/100; sum = price/div;
        sediv = seml/100; sesum = seprice/sediv;
        
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
