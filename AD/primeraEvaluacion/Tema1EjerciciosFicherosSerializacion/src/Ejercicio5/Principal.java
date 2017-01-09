/**
 * Escribe un programa en java que realice  el siguiente menú en pantalla:
 * Menú principal
 * 1.- Escribir el archivo de datos
 * 2.- Leer y procesar los datos
 * 3.- Terminar
 *
 * La opcion 1 debe pedir la siguiente información por el teclado
 * de n alumnos, nombre, sexo, edad, estatura y peso y escribirla en el archivo.
 *
 * La opcion 2 debe abrir el archivo para leer los datos y
 * calcular el promedio de edad de las personas cuyo sexo  sea masculino asi como imprimir el total de las personas
 * (hombres y mujeres) que miden mas de 1.65 metros.
 *
 * Nota: Se debe de usar un método para mostrar el menú,
 * un método para la opción 1 y un método para la opción 2.
 * Así como otros métodos que sean necesarios e instancia las clases para ejecutar estos métodos.
 *
 */
package Ejercicio5;

import java.util.*;
import java.io.*;
import Herramientas.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion != 3) {
                Metodos.mostrarMenu();

                System.out.println("Introduzca una opcion válida del menu \n");
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("26_serialize_menu.bat"));
                        Metodos.escribir(escribir);
                        break;
                    case 2:
                        ObjectInputStream leer = new ObjectInputStream(new FileInputStream("26_serialize_menu.bat"));
                        Herramientas.leerObjetos(leer);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Numero erroneo.");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
