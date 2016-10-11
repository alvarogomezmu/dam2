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
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc = 0;
        String nombre = null;
        int duracion = 0;

        Map<String, Curso> curso = new HashMap();

        System.out.println("Creando curso...");
        System.out.println("Nombre del curso:");
        nombre = br.readLine();
        System.out.println("Duracion: ");
        duracion = Integer.parseInt(br.readLine());

        Curso cur1 = new Curso(nombre, duracion);
        curso.put("01", cur1);

        ObjectOutputStream scrb = new ObjectOutputStream(new FileOutputStream("FichInfoCurso.txt"));
        Herramientas.escribirMap(scrb, curso);

        do {
            System.out.println("Menu");
            System.out.println("1.-Numerar cursos");
            System.out.println("2.-Media");
            System.out.println("3.-Duracion");
            System.out.println("4.-Salir");
            System.out.println("Opcion: ");
            opc = Integer.parseInt(br.readLine());
            switch (opc) {
                case 1:
                    ObjectInputStream lec = new ObjectInputStream(new FileInputStream("FichInfoCurso.txt"));
                    Herramientas.leerMap(lec);
                    break;

                case 2:
                    System.out.println("sfgsdf");
                    break;

                case 3:
                    System.out.println("sdfdsf");
                    break;
                case 4:
                    System.out.println("Salir.");
                    break;
            }
        }while (opc != 4);
    }
}
            
        
    
