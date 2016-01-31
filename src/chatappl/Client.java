/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;

import GUI_ChatAppl.ClientUI_ControllerClass;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SreeraG
 */
public class Client {
    
    public static int port;
    Socket clientsoc;
    String toSend;
    public static String local;// = "localhost";
    static BufferedReader b1,b2;
    InetAddress inet;
    BufferedWriter bw;
    
    public void initialize() throws IOException{
        System.out.println("Server addr : " + local);
        System.out.println("Port : " + port);
        inet = InetAddress.getByName(local);
        clientsoc = new Socket(inet,port);
        b1 = new BufferedReader(new InputStreamReader(System.in));
        b2 = new BufferedReader(new InputStreamReader(clientsoc.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(clientsoc.getOutputStream()));
        System.out.println("Connected...");
    }
    
    public void sendData(String toSend){
        try{
     //   while(true){
//        toSend = b1.readLine();  FOR DEBUGGING
        System.out.println("Sending :" + toSend);
        bw.write(toSend+"\n");
        bw.flush();
        System.out.println("Sent");
   //     }
        }catch(IOException e){}
    }

    
    
    
    public String getFromServer(){
        String msg = null;
            try{
                System.out.println("-----Listerning to server-----");
            while(true)   {
                msg = b2.readLine();
                System.out.println(clientsoc.getInetAddress().getHostName()+"@" +(new Date().getTime())+" : " + msg);
                //return b2.readLine();
                break;
            }
            }catch(IOException e){}
    return msg;    
    }
    
    
/*  public void sendData1()throws IOException{//STRICKT TEST CODE
     //   while(true){
        toSend = b1.readLine();  //FOR DEBUGGING
        System.out.println("Sending :" + toSend);
        bw.write(toSend+"\n");
        bw.flush();
        System.out.println("Sent");
   //     }
    }  
    
    
    
    public void getFromServer1(){   //STRICTLY TEST CODE
        String msg = null;
            try{
                System.out.println("-----Listerning to server-----");
            while(true)   {
                msg = b2.readLine();
                System.out.println(clientsoc.getInetAddress().getHostName()+"@" +(new Date().getTime())+" : " + msg);
                //return b2.readLine();
               // break;
            }
            }catch(IOException e){}
//    return msg;    
    }
    
    
    public static void main(String [] x) throws IOException{
        
        Client c = new Client();
        BufferedReader b3 = new BufferedReader(new InputStreamReader(System.in));
        char ch = '\n';
        
        
        
        //COMMENT FROM HERE
//        while(ch == '\n'){
////        ch = (char) b3.read();
//        while(true){
//        try {
////            if(b2.ready()!= true)
//              c.sendData1();
//              } catch (IOException ex) {
//                  Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//              }
//              if(b2.ready() != true)
//                c.getFromServer1();
//            }
//        }
        
        //TILL HERE IF NEEDED.....
        
        
        
        
        
        Thread t1 = new Thread(){
            public void run(){
                System.out.println("In thread 1");
                try {
                    c.sendData();
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }};
        
        Thread t2 = new Thread(){
            public void run(){
             c.getFromServer1();
            }};     
        
        
        
        while(true){
            t1.start();
            t2.start();
        }
        }*/
}
