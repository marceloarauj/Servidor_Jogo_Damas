/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author tata-_000
 */
public class NovoJogo extends Thread {
 
    GerenciadorDeJogadores jogador1;
    GerenciadorDeJogadores jogador2;
    
    boolean vezJogador1=true;
    
    public NovoJogo(GerenciadorDeJogadores j1, GerenciadorDeJogadores j2){
        
        jogador1 = j1;
        jogador2= j2;
              
        start();
    }

    @Override
    public void run() {

        try{
        
           PrintWriter iniciarJogo =
                 new PrintWriter(jogador1.getSocket().getOutputStream(),true); 
            
           iniciarJogo.println("iniciar!");
           
           iniciarJogo =
                 new PrintWriter(jogador2.getSocket().getOutputStream(),true); 
            
           iniciarJogo.println("iniciar!");
        // recebimento de mensagens    
            
         BufferedReader entradaJogador1 = new BufferedReader
                 (new InputStreamReader(jogador1.getSocket().getInputStream()));
        
         BufferedReader entradaJogador2 = new BufferedReader
                 (new InputStreamReader(jogador2.getSocket().getInputStream()));
        
         // troca de mensagens
         
         PrintWriter envioPara1 =
                 new PrintWriter(jogador1.getSocket().getOutputStream(),true);
         
         PrintWriter envioPara2 =
                 new PrintWriter(jogador2.getSocket().getOutputStream(),true);
         
        
         envioPara1.println("1");
         envioPara2.println("2");
            
         while(true){
            
           if(vezJogador1){
             
               String jogada1 = entradaJogador1.readLine();
               
               if(jogada1.equals("sair")){
                   envioPara2.println("venceu");
               }
               else{
               
                   envioPara2.println(jogada1);
               }
               
           }else{
               
               String jogada2 = entradaJogador2.readLine();
               
               if(jogada2.equals("sair")){
               
                   envioPara1.println("venceu");
               
               }else{
               
                   envioPara1.println(jogada2);
               }
           }  
            
           if(vezJogador1){
               
               vezJogador1 = false;
           }else{
               
               vezJogador1 = true;
           }
           
         }
        
        }catch(IOException ex){}
        
    }
    
    
}
