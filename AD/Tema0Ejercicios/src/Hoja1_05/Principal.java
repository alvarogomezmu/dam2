/**
 * Creamos una clase animal con el dato Nombre de dichos animales. Debemos crear
 * 3 objetos animal, teniendo en cuenta que nos dicen que no debemos aceptar
 * animales repetidos. Indica que tipo de Collections usarás y realiza el
 * ejemplo.
 */
package Hoja1_05;

import java.util.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    public static void main(String[] args) {

        // Creamos un HashSet, ya que no permite duplicados
        ArrayList animales = new ArrayList();

        animales.add("Vaca");
        animales.add("Perro");
        animales.add("Perro");

        System.out.println("Mostramos los animales guardados en el ArrayList:");
        Herramientas.recorrerColeccion(animales);

        // Convertimos el ArrayList a HashSet
        HashSet<String> hashSet = new HashSet<>(animales);
        // borra todos los elementos de la lista
        //animales.clear();

        // aniade los aninames a la lista excluyendo repetidos
        //animales.addAll(hashSet);

        System.out.println("\nMostramos los animales excluyendo repetidos:");
        Herramientas.recorrerColeccion(hashSet);
    }
}
