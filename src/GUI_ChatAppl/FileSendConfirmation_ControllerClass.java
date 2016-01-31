/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author SreeraG
 */
public class FileSendConfirmation_ControllerClass implements Initializable{
    
    
    @FXML
    private Button send;
    @FXML
    private Button dontsend;

    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    send.setOnAction(z -> System.out.println("Pressed yes"));
    
    dontsend.setOnAction(z -> System.out.println("Pressed no"));
    
    }
    
    
}
