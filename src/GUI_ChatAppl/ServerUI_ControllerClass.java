/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import chatappl.Server;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author SreeraG
 */
public class ServerUI_ControllerClass implements Initializable {
    public static File f;
    static Server serv = new Server();
    public static String name;
    
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
    public TextField serverMsg;// = new TextField();
    @FXML
    private TextArea serverDisplay;// = new TextArea();
    @FXML
    private Button serverSendFileBttn;
    @FXML
    private Button connectedClients;
    
    
    
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
        
        
        
        //File Sending Functionality.....
        serverSendFileBttn.setOnAction(z->{
                
            try {
                FileChooser filechooser = new FileChooser();
                filechooser.setTitle("~~===Select the file to send===~~");
                f = filechooser.showOpenDialog(serverMain.primaryStage);
                
                System.out.println("File selected is : " + f);
                
               
                if(f != null){
              
                serverMsg.setText(f.toString());
                name = f.getName();
                Parent root = FXMLLoader.load(commonCallerClass.class.getResource("FileSendConfirmation.fxml"));
                Stage s = new Stage();
                    
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.show();
                
                System.out.println("In here after closing....");
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerUI_ControllerClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
        
        connectedClients.setOnAction(z->{
            
            
            
            
            
        });
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
