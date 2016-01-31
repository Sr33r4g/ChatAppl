/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;   //A USELESS FILE.... it is called from DetailsController.java

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author SreeraG          //DOESNT SEEM TO BE OF USE AS OF YET.....
 */

public class commonCallerClass extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        /*
        Parent p2 = FXMLLoader.load(commonCallerClass.class.getResource("Client_UI.fxml"));
        
        
        Scene scene = new Scene(p2);
        
        primaryStage.setTitle("~----CLIENT----~");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        */
    }

    /**
     * @param args the command line arguments
    */ 
    public static void main(String[] args) {
        launch(args);
    }
    
}
