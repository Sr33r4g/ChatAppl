/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;
//DELETE AFTER USAGE

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SreeraG
 */
public class ServerFile {
    
    ServerSocket serv;
    Socket isconn;
    public void startTransfer(int s,File f) throws IOException{
        int temp = s + 1;
        serv = new ServerSocket(25001);
        isconn = serv.accept();
        DataOutputStream dos = new DataOutputStream(isconn.getOutputStream());
        System.out.println("Got one connection... :)");
    
      //  File f = new File("C:\\Users\\SreeraG\\Documents\\FTPs\\ChatAppl\\src\\chatappl\\ProjectTracking.txt");
        FileInputStream file = new FileInputStream(f);
        byte [] bfile = new byte[(int) f.length()];
        
        file.read(bfile);
        
        dos.write(bfile);
        dos.flush();
        dos.close();
        
        System.out.println("done sending...");
        serv.close();
        isconn.close();
    }
    
    
    
    /*
    public static void main(String [] x){
        ServerFile s= new ServerFile();
        
        try{
            s.startTransfer();
            
        }catch(FileNotFoundException f){}
        catch(IOException e){}
        
    }*/
    
}
