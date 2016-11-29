/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eje1;

import Ejercicio1.Metodos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import Herramientas.*;
import java.io.IOException;

/**
 *
 * @author AlumnoT
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int opc = 0;
        
        Metodos.mostrarMenu();
//        // Crear fichero aleatorio al que pasaremos nombres
//        try {
//            RandomAccessFile RAF = new RandomAccessFile("producto.txt", "rw");
//
//            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
//
//            for (int i = 0; i < 2; i++) {
//                System.out.println("Nombre");
//                RAF.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), 20));
//                
//                System.out.println("Codigo");
//                RAF.writeInt(Integer.parseInt(teclado.readLine(), 20));
//            }
//            RAF.close();
//        } catch (IOException ex) {
//            System.out.println("hola");
//        }
//
//        // Leer
//        try {
//            RandomAccessFile x = new RandomAccessFile("producto.txt", "r");
//            for (int i = 0; i < 2; i++) {
//                x.seek(i * 22);
//                String nombre = x.readUTF();
//                Integer codigo = x.readInt();
//                System.out.println(nombre);
//                System.out.println(codigo);
//            }
//            x.close();
//        } catch (IOException ex) {
//            System.out.println("que tal");
//        }
//    }
    }
}
