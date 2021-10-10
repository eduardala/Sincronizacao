package Atividade2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Arquivo {
    
    private final String arquivo = "array.txt";
    
    public void gravar(int tamanho) throws IOException {
        BufferedWriter Buffer = new BufferedWriter(new FileWriter(this.arquivo));
        
        for (int i = 0; i <= tamanho; i++) {
            Buffer.write(i + "");
            //Buffer.write(new Random().nextInt(tamanho) + "");
            Buffer.newLine();
        }
        
        Buffer.close();
    }
    
    public ArrayList<Integer> ler() throws FileNotFoundException, IOException {
        BufferedReader Reader = new BufferedReader(new FileReader(this.arquivo));
        
        ArrayList<Integer> array = new ArrayList();
        
        while (true) {
            String linha = Reader.readLine();
                
            if (linha != null) {
                array.add(Integer.parseInt(linha));
            } else {
                break;
            }               
        } 
        
        Reader.close();
        
        return array;
    }  
    
}
