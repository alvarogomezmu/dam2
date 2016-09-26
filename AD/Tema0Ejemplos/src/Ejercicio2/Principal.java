package Ejercicio2;

import Herramientas.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    static String nombreObjeto(Alumno al) {
        String nombre = al.getNombre();
        return nombre;
    }

    public static void main(String[] args) {

        // 1. Generar 3 alumnos con distintas notas (aprobado, suspendido, sobresaliente)
        Alumno alumno1 = new Alumno("Juan", 17, "Ingles", 8);
        Alumno alumno2 = new Alumno("Carlos", 20, "Biologia", 5);
        Alumno alumno3 = new Alumno("Ricardo", 19, "Matematicas", 2);

        // 2. Añadir los 3 objetos a un ArrayList listaALumno (parametrizada)
        ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();

        listaAlumno.add(alumno1);
        listaAlumno.add(alumno2);
        listaAlumno.add(alumno3);

        // 3. Ver que se han guardado (recorrerColeccion)
        System.out.println("Imprimimos los 3 alumnos para ver que se han guardado correctamente: ");
        Herramientas.recorrerColeccion(listaAlumno);

        // 4. Ver cuantos alumnos hay (hay 3)
        System.out.println("\nVer cuantos alumnos hay: ");
        System.out.println(listaAlumno.size());

        // 5. Ver el alumno de la segunda posición
        System.out.println("\nImprimimos el alumno de la segunda posicion: ");
        System.out.println(listaAlumno.get(1));

        // 6. Con el nombre de un alumno, ver si está en la lista
        System.out.println("\nCon el nombre de un alumno, ver si está en la lista: ");
        String nombreComprobar = "Miguel"; // Nombre a comprobar
        boolean esta = true; // booleano para salir del bucle

        Iterator it = listaAlumno.iterator();

        while (it.hasNext()
                && esta) {
            if (nombreComprobar.equals(nombreObjeto((Alumno) it.next()))) {
                esta = false;
                System.out.println("La persona " + nombreComprobar + " esta en la lista");
            }
        }

        if (esta) {
            System.out.println("La persona " + nombreComprobar + " NO esta en la lista");
        }

        // 7. Borrar el alumno de la posicion 1
        System.out.println("\nBorrar el alumno de la posicion 1: ");
        listaAlumno.remove(alumno1);

        // 8. Ver como queda listaAlumno
        System.out.println("\nVer como queda listaAlumno: ");
        Herramientas.recorrerColeccion(listaAlumno);
    }
}
