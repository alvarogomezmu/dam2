package Practica1Tema0;

import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    // metodo para calcular el libro con menor precio
    public static void precioMenor(ArrayList<Equipo> equi) {
        int menorEqui = 0;
        double precioMenorEqui = 2000;

        for (int i = 0; i < equi.size(); i++) {
            if (equi.get(i).getPrecio() < precioMenorEqui) {
                precioMenorEqui = equi.get(i).getPrecio();
                menorEqui = equi.indexOf(equi.get(i));

            }

        }
        System.out.println("Equipo con menor precio: " + equi.get(menorEqui).getNombre() + " " + equi.get(menorEqui).getPrecio() + "€");
    }

    // metodo para calcular el libro con mayor precio
    public static void precioMayor(ArrayList<Equipo> equi) {
        int mayorEqui = 0;
        double precioMayorEqui = 0;

        for (int i = 0; i < equi.size(); i++) {
            if (equi.get(i).getPrecio() > precioMayorEqui) {
                precioMayorEqui = equi.get(i).getPrecio();
                mayorEqui = equi.indexOf(equi.get(i));
            }

        }
        System.out.println("Equipo con mayor precio: " + equi.get(mayorEqui).getNombre() + " " + equi.get(mayorEqui).getPrecio() + "€");
    }

    // crear metodo que imprima los titulos de los libros
    public static void recorrerColeccion(SortedSet<Libro> libros) {
        Iterator it = libros.iterator();
        while (it.hasNext()) {
            Libro x = (Libro) it.next();
            System.out.println(x.getTitulo());

        }
    }
}
