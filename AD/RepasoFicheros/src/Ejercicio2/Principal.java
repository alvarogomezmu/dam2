/**
 * Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora crea
 * una aplicación que lea este fichero de texto carácter a carácter y muestre su
 * contenido por pantalla sin espacios. Por ejemplo, si un fichero tiene el
 * siguiente texto “Esto es una prueba”, deberá mostrar “Estoesunaprueba”.
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader leer = new BufferedReader(new FileReader("fichero.txt"));
            StringTokenizer st;
            String linea = leer.readLine();
            while (linea != null) {
                st = new StringTokenizer(linea, " ");
                while (st.hasMoreTokens()) {
                    System.out.print(st.nextToken());
                }
                linea = leer.readLine();
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
