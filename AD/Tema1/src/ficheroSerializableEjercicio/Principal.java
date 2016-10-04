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
        Persona p1 = new Persona("Pepe", 111, 7);
        Persona p2 = new Persona("Dani", 222, 6);
        Persona p3 = new Persona("Sara", 333, 9);
        Persona p4 = new Persona("Elisa", 444, 8);
        Persona p5 = new Persona("Marcos", 555, 3);

        // Stream para escribir
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("fichero.dat"));
        Herramientas.escribirArchivo(escribir, p1);
        Herramientas.escribirArchivo(escribir, p2);
        Herramientas.escribirArchivo(escribir, p3);
        Herramientas.escribirArchivo(escribir, p5);
     
        
        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("fichero.dat"));
        Herramientas.leerArchivo(leer);
        
    }
}
