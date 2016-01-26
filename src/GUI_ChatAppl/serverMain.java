/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_ChatAppl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author SreeraG
 */
public class serverMain extends Application{      //FULL-FLEDGED SERVER GUI
    
    
    public static void main(String [] x){
        launch(x);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent servermain = FXMLLoader.load(serverMain.class.getResource("Server_UI.fxml"));
        
        Scene scene = new Scene(servermain);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("~---SERVER---~");
        primaryStage.show();
        
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
