/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;

import GUI_ChatAppl.ClientUI_ControllerClass;
import GUI_ChatAppl.ServerUI_ControllerClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

/**
 *
 * @author SreeraG
 */
public class Server {
    static BufferedReader b,br;
    OutputStreamWriter osw;
    public BufferedWriter bw;String reply;
    ServerSocket server;
    public Socket clientChecker;
    public int servPort = 25000;
//    public DataOutputStream dos;
    
    
   
    
    public void start(){   //listens to client connections...        
        
        try{
            server = new ServerSocket(servPort);
            System.out.println("Started server....");
            clientChecker = server.accept();
            b = new BufferedReader(new InputStreamReader(clientChecker.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(clientChecker.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(System.in));
//            dos = new DataOutputStream(clientChecker.getOutputStream());
            System.out.println("clientChecker inside Server.java : " + clientChecker);
        }catch(IOException e){  
        }
        
    }        
            
    public String listenToClient(){
        String msg = null;
        try{
         //   System.out.println("-----Listening if the client is saying something or no-----");
        while(true) {
             msg = b.readLine();
            break;
                }
        }catch(IOException e){}
        return msg;
    }
    
    public void sentToClient(String s){
        try{
//            
        bw.write(s + "\n");
        bw.flush();
        }catch(IOException e){}
    }
    
    
    
    
    
    
    
    
  /*  public void sentToClient1(){ //STRICT TEST CODE 
        try{
//           
        bw.write("hey" + "\n");
        bw.flush();
        }catch(IOException e){}
    }
    
  public static void main(String [] x){
        Server s = new Server();
        
        s.start();
        
        //START COMMENTING FROM HERE....
//        while(true){
//            try{
//
//            s.sentToClient();
//            
////            if(b.ready() != true)
//                s.listenToClient();
//            }catch(IOException e){}
//        }
       
        //TO HERE IF THE NEED ARISES.....
        
        Thread t1 = new Thread(){
            public void run(){
             s.sentToClient1();
            }};     
        
        Thread t2 = new Thread(){
            public void run(){
                try {
                    s.listenToClient();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }};    
        
            t1.start();
            t2.start();
    }*/
    
 

        
}
