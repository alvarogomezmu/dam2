/**
 * En esta segunda práctica se os pide que hagáis un menú con varias opciones,
 * para poder trabajar con los distintos ficheros que hemos visto. Crear un
 * fichero llamado FichInfoCurso.txt en dicho fichero debemos guardar los datos
 * que previamente habremos pedido por teclado y que habremos guardado en un
 * Hashmap.
 *
 * Los datos son CodigoCurso, Curso <nombre, duracion>
 *
 * Para poder hacer el menú, las acciones irán en métodos y siempre haremos las
 * operaciones sobre el fichero. NUNCA sobre el hashmap
 *
 * a) Nos muestre Todos los Cursos y su duración que hemos almacenado en nuestro
 * fichero FichInfoCurso.txt
 *
 * b) Nos haga la media de la duracion.
 *
 * c) Nos diga que Curso tienen una duración más larga.
 *
 */
package Practica1_Tema1_Ejercicio1;

import Herramientas.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // metodo para leer por teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        String nombreFichero = "FichInfoCurso.txt";
        // Declaramos el numero total de cursos que vamos a crear
        int numeroCursos = 4;

        // Variable para declarar la opcion introducida por teclado por el usuario
        int opc;
        
        Map<String, Curso> cursos = new HashMap();

        // creamos los cursos
        Metodos.crearCursos((HashMap<String, Curso>) cursos, numeroCursos, nombreFichero);
        
        do {
            Metodos.mostrarMenu();
            
            System.out.println("Opcion: ");
            opc = Integer.parseInt(teclado.readLine());
            switch (opc) {
                case 1:
                    ObjectInputStream cursosOS = new ObjectInputStream(new FileInputStream(nombreFichero));
                    Herramientas.leerObjetos(cursosOS);
                    break;
                
                case 2:
                    ObjectInputStream cursosOS2 = new ObjectInputStream(new FileInputStream(nombreFichero));
                    Metodos.mediaDuracionCursos(cursosOS2);
                    
                    break;
                
                case 3:
                    ObjectInputStream cursosOS3 = new ObjectInputStream(new FileInputStream(nombreFichero));
                    Metodos.mayorDuracion(cursosOS3);
                    break;
                case 4:
                    System.out.println("Salir.");
                    break;
            }
        } while (opc != 4);
    }
}
