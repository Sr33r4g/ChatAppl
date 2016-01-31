/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import chatappl.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author SreeraG
 */
public class ClientUI_ControllerClass implements Initializable{

    Client c = new Client();
    
    public void startThread(){
    Thread t = new Thread(){
            public void run(){
                while(true){
                    fill(c.getFromServer());
                }
            }};     
        System.out.println("Started client thread....");
    t.start();
    }
    
    @FXML
    private Button clientButton;
    @FXML
     public TextArea clientDisplay ;
    @FXML
    private TextField clientMsg;
    
     public void fill(String value){
         clientDisplay.appendText("Server :" + value + "\n"); ;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //System.out.println("in here...");
            c.initialize();
            startThread();
            
            clientButton.setOnAction(z->{
                clientDisplay.appendText(clientMsg.getText() + "\n");
                    
                c.sendData(clientMsg.getText());
                
                clientMsg.setFocusTraversable(true);
                clientMsg.setText("");
                    });
             
            
        } catch (IOException ex) {
            Logger.getLogger(ClientUI_ControllerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
