/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control1;

import java.io.*;
import java.util.*;
import control1.*;
import Herramientas.*;

public class Control1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*  RandomAccessFile NOMBRE = new RandomAccessFile("ruta.txt", "rw");*/
        int opc = 0;

        Metodos.introDatos();

        do {
            Metodos.menu(opc);
            System.out.println("Intro Opcion");
            opc = Integer.parseInt(br.readLine());

            switch (opc) {
                case 1:/* Mostrar todos  los datos introducidos */
                    System.out.println("L1os datos introducidos");
                    Herramientas.LeerFichero("ruta.txt");

                    break;
                case 2:/* Modificar el valor de la posición 2 104 */
                    RandomAccessFile fichero = new RandomAccessFile("ruta.txt", "rw");
                    RandomAccessFile fichero1 = new RandomAccessFile("ruta.txt", "r");

                    fichero.seek(156);
                    fichero.writeUTF("*****");
                    fichero.close();

                    fichero1.seek(156);
                    String h = fichero1.readUTF();
                    System.out.println(h);
                    fichero1.close();

                    break;
                case 3:/* Mostrar el primero y el tercero dato introducido */
                    RandomAccessFile fichero2 = new RandomAccessFile("ruta.txt", "r");

                    fichero2.seek(0 * 52);
                    String h1 = fichero2.readUTF();
                    String h2 = fichero2.readUTF();
                    double h3 = fichero2.readDouble();
                    System.out.println(h1);
                    System.out.println(h2);
                    System.out.println(h3);

                    fichero2.seek(2 * 52);
                    String h4 = fichero2.readUTF();
                    String h5 = fichero2.readUTF();
                    double h6 = fichero2.readDouble();
                    System.out.println(h4);
                    System.out.println(h5);
                    System.out.println(h6);

                    fichero2.close();

                    break;
                case 4:/* Salir 1 */
                    System.out.println("Adios. Gracias por usar la Aplicacion");
                    break;

            }
        } while (opc != 4);

    }

}
