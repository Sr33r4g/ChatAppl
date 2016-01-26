/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import chatappl.Server;
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
public class ServerUI_ControllerClass implements Initializable {

    Server serv = new Server();
    
    public void startThreads(){
    Thread t1 = new Thread(){
            public void run(){
                while(true){
                fill(serv.listenToClient());
                }
            }};
        System.out.println("Thread created...now listening");
        t1.start();
    }
    
    @FXML
    private Button serverButton;
    @FXML
    private TextField serverMsg;// = new TextField();
    @FXML
    private TextArea serverDisplay;// = new TextArea();
    
    
    public void fill(String value){
        
            serverDisplay.appendText("Client :" + value + "\n"); 
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        serv.start();
        startThreads();
        serverButton.setOnAction(e->{
            //this is working...indeed
                serverDisplay.appendText("Server : " + serverMsg.getText() +"\n");
                serv.sentToClient(serverMsg.getText());
                serverMsg.setFocusTraversable(true);
                serverMsg.setText("");
                serverMsg.setFocusTraversable(true);
            });
        
        
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
