/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SreeraG
 */
public class ChatAppl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1:Server. ;)");
        System.out.println("2:Client. :)");
        int choice;
        System.out.println("Enter ur choice : ");
        Scanner s = new Scanner(System.in);
        choice = s.nextInt();
        switch(choice){
            case 1:
                System.out.println("In 1");
                break;
            case 2:
                System.out.println("In 2");
                break;
        }
    
        Server serv = new Server();
//        try{
//        Server.pre_start();
//        }catch(IOException e){}
        
        serv.start();
        
       
    }
    
}
