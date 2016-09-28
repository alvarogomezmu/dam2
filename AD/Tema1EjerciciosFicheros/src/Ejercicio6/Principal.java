/**
 * Ejercicio6. Leer  el contenido de un fichero de texto info.txt, guardar sus datos en un arraylist llamada contenido.
 * Borrar uno de los  elemento del arraylist  una vez hecha dicha acción, sobreescribir el fichero info.txt con
 *      los nuevos datos del arraylist contenido.
 * Repetir dicho ejercicio ,sabiendo que debemos usar una colección que no acepte repetidos.
 */
package Ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader fl = new BufferedReader(new FileReader("ejercicio6.txt"));

            while (fl.ready()) {
                System.out.println(fl.readLine());
            }
            fl.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

}
