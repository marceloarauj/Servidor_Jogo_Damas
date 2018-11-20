/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tata-_000
 */
public class GerenciadorDeJogadores extends Thread{
    
    public static ArrayList<GerenciadorDeJogadores> listaDeJogadores
             = new ArrayList<GerenciadorDeJogadores>();
    
    private Socket socket;
    
    private BufferedReader leitura;
    private PrintWriter escrita;
    
    public GerenciadorDeJogadores(Socket s){
        
        socket = s;
        
        start();
    }
    

    @Override
    public void run() {

        listaDeJogadores.add(this);
        
        try {
            leitura = new BufferedReader
                (new InputStreamReader(socket.getInputStream()));

            escrita = new PrintWriter(socket.getOutputStream(),true);
            
            
            while(true){
                
                NovoJogo novoJogo;
                
                if(listaDeJogadores.size()>=2){
                    
                    GerenciadorDeJogadores j1 = listaDeJogadores.get(0);
                    GerenciadorDeJogadores j2 = listaDeJogadores.get(1);
                    
                    novoJogo = new NovoJogo
                       (j1,j2);
                    
                    listaDeJogadores.remove(j1);
                    listaDeJogadores.remove(j2);
                    
                    
                }
                
                
            }
            
        } catch (IOException ex) {

        }
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getLeitura() {
        return leitura;
    }

    
}
