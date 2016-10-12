/**
 * Crear una clase contacto con dni, nombre, apellido y edad. Vamos a guardar 4
 * contactos en una estructura que admita repetidos. Dicha estructura será
 * serializada en un fichero. Una vez serializado leer contenido del fichero
 * para mostrarlo por pantalla.
 */
package ficheroSerializableEjercicio3;

import java.nio.file.Path;
import java.nio.file.Paths;
import Herramientas.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.HashMap;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Cogemos la ruta donde se almacena el fichero
        Path path = Paths.get("contactos.obj");

        // Si existe, se muestra, sino, lo creamos
        if (Files.exists(path)) {
            try {
                // Cogemos la ruta
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactos.obj"));
                // La leemos
                Herramientas.leerMap(ois);
            } catch (ClassNotFoundException c) {
                System.out.println("Error tipo ClassNotFoundException: " + c);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        } else {
            // Creamos 3 personas
            Contacto con1 = new Contacto();
            Contacto con2 = new Contacto();
            Contacto con3 = new Contacto();

            try {
                // Llamamos al metodo para crear los datos de las personas
                Metodos.setContactoDatos(con1);
                Metodos.setContactoDatos(con2);
                Metodos.setContactoDatos(con3);

                // Creamos un HashMap
                HashMap map = new HashMap();

                // Metemos las personas en el HashMap, conel DNI por clave
                map.put(con1.getDni(), con1);
                map.put(con2.getDni(), con2);
                map.put(con3.getDni(), con3);

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.obj"));

                Herramientas.escribirMap(oos, map);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        }
    }
}
