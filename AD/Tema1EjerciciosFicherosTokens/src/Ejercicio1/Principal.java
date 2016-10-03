/**
 * 1.	Pedir por teclado una cadena de texto, trocearla y finalmente guardarla en
 * un fichero con dicho formato.
 */
package Ejercicio1;

import java.io.*;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\Alvaro\\Documents\\numeros.txt"));

            System.out.println("Escribe una cadena de texto: ");

            StringTokenizer st = new StringTokenizer(teclado.readLine(), " ");

            while (st.hasMoreTokens()) {
                escribir.write(st.nextToken());
                escribir.newLine();
            }
            escribir.close();

            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alvaro\\Documents\\numeros.txt"));
            String linea;

            while ((linea = leer.readLine()) != null) {
                System.out.println("\nEl contenido que se ha guardado en el fichero es: "+linea);
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
