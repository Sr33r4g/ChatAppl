/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;
//DELETE AFTER USAGE

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author SreeraG
 */
public class ClientFile {
    Socket conn;
    String local = "localhost";
    void connectToServer() throws IOException{
        conn = new Socket(local,25000);
        System.out.println("Connected");
    }
    
    void getFile() throws IOException{
        File file = new File("C:\\Users\\SreeraG\\Documents\\FTPs\\ChatAppl\\src\\chatappl\\");
        
        FileOutputStream fin = new FileOutputStream(file);
        
        DataInputStream ds = new DataInputStream(conn.getInputStream());
        int b ;
        while((b = ds.read()) > -1)
            fin.write(b);
        
        System.out.println("And its done...");
        
    }
    
    
    public static void main(String [] x) throws IOException{
        ClientFile cf = new ClientFile();
        
        
        cf.connectToServer();
        cf.getFile();
    }
    
}
