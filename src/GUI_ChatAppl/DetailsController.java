/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
                System.out.println("Server addr : " + serveraddr);
                
                int port = Integer.parseInt(portno.getText());
                System.out.println("Port: " + port);
                
                
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
    });
        
        
        
    }    
    
}
