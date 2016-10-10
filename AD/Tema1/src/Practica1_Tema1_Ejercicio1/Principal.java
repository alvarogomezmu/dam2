/**
 * En esta segunda práctica se os pide que hagáis un menú con varias opciones,
 * para poder trabajar con los distintos ficheros que hemos visto. Crear un
 * fichero llamado FichInfoCurso.txt en dicho fichero debemos guardar los datos
 * que previamente habremos pedido por teclado y que habremos guardado en un
 * Hasmap.
 *
 * Los datos son CodigoCurso, Curso <nombre, duracion>
 *
 * Para poder hacer el menú las acciones irán en métodos y siempre haremos las
 * operaciones sobre el fichero nunca sobre el hashmap
 *
 * a) Nos muestre Todos los Cursos y su duración que hemos almacenado en nuestro
 * fichero FichInfoCurso.txt 1.
 *
 * b) Nos haga la media de la duracion.
 *
 * c) Nos diga que Curso tienen una duración más larga.
 *
 */
package Practica1_Tema1_Ejercicio1;

import Herramientas.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alvaro
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
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FichInfoCurso.txt    "));
                // La leemos
                Herramientas.leerMap(ois);
            } catch (ClassNotFoundException c) {
                System.out.println("Error tipo ClassNotFoundException: " + c);
            } catch (IOException e) {
                System.out.println("Error tipo IOException: " + e);
            }
        } else {
            // Creamos 3 personas
//            Contacto con1 = new Contacto();
//            Contacto con2 = new Contacto();
//            Contacto con3 = new Contacto();
    }

}
}
