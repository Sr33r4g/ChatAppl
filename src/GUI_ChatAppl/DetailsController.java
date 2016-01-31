/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import chatappl.Client;
import chatappl.Server;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SreeraG
 */

                //THIS IS USED TO DISPLAY A WINDOW TO ENTER THE SERVER'S IPADDRESS AND PORT No.


public class DetailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField s1;
    @FXML
    private TextField s2;
                                //Server address broken into discreet parts
    @FXML
    private TextField s3;
    @FXML
    private TextField s4;
    
    
    
    @FXML               //port no
    private TextField portno;
    
    
    @FXML
    Button ok;
    @FXML
    Button cancel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ok.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String serveraddr = s1.getText() + "."+ s2.getText() +"."+ s3.getText() +"."+ s4.getText();
//                System.out.println("Server addr : " + serveraddr);
                
                int port = Integer.parseInt(portno.getText());
//                System.out.println("Port: " + port);
                
                Client.local = serveraddr;
                Client.port = Integer.parseInt(portno.getText());
//                detailsMain.primaryStage.setScene(clientMain.launch(x));
                Stage primaryStage = new Stage();
                Parent p2 = null;
                try {
                    p2 = FXMLLoader.load(clientMain.class.getResource("Client_UI.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        Scene scene = new Scene(p2);
        
        primaryStage.setTitle("~----CLIENT----~");
        primaryStage.setScene(scene);
        primaryStage.show();
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            
            
//                detailsMain.primaryStage.close();
            
            }
        
    });
        
        
        
    }    
    
}
