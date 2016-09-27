/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploFicheroToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Método para leer token
        Integer linea;
        BufferedReader leer = new BufferedReader(new FileReader("ficherito.txt"));
while (linea=leer.readLine())!=null)){
        StringTokenizer st = new StringTokenizer(linea, "#");
        while(st.hasMoreTokens()){
            String c = st.nextToken();
            String p = st.nextToken();
            System.out.println(c+p);
        }
                     }
    }
}