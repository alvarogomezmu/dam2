/**
 * Define una clase Persona que almacene: nombre, apellidos, DNI, y edad.
 *
 * Realiza un programa que pueda leer los datos relativos a personas desde la entrada estándar System.in
 *
 * Cada persona que se lea, se debe almacenar en un HashMap, donde la llave será el DNI.
 *
 * Permite que el programa serialice en un fichero ese HashMap y termine.
 *
 * Cuando el programa vuelva a arrancar debe poder recuperar los datos introducidos previamente
 * (recuperando el objeto previamente serializado)
 *
 */
package Ejercicio1;

import Herramientas.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Cogemos la ruta donde se almacena el fichero
        Path path = Paths.get("personas.obj");

        // Si existe, se muestra, sino, lo creamos
        if (Files.exists(path)) {
            try {
                // Cogemos la ruta
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.obj"));
                // La leemos
                Herramientas.leerMap(ois);
            } catch (ClassNotFoundException c) {
                System.out.println("Error tipo ClassNotFoundException: " + c);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        } else {
            // Creamos 3 personas
            Persona per1 = new Persona();
            Persona per2 = new Persona();

            try {
                // Llamamos al metodo para crear los datos de las personas
                Metodos.setPersonaDatos(per1);
                Metodos.setPersonaDatos(per2);

                // Creamos un HashMap
                HashMap map = new HashMap();

                // Metemos las personas en el HashMap, conel DNI por clave
                map.put(per1.getDNI(), per1);
                map.put(per2.getDNI(), per2);

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personas.obj"));

                Herramientas.escribirMap(oos, map);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        }
    }
}
