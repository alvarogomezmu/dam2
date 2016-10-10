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
import java.io.InputStreamReader;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // metodo para leer por teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        // Declaramos el numero de peliculas
        int numeroPeliculas = 5;

        // Variable para declarar la opcion introducida por teclado por el usuario
        String opcion = null;
        
        // Direccion donde se creara y se leera el fichero
        String ruta = "FichinfoPeliculas.txt";
        
        
    }

}
