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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tata-_000
 */
public class Teste {
    public static void main(String[] args) {
        
       
        
        try {
        
            Socket s = new Socket("191.190.204.110",12345);
 
            PrintWriter escritor = new PrintWriter(s.getOutputStream());
            BufferedReader leitor = 
                   new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            
            while(true){
                
                String ler = leitor.readLine();
            }
                
        } catch (IOException ex) {
    
        }
        
    }
}
