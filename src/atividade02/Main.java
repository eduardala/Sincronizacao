
package Atividade2;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    static final int TAMANHO = 10000;
    static final int NUMERO_THREADS = 4;
    static final int NUMERO_BUSCADO   = 3;
    static final int TAMANHO_BUSCA = TAMANHO/NUMERO_THREADS;
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<Integer> array = new ArrayList();
        Arquivo arquivo = new Arquivo();
        
        arquivo.gravar(TAMANHO);       
        
        array = arquivo.ler();
        
        int anterior = 0;
        long inicioThread = System.currentTimeMillis();
        for (int i = 0; i < NUMERO_THREADS; i++) {
            new ArrayThread(array, NUMERO_BUSCADO, anterior, anterior + TAMANHO_BUSCA).start();
            anterior += TAMANHO_BUSCA;
        }       
        long fimThread = System.currentTimeMillis();

        long inicioNormal = System.currentTimeMillis();       
        System.out.println(busca(array));     
        long fimNormal = System.currentTimeMillis();
        
        System.out.println("Tempo de execução em Thread: " + (fimThread - inicioThread));
        System.out.println("Tempo de execução sem Thread: " + (fimNormal - inicioNormal));       
    }
    
    /**
     * Realiza a busca do valor informado no array.
     * 
     * @param  array
     * @return Integer
     */
    public static int busca(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == NUMERO_BUSCADO) {
                return i;
            }
        }
        return -1;
    }
    
}
