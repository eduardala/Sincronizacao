/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadConsumidor implements Runnable{

    private ArrayList<Integer> vetor;
    
    public ThreadConsumidor(ArrayList<Integer> vetor) throws IOException {        
        this.vetor = vetor;
    }
    
    @Override
    public synchronized void run() {      
        while(!this.vetor.isEmpty()){
            System.out.println("Valor a ser retirado : "+ this.vetor.get(0));
            this.vetor.remove(0);
            
            if(this.vetor.isEmpty()){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
}
