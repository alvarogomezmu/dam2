/**
 * Ejemplo 1: Vamos a leer por teclado 3 nombres que pedimos previamente.
 */
package Ejemplo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import Herramientas.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile fsalida = new RandomAccessFile("ruta", "rw");
        for (int n = 0; n < 4; n++) {
            System.out.println("Escribe un nombre: ");
            fsalida.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), 20));
        }
        fsalida.close();
        teclado.close();
        RandomAccessFile fentrada = new RandomAccessFile("ruta", "r");
        System.out.println("\nLos nombres que ha introducido son:");

        for (int i = 0; i < 4; i++) {
            // Siempre hay que aniadir +2bytes de cabecera
            fentrada.seek(i * 22);
            String nombre = fentrada.readUTF();
            System.out.println(nombre);
        }

        fentrada.close();
    }

}
