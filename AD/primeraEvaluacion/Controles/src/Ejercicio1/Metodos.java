package Ejercicio1;

import java.io.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int menu(int opc) {
        int num = opc;
        System.out.println("\n---Tienda---");
        System.out.println("1.-Mostrar todos  los datos introducidos");
        System.out.println("2.-.Modificar el valor de la posición 2");
        System.out.println("3.-.Mostrar el primero y el tercero dato introducido ");
        System.out.println("7.-Salir");

        return num;
    }

    public static void introDatos() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cod;
        String nom;
        double pre;
        //  public producto(String codigo, String nombre, double precio) {
        RandomAccessFile Fichero = new RandomAccessFile("ruta.txt", "rw");
//          ESCRIBIR
        for (int i = 0; i < 5; i++) {
            System.out.println("\n---Alta Datos---");
            System.out.println("1.- Intro Código");
            Fichero.writeUTF(Herramientas.ConvertUTF(br.readLine(), 20));
            System.out.println("2.-.Intro Nombre");
            Fichero.writeUTF(Herramientas.ConvertUTF(br.readLine(), 20));
            System.out.println("3.-.Intro Precio");
            Fichero.writeDouble(Double.parseDouble(br.readLine()));

        }
        Fichero.close();
    }
}
