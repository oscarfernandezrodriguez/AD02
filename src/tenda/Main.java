/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenda;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koke
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader fichero = null;
        Gson gson = new Gson();
        Franquicia f=null;
        try {
            // TODO code application logic here
            f = gson.fromJson(new FileReader("franquicia.json"), Franquicia.class);
                    } catch (IOException e) {
             
        } 
        if(f==null) {
       	 f=new Franquicia();
        }
            menu menu=new menu();
            menu.mostrar();
            int dato=menu.pedirDatos();
            menu.procesarAccion(dato, f);
    }
    public static void pausa(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
        }
    }
    
}
