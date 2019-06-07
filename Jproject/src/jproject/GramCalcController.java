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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yds92
 */
public class GramCalcController implements Initializable {
    @FXML private Label GramCompareResult;
    @FXML private TextField Firgram, Secgram; 
    @FXML private TextField FirGprice, SecGprice; 
    @FXML private TextField FirGperprice, SecGperprice; 
    @FXML private RadioButton Hundred, Ten;
    
    double sum, sesum;
    @FXML
    public void CalculateGramButtonAction (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MlCalc.fxml"));
        int gram, segram;
        int price, seprice;
        boolean CheckHundred = Hundred.isSelected();
        boolean CheckTen = Ten.isSelected();
        Alert alert = new Alert(AlertType.INFORMATION);
        
        gram = Integer.parseInt(Firgram.getText());
        price = Integer.parseInt(FirGprice.getText());
        segram = Integer.parseInt(Secgram.getText());
        seprice = Integer.parseInt(SecGprice.getText());
        
        if((CheckHundred == true) && (CheckTen == false)){
            sum = price*100/gram;
            sesum = seprice*100/segram;
        }
        else if((CheckHundred == false) && (CheckTen == true)){
            sum = price*10/gram;
            sesum = seprice*10/segram;
        }
        else if((CheckHundred == true) && (CheckTen == true)){

            alert.setTitle("오류");
            alert.setHeaderText("계산의 기준이 두개다 선택되어있습니다.");
            alert.setContentText("100g 과 10g중 하나만 선택해 주세요.");
            alert.showAndWait();
        }
        else{
            alert.setTitle("오류");
            alert.setHeaderText("계산의 기준을 정해주세요");
            alert.setContentText("100g 과 10g중에 하나만 선택해주세요.");
            alert.showAndWait();
        }
        
        FirGperprice.setText(String.valueOf(sum));    
        SecGperprice.setText(String.valueOf(sesum));
    }
    
    @FXML private TextField GFirName, GSecName;
    public void GramCompareButtonAction(ActionEvent event) throws IOException{
        String FirstN = GFirName.getText();
        String SecN = GSecName.getText();
        if(sum >= sesum)
            GramCompareResult.setText(SecN + "이(가) " + FirstN + "보다 " + (sum-sesum) + "원 더 저렴 합니다.");
        else
            GramCompareResult.setText(FirstN + "이(가) " + SecN + "보다 " + (sesum-sum) + "원 더 저렴 합니다.");
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
