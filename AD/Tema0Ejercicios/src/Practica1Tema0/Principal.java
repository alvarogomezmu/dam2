/**
 * Crear dos colecciones (debes usar las dos que hemos visto en clase) distintas
 * para poder guardar equipos informáticos (objetos formados por los atributos
 * nombre, cantidad, precio) Cuando la tengas muestra los datos (2,5) En la otra
 * de manera ordenada vamos aguardar libros (isbn. titulo). No debe admitir
 * repetidos. Cuando lo tengas muestras todos los datos guardados (2,5) Una vez
 * hayamos guardado los objetos en cada estructura pertinente. Debemos mostrar
 * el equipo informático con mayor precio y el de menor precio. (2,5) Y mostrar
 * los títulos de los libros que se hayan guardado. (2,5)
 *
 * LA CREACIÓN DE LOS DOS OBJETOS SE DA POR ENTENDIDO Y NO PUNTUA
 *
 * Los métodos específicos debemos crear una clase métodos donde almacenarlos
 *
 * Hay que crear un mínimo de 4 objetos de cada clase.
 *
 */
package Practica1Tema0;

import java.util.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         EQUIPOS INFORMATICOS
         */
        // 1. Creamos 5 equipos (nombre, cantidad, precio)

        Equipo equipo1 = new Equipo("hp", 20, 600);

        Equipo equipo2 = new Equipo("fujitsu", 15, 400);

        Equipo equipo3 = new Equipo("dell", 7, 800);

        Equipo equipo4 = new Equipo("samsung", 30, 150);

        Equipo equipo5 = new Equipo("toshiba", 22, 300);

        // 2. Añadir los 5 objetos a un ArrayList equi (parametrizada)
        ArrayList<Equipo> equi = new ArrayList<>();
        equi.add(equipo1);
        equi.add(equipo2);
        equi.add(equipo3);
        equi.add(equipo4);
        equi.add(equipo5);

        // 3. Ver que se han guardado (recorrerColeccion)
        System.out.println("Imprimimos los 5 equipos para ver que se han guardado correctamente: ");
        Herramientas.recorrerColeccion(equi);
        
        System.out.println("\nLlamamos a los metodos de precioMayor y precioMenor para imprimirlos: ");
        Metodos.precioMayor(equi);
        Metodos.precioMenor(equi);
        

        /*
         LIBROS
         */
        // 1. Creamos 5 libros (isbn (integer), titulo)
        SortedSet<Libro> libros = new TreeSet<Libro>();

        //HashSet<Object> libros = new HashSet<>();        
        /*
         libros.add(new Libro(32, "Casa"));
         libros.add(new Libro(102, "Rojo"));
         libros.add(new Libro(222, "Violeta"));
         libros.add(new Libro(101, "Negro"));
         libros.add(new Libro(234, "Gris"));
         */
        Libro lib = new Libro(32, "Casa");
        libros.add(lib);

        lib = new Libro(2, "Rojo");
        libros.add(lib);

        lib = new Libro(222, "Violeta");
        libros.add(lib);

        lib = new Libro(5, "Gomorra");
        libros.add(lib);

        lib = new Libro(100, "Gomorra");
        libros.add(lib);
        
        
        
        System.out.println("\nImprimimos los 5 libros de manera ordenada: ");
        Herramientas.recorrerColeccion(libros);
        
        System.out.println("\nImprimimos el metodo para que nos muestre solo los titulos de los libros: ");
        Metodos.recorrerColeccion(libros);
        
        

    }

}
