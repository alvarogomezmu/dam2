/**
 * Crear un método llamado buscarDuplicados en cualquier coleccion. Nos debe
 * decir si el objeto pasado por parámetro se encuentra o no en dicha coleccion.
 * Si es que sí mensaje de Duplicados y mostrar la lista que hay guardada. Si no
 * está que lo añada a la lista y la muestre.
 *
 */
package Hoja1_02;

import java.util.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 *
 */
public class Principal {

    public static void buscarDuplicados(ArrayList ar) {
        // Declaramos un Scanner
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario que introduzca un string mediante el Scanner
        String posible = sc.next();

        // Si el String introducido existe, mostramos que ya está y sino lo aniadimos
        if (ar.contains(sc) == true) {
            System.out.println("Ya existe");
            Herramientas.recorrerColeccion(ar);
        } else {
            ar.add(sc);
        }

        // imprimimos la lista
        // Mostramos la lista
        Iterator it = ar.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * Clase principal Crearemos una lista Aniadiremos varios datos a dicha
     * lista
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creamos la lista
        ArrayList<Persona> lista = new ArrayList();

        Persona per1 = new Persona("rut1", "persona1");
        Persona per2 = new Persona("rut2", "persona2");
        Persona per3 = new Persona("rut3", "persona3");

// Aniadimos datos a la lista
        lista.add(per1);
        lista.add(per2);
        lista.add(per3);

        // llamamos al metodo para comprobar
        buscarDuplicados(lista);
    }

}
