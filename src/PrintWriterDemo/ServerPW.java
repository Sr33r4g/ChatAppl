/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintWriterDemo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SreeraG
 */
public class ServerPW {
    
    ServerSocket servsoc;
    PrintWriter pw;
    Socket clientconn;
    
    public void serverDoing() throws IOException{
        
        servsoc = new ServerSocket(15000);
        clientconn = servsoc.accept();
        File f = new File("Z:\\IPAD BACKUP\\CHUNCKY\\bman.cbr");
        pw = new PrintWriter(clientconn.getOutputStream(),true);
        pw.print(f);
        
        System.out.println("Sending the file...");
        
        while(true)
                pw.print(f);
    }
    
    
    public static void main(String[] args) {
        
        try {
            ServerPW s = new ServerPW();
            s.serverDoing();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerPW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
