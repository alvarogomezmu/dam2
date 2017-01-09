/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorios;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author Alvaro
 */
public class fich {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile asig = new RandomAccessFile("a2.txt", "rw");

            for (int n = 0; n < 5; n++) {
                System.out.println("Escribe un codigo: ");
                asig.writeInt(Integer.parseInt(teclado.readLine()));
                System.out.println("Escribe el nombre: ");
                asig.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), 20));
                System.out.println("Escribe un sueldo: ");
                asig.writeInt(Integer.parseInt(teclado.readLine()));
            }
            asig.close();
            teclado.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}