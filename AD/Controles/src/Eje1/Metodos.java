/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eje1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void mostrarMenu(int opc) {
        System.out.println("Elige una opcion:\n"
                + "a) Mostrar todos los datos introducidos (0,5puntos).\n"
                + "b) Modificar el valor de la posición 2 cambiando nombre por ******. Mostrar el cambio realizado. (2 puntos).\n"
                + "c) c. Mostrar el primero y el tercero dato introducido. (1 punto).\n"
                + "d) Salir.");
    }
    
    public static String pedirOpcion(BufferedReader teclado) throws IOException {
        System.out.println("Tu opcion: ");
        return teclado.readLine().toUpperCase();
    }
}
