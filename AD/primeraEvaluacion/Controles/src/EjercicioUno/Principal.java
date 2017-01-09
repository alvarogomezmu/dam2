package EjercicioUno;

import Ejercicio1.Producto;
import java.io.*;
import java.util.*;
import Herramientas.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import Herramientas.*;
import java.io.IOException;

/**
 *
 * @author Alvaro
 */
public class Principal {

    public static void main(String args[]) {
        // Escribimos el fichero
        try {
            RandomAccessFile escribir = new RandomAccessFile("prod.txt", "rw");

            escribir.writeInt(1);
            escribir.writeInt(5);
            escribir.writeDouble(900.2);

            escribir.writeInt(2);
            escribir.writeInt(23);
            escribir.writeDouble(1100.4);

            escribir.writeInt(3);
            escribir.writeInt(2);
            escribir.writeDouble(2000.5);

            escribir.writeInt(4);
            escribir.writeInt(49);
            escribir.writeDouble(1529.8);

            escribir.close();
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // Leemos el fichero
        try {
            RandomAccessFile leer = new RandomAccessFile("prod.txt", "rw");

            for (int i = 0; i < 4; i++) {
                leer.seek(i * 16);
                int int1 = leer.readInt();
                int int2 = leer.readInt();
                double double1 = leer.readDouble();
                System.out.println(int1 + " " + int2 + " " + double1);
            }

            leer.close();
        } catch (FileNotFoundException f) {
            System.out.println("Fichero no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
