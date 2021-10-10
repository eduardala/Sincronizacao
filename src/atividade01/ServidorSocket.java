package atividade01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = null;
        Socket conexao = null;
        BufferedReader entrada = null;
        ArrayList<Integer> vetor = new ArrayList();
        
        try {
            servidor = new ServerSocket(3322);
            conexao = servidor.accept();

            entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            do {
                String texto = entrada.readLine();
                String[] parametros = texto.split(" ");

                if (parametros[0].equals("new") && parametros[1] != null) {
                    int qtd = Integer.parseInt(parametros[1]);
                    
                    Thread thread = new Thread(new ThreadProdutor(qtd, vetor));
                    thread.start();
                    
                    Thread consumidor = new Thread(new ThreadConsumidor(vetor));
                    consumidor.start();
                } 
                else {
                    break;
                }
            } 
            while (!"sair".equals(entrada.toString()));

        } catch (IOException e) {
            System.out.println("Algo de errado aconteceu!");
        } finally {
            conexao.close();
            servidor.close();
        }
    }
}

