package EjemploHashSet2;

import Ejercicio2.Alumno;
import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    public static void main(String[] args) {

        HashSet<Producto> productos = new HashSet<Producto>();

        Producto producto1 = new Producto("Pan", 2);

        Producto producto2 = new Producto("Queso", 10);

        Producto producto3 = new Producto("Pan", 2);

        Producto producto4 = new Producto("Leche", 5);

        productos.add(producto1);

        productos.add(producto2);

        productos.add(producto3);

        productos.add(producto4);

        System.out.println(productos.size());
    }
}
