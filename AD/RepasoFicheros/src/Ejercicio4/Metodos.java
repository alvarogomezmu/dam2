/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import static java.awt.PageAttributes.MediaType.C;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void escribirMenu() {
        System.out.println("MENU\n"
                + "1. Volcado de un arraylist con los 100 primeros números pares a un fichero de texto.\n"
                + "2. Mostrar por pantalla el número que se encuentra en la posición 3 del fichero.\n"
                + "3. Salir del programa.\n"
                + "Tu opcion: ");
    }

    public static int preguntarOpcion() throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcion = Integer.parseInt(teclado.readLine());
        return opcion;

    }

    public static String nombreFichero() throws IOException {
        System.out.println("Escriba el nombre que desee asignar al fichero: ");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String fichero = teclado.readLine();
        return fichero;
    }

    public static void escribirArrayPares(ArrayList<Integer> ar, String fichero) throws IOException {
        for (int i = 0; i < 200; i = i + 2) {
            ar.add(i);
        }

        Iterator it = ar.iterator();

        RandomAccessFile salida;
        salida = new RandomAccessFile(".\\" + fichero + ".txt", "rw");
        
        //BufferedWriter escribir = new BufferedWriter(new FileWriter(".\\" + fichero + ".txt"));

        // recorremos la coleccion e imprimimos todos los valores
        while (it.hasNext()) {
            salida.writeInt((int) it.next());
        }
        salida.close();
    }

    public static void mostrarTerceraPosicion(String fichero) throws IOException, FileNotFoundException {
        RandomAccessFile entrada;
        entrada = new RandomAccessFile(".\\" + fichero + ".txt", "r");
        
        
        entrada.seek(4 * 2);
        int dato = entrada.readInt();
        System.out.println("La tercera posicion es: " + dato);

//        BufferedReader file = new BufferedReader(new FileReader(".\\" + fichero + ".txt"));
//        String linea;
//        int contador = 0;
//        
//
//        while ((linea = file.readLine()) != null) {
//            if (contador == 3) {
//                System.out.println("La tercera posicion es " + linea);
//                break;
//            } else {
//                contador++;
//            }
//        }
    }
}
