package Atividade2;

import java.util.ArrayList;

public class ArrayThread extends Thread {
    
    private ArrayList<Integer> array;
    
    private static boolean encontrou = false;
    
    private final int valorBuscado;  
    private final int inicio;
    private final int fim;

    /**
     * @param array
     * @param valor
     * @param inicio
     * @param fim
     */
    public ArrayThread(ArrayList<Integer> array, int valor, int inicio, int fim) {
        this.array  = array;
        this.valorBuscado  = valor;
        this.inicio = inicio;
        this.fim    = fim;
    }
    
    @Override
    public synchronized void run() {
        if (encontrou) {
            this.interrupt();
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + this.busca());
        }      
    }
    
    /**
     * Realiza a busca do valor informado no array.
     */
    private int busca() {
        for (int i = inicio; i < fim; i++) {
            if (encontrou) {
                this.interrupt();
            }
            if (this.array.get(i) == this.valorBuscado) {
                encontrou = true;
                return i;
            }
        }
        return -1;
    }
    
}
