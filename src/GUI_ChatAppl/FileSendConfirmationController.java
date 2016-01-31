/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;


import chatappl.Server;
import chatappl.ServerFile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SreeraG
 */
public class FileSendConfirmationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button send;
    @FXML
    private Button dontsend;
	
	
	
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        send.setOnAction(z -> {    
            try {
                
            ServerUI_ControllerClass.serv.sentToClient(".1");
            ServerUI_ControllerClass.serv.sentToClient(ServerUI_ControllerClass.name);
            
            ServerFile s = new ServerFile();
            s.startTransfer(ServerUI_ControllerClass.serv.servPort,ServerUI_ControllerClass.f);
            
            Stage stage = (Stage) send.getScene().getWindow();
            stage.close();
            
            } catch (IOException ex) {
                Logger.getLogger(FileSendConfirmationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
        
        dontsend.setOnAction(z -> {
            
            Stage stage = (Stage) dontsend.getScene().getWindow();
            stage.close();
            
    }    
    
}
