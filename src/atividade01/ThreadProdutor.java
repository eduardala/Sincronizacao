/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadProdutor implements Runnable {
    private int quantidade;
    private ArrayList<Integer> vetor;
    
    
    public ThreadProdutor(int quantidade, ArrayList<Integer> vetor) throws IOException {        
        this.quantidade = quantidade;
        this.vetor = vetor;
    }
    
    @Override
    public synchronized void run() {
        try {
            for(int i=0; i<this.quantidade;i++){
                int valor = new Random().nextInt(10);
                System.out.println("Fibo de - "+valor);
                int fibo = fibonnacci(valor);
                
                System.out.println(this.vetor.size()+" - " + fibo);
                int tamanho = this.vetor.size();
                System.out.println("Tamanho array "+tamanho);
                
                while(tamanho == 4){
                   Thread.sleep(10); 
                   tamanho = this.vetor.size();
                }
                this.vetor.add(fibo);    
            }
                   
        } catch (IOException ex) {
            Logger.getLogger(ThreadProdutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadProdutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int fibonnacci(int numero) throws IOException{
        if(numero < 2){
            return numero;
        }
        else {           
            return fibonnacci(numero - 1) + fibonnacci(numero - 2 );
        }
    }
}
