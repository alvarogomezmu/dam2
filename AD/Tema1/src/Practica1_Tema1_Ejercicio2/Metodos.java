/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1_Tema1_Ejercicio2;

import Herramientas.Herramientas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    /**
     * Determinar el tamaño de una cadena dentro de un fichero aleatorio
     *
     * @param txt Cualquier string
     * @param largo Integer asociado al string
     * @return Cadena generada
     */
    public static String convertUTF(String txt, int largo) {
        // Si la longitud del String es mayor que el integer asociado
        // Devuelve un substring del String dado
        if (txt.length() > largo) {
            return txt.substring(0, largo);
        }
        // Si el String es menor, añadirle espacios en blanco
        for (int n = txt.length(); n < largo; n++) {
            txt = txt + " ";
        }
        return txt;
    }

    /**
     * Metodo para crear peliculas
     *
     * @param teclado
     * @param ruta
     * @param numeroPeliculas
     * @param maximo
     * @throws IOException
     */
    public static void crearPeliculas(BufferedReader teclado, String ruta, int numeroPeliculas, int maximo) throws IOException {
        // Varaible para escribir en el fichero

        RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
        // Pedimos los datos y los introducimos en el fichero
        for (int i = 0; i < numeroPeliculas; i++) {
            System.out.println(i);
            System.out.println("Introduce el titulo: ");
            raf.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), maximo));
            System.out.println("Introduce el precio: ");
            raf.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), maximo));

        }
        // cerramos el fichero
        raf.close();
    }

    /**
     * Metodo para mostrar la ultima pelicula introducida
     *
     * @param ruta
     * @throws IOException
     */
    public static void mostrarUltimaPelicula(String ruta) throws IOException {
        // Variable para leer el fichero
        RandomAccessFile raf = new RandomAccessFile(ruta, "rw");

        // Ponemos el puntero en la ultima posicion
        raf.seek(22 * 4);

        // mostramos los datos
        System.out.println("La ultima pelicula introducida es: Titulo:" + raf.readUTF() + " Precio: " + raf.readDouble());

        // cerramos el fichero
        raf.close();
    }

    /**
     * Metodo para mostrar el menu
     */
    public static void mostrarMenu() {
        System.out.println("Elige una opcion:\n"
                + "a) Mostrar los datos de la última película introducido\n"
                + "b) Mostrar los datos de una posición que un usuario pida por teclado.\n"
                + "c) Mostrar los datos de todas las películas que disponemos");
    }

    /**
     * Metodo para pedir al usuario que elija una opcion del menu
     *
     * @param teclado
     * @return
     * @throws IOException
     */
    public static String pedirOpcion(BufferedReader teclado) throws IOException {
        System.out.println("Tu opcion: ");
        return teclado.readLine();
    }
}
