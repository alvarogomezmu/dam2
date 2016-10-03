/**
 * crear una clase Alumno (nombre, codigo, nota).
 * Serializamos 5 alumnos en un fichero.dat y los deserializarlos.
 */
package ficheroSerializableEjercicio;

import java.io.*;
import java.util.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        // TODO code application logic here
        Alumno a1 = new Alumno("Pepe", 111, 7);
        Alumno a2 = new Alumno("Dani", 222, 6);
        Alumno a3 = new Alumno("Sara", 333, 9);
        Alumno a4 = new Alumno("Elisa", 444, 8);
        Alumno a5 = new Alumno("Marcos", 555, 3);

        // Stream para escribir
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("fichero.dat"));
        Herramientas.escribirArchivo(escribir, a1);
        Herramientas.escribirArchivo(escribir, a2);
        Herramientas.escribirArchivo(escribir, a3);
        Herramientas.escribirArchivo(escribir, a5);
     
        
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("fichero.dat"));
        Herramientas.leerArchivo(leer);
        
    }
}
