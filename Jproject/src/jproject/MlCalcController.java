/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
    @FXML private Label CompareResult;
    @FXML private TextField FirMl, SecMl; 
    @FXML private TextField FirPrice, SecPrice; 
    @FXML private TextField FirPerprice, SecPerprice; 
    
    double sum, sesum;
    @FXML
    public void CalculateButtonAction (ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MlCalc.fxml"));
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
    
    @FXML private Button SaveButton;
    @FXML private Label FirperPrice;
    @FXML private TextArea LoadDatashow;
    
    public void SaveButtonAction(ActionEvent event) throws IOException{
        FileChooser choose = new FileChooser();
        choose.getExtensionFilters().add(new ExtensionFilter("All files", "*.*"));
        File selectedFile = choose.showSaveDialog(primaryStage);
        if(selectedFile != null){

        }
    }
    
    public void LoadButtonAction(ActionEvent event, String txtFile) throws IOException{
        FileChooser loadchoose = new FileChooser();
        loadchoose.getExtensionFilters().addAll(
                new ExtensionFilter("Text File", "*.txt"),
                new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*")
        );
        File selectedFile = loadchoose.showOpenDialog(primaryStage);
        if(selectedFile != null){
            String text = null;
            
            BufferedReader br = null;
            try{
                br = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile)));
                String line;
                while((line = br.readLine()) != null){
                }
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
