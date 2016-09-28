package EjemploFicheroToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        // Declaramos variable para luego almacenar las lineas leidas del fichero
        String linea;
        try {
            // Se almacenan las lineas mientras haya lineas
            while ((linea = BufferedReader.readLine()) != null) {
                // Declaracion de StringTokenizer para la linea almacenada
                // con el token !
                StringTokenizer tok = new StringTokenizer(linea, "!");
                // Mientras haya tokens, añadirlos al ArrayList<Integer>
                while (tok.hasMoreTokens()) {
                    ar.add(Integer.parseInt(tok.nextToken()));
                    ar.add(Integer.parseInt(tok.nextToken()));
                }
            }
            // Cerrar el fichero
            br.close();
            // SI ha habido un error, mostrarlo
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
