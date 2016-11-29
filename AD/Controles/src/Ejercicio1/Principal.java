/*
 Crear un fichero POR TECLADO pidiendo: Código, nombre y precio nos tiene que
 pedir 5 veces la información a guardar (0,25 puntos). El fichero se llamara
 productos.txt .Una vez lo tengamos creado tenemos que mostrar un menú como
 el que se muestra y que debe repetirse hasta que no se le dé a la opción de salir. (0,25)

 a. Mostrar todos los datos introducidos (0,5puntos)
 b. Modificar el valor de la posición 2 cambiando nombre por

 ******. Mostrar el cambio realizado. (2 puntos)
 c. Mostrar el primero y el tercero dato introducido. (1 punto)
 d. Salir

 */
package Ejercicio1;

import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

// metodo para leer por teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        //declaramos el numero de productos
        int numeroProductos = 1;

        // numero para asignar valor maximo al convertir a UTF
        int maximo = 20;

        // variable para introducir la opcion introducida por el usuario
        String opcion;

        // Direccion donde se creara y se leera el fichero
        String ruta = "productos.dat";

        // creamos los productos
        Metodos.crearProductos(teclado, ruta, numeroProductos, maximo);

        // mostramos el menu con las opciones
        Metodos.mostrarMenu();

        // pedimos al usuario que escoja una opcion
        opcion = Metodos.pedirOpcion(teclado);
        // Switch para filtrar el resultado
        while (!opcion.equals("F")) {
            switch (opcion) {
                case "A":
                    Metodos.mostrarTodos(ruta, numeroProductos);
                    break;
                case "B":
                    int posicion;
                    do {
                        System.out.println("Introduzca una posicion del 1 al " + Integer.toString(numeroProductos) + " para mostrar los datos de la pelicula correspondiente: ");
                        Scanner sc = new Scanner(System.in);
                        posicion = sc.nextInt();
                    } while (posicion < 1 || posicion > numeroProductos - 1);

                    Metodos.mostrarProductoPedido(ruta, numeroProductos, posicion);
                    break;
                case "C":
                    Metodos.mostrarTodos(ruta, numeroProductos);
                    break;

                default:
                    System.out.println("\nOpcion no valida, vuelva a intentarlo\n");
                    break;
            }

            // Mostramos la lista
            Metodos.mostrarMenu();
            // Pedimos al usuario que escoja una opcion
            opcion = Metodos.pedirOpcion(teclado);
        }
    }
}
