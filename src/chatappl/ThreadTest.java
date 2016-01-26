/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SreeraG
 */
public class ThreadTest {
    
            
            
            public static void main(String [] x){
                Thread t1,t2;
                CyclicBarrier c = new CyclicBarrier(3);
                t1 = new Thread(){
                  public void run(){
                      try{
                      c.await();
                      }catch(InterruptedException i){} catch (BrokenBarrierException ex) {
                          Logger.getLogger(ThreadTest.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      for(int i = 0; i < 10; i++)
                          System.out.println("i : " + i);
                  }};
                
                t2 = new Thread(){
                  public void run(){
                      try{
                      c.await();
                      }catch(InterruptedException i){} catch (BrokenBarrierException ex) {
                          Logger.getLogger(ThreadTest.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      for(int i = 0; i < 10; i++)
                          System.out.println("jayzz : " + i);
                  }};
                
                t1.start();
                t2.start();
                
            }
}
