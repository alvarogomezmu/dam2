package Ejercicio1;

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
    public static void main(String[] args) {
        // Crear un ArrayList ciudades con Madrid BCN Malaga Sevilla
        ArrayList<String> ciudades = new ArrayList<String>();
        ciudades.add("Madrid");
        ciudades.add("BCN");
        ciudades.add("Malaga");
        ciudades.add("Vigo");
        ciudades.add("Sevilla");

        // Mostrar posiciones 0 y 2
        System.out.println(ciudades.get(0));
        System.out.println(ciudades.get(2));

        System.out.println("");

        // Recorrer e imprimir la coleccion
            Herramientas.recorrerColeccion(ciudades);

    }
}
