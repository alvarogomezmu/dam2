/**
 * Defina e implemente un directorio de e.mails mediante un Map<K, V>. En el
 * mismo la entrada de Clientes con DNI string y el e-mail. Se buscará por el
 * dni y devolverá la entrada de e-amil correspondiente.
 *
 */
package Hoja2_01;

import java.util.*;
import java.io.*;
import Hoja2_01.Metodos;
import Herramientas.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alvaro
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Cogemos la ruta donde se almacena el fichero
        Path path = Paths.get("C:\\Users\\Alvaro\\Documents\\documentos interesantes\\personas.obj");

        // Si existe, se muestra, sino, lo creamos
        if (Files.exists(path)) {
            try {
                // Cogemos la ruta
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Alvaro\\Documents\\documentos interesantes\\personas.obj"));
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

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Alvaro\\Documents\\documentos interesantes\\personas.obj"));

                Herramientas.escribirMap(oos, map);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        }
    }
}