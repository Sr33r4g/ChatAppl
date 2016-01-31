/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintWriterDemo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SreeraG
 */
public class ClientPW {
    
    Socket s;
    BufferedReader b;
    
    void clientdoing() throws IOException{
        
        s = new Socket("localhost",15000);
        
        b = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        FileOutputStream fout = new FileOutputStream("C:\\Users\\SreeraG\\Desktop\\test.cbr");
        
        int z;
        while(( z = b.read()) > -1){
        
            fout.write(z);
    }
    }
    
    
    
    
    public static void main(String[] args) {
        try {
            ClientPW c = new ClientPW();
            c.clientdoing();
        } catch (IOException ex) {
            Logger.getLogger(ClientPW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
