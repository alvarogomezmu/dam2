/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio7;

import Herramientas.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void cargarPaises(ArrayList<String> listapaises) {

        //Guardamos los paises en el arrayList
        listapaises.add(Herramientas.ConvertUTF("Italia", 20));
        listapaises.add(Herramientas.ConvertUTF("Francia", 20));
        listapaises.add(Herramientas.ConvertUTF("Canada", 20));
        listapaises.add(Herramientas.ConvertUTF("Brasil", 20));

        System.out.println("Paises que hemos introducido en el ArrayList: ");
        Herramientas.recorrerColeccion(listapaises);

        System.out.println("\nNumero de paises introducidos: " + listapaises.size());
    }

    public static void crearFichero(ArrayList<String> listapaises) {
        //Cargamos los datos en el fichero partiendo del arrayList
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura
            RandomAccessFile RAF = new RandomAccessFile("paises.txt", "rw");

            for (int i = 0; i < listapaises.size(); i++) {

                RAF.writeUTF(listapaises.get(i));

            }

            //Cerramos el fichero
            RAF.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Apartado A: Mostrar los datos de la posición 0,1 y 3 del fichero (NUNCA
     * DEL ARRAY).
     */
    public static void apartadoA() {
        String linea;
        System.out.println("\nApartado A:");
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura en modo lectura
            RandomAccessFile x = new RandomAccessFile("paises.txt", "r");

            System.out.println("Mostramos todos los paises: ");

            //Mostramos todos
            for (int i = 0; i < 4; i++) {

                x.seek(i * 22);

                linea = x.readUTF();

                System.out.println(linea);

            }

            //Mostramos el primer elemento
            System.out.println("\n-Primer elemento:");
            x.seek(0);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Mostramos el segundo elemento
            System.out.println("\n-Segundo elemento:");
            x.seek(22);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Mostramos el tercer elemento
            System.out.println("\n-Tercer elemento:");
            x.seek((22 * 3) - 22);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Cerramos el fichero
            x.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     * Apartado B: Modificar el valor de la posición 2 cambiando el pais.(
     * Ayuda: para ello recordad que deberemos borrar el contenido y volverlo
     * abrir). Mostrar el cambio realizado.
     */
    public static void apartadoB() {
        String linea;
        System.out.println("\nApartado B:");
        //Cargamos los datos en el fichero partiendo del arrayList
        try {
            //Creamos el objeto del acceso aleatorio con el modo rw
            RandomAccessFile RAF = new RandomAccessFile("paises.txt", "rw");

            //Nos situamos en la posicion 2
            RAF.seek((2 * 22) - 22);

            //Modificamos el dato
            RAF.writeUTF("Africa");

            //Mostramos todos
            for (int i = 0; i < 4; i++) {

                RAF.seek(i * 22);

                linea = RAF.readUTF();

                System.out.println(linea);

            }

            //Cerramos el fichero
            RAF.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Apartado C: Finalmente borramos del arraylist listaPaises  los valores de
     * la posición 1 y 3.
     *
     * @param listapaises
     */
    public static void apartadoC(ArrayList<String> listapaises) {
        String linea;
        System.out.println("\nApartado C:");

        Metodos.mostrarTodos();

        //Borrar del arrayList la posicion 1 , 3
        listapaises.remove(0);
        listapaises.remove(2 - 1);

        System.out.println("\nMostramos el arrayList con el borrado");
        Herramientas.recorrerColeccion(listapaises);

    }

    private static void mostrarTodos() {
        String linea;
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura en modo lectura
            RandomAccessFile x = new RandomAccessFile("paises.txt", "r");

            //Mostramos todos
            for (int i = 0; i < 4; i++) {

                x.seek(i * 22);

                linea = x.readUTF();

                System.out.println(linea);

            }

            //Cerramos el fichero
            x.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
