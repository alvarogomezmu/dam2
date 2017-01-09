package EjemploFichero;

import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    public static void main(String[] args) {
        try {
            // Abrimos flujo de comunicacion entre java y el fichero
            BufferedReader teclado = new BufferedReader(new FileReader("C:\\Users\\AlumnoT\\Documents\\NetBeansProjects\\AD\\src\\EjemploFichero\\a.txt"));
            String linea;
            while(teclado.ready()){
                linea = teclado.readLine();
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
