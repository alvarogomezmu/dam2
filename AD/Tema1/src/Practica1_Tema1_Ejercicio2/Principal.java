/**
 * Crear un fichero llamado FichinfoPeliculas.txt con los datos introducidos por
 * teclado de Película (Titulo (String), Precio (Double)). Debemos introducir
 * una cantidad de 5 películas para el ejemplo. Una vez tenemos esos datos
 * guardados en nuestro fichero deberemos mostrar:
 *
 * a) Mostrar los datos de la última película introducido
 *
 * b) Mostrar los datos de una posición que un usuario pida por teclado.
 *
 * c) Mostrar los datos de todas las películas que disponemos
 *
 */
package Practica1_Tema1_Ejercicio2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // metodo para leer por teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        // Declaramos el numero de peliculas
        int numeroPeliculas = 5;

        // Numero para asignar el maximo de largo para convertir a UTF
        int maximo = 20;

        // Variable para declarar la opcion introducida por teclado por el usuario
        String opcion;

        // Direccion donde se creara y se leera el fichero
        String ruta = "FichinfoPeliculas.dat";

        // creamos las peliculas
        Metodos.crearPeliculas(teclado, ruta, numeroPeliculas, maximo);

        // mostramos la lista
        Metodos.mostrarMenu();

        // pedimos al usuario que escoja una opcion
        opcion = Metodos.pedirOpcion(teclado);

        // Switch para filtrar el resultado
        while (!opcion.equals("F")) {
            switch (opcion) {
                case "A":
                    Metodos.mostrarUltimaPelicula(ruta, numeroPeliculas);
                    
                    break;
                case "B":
                    int posicion;
                    do {
                        System.out.println("Introduzca una posicion del 1 al "+Integer.toString(numeroPeliculas) +" para mostrar los datos de la pelicula correspondiente: ");
                        Scanner sc = new Scanner(System.in);
                        posicion = sc.nextInt();
                    } while (posicion < 1 || posicion > numeroPeliculas-1);

                    Metodos.mostrarPeliculaPedida(ruta, numeroPeliculas, posicion);
                    break;
                case "C":
                    Metodos.mostrarTodas(ruta, numeroPeliculas);
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
