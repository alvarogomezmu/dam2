/**
 * Realiza un programa que muestre un menú como el siguiente
 *
 * 1.Volcado de un arraylist con los 100 primeros números pares a un fichero de
 * texto. El nombre del fichero lo elegirá el usuario ( lo deberá escribir él)
 *
 * 2.Mostrar por pantalla el número que se encuentra en la posición 3 del
 * fichero.
 *
 * 3. Salir del Programa.
 *
 */
package Ejercicio4;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos.escribirMenu();

        // Declaramos la variable donde se almacenara la opcion introducida por el usuario
        int opcion = 0;

        // Declaramos la variable donde se guardara el nombre del fichero
        String fichero = "";

        // Preguntamos la opcion
        try {
            opcion = Metodos.preguntarOpcion();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        while (opcion != 3) {
            switch (opcion) {
                case 1:
                    // Preguntar al usuarioe el nombre del archivo donde se guardara
                    try {
                        fichero = Metodos.nombreFichero();
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }

                    ArrayList<Integer> ar;
                    ar = new ArrayList<Integer>();

                    try {
                        Metodos.escribirArrayPares(ar, fichero);
                        System.out.println("Se ha creado el array de los 100 primeros numeros pares.\n");
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }

                    break;
                case 2:
                    try {
                        // Mostramos el contenido de la tercera linea del fichero
                        Metodos.mostrarTerceraPosicion(fichero);
                    } catch (IOException e) {
                        System.out.println("Error: " + e);
                    }

                    break;
            }
            // Volvemos a mostar el menu
            Metodos.escribirMenu();

            // Preguntamos la opcion
            try {
                opcion = Metodos.preguntarOpcion();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }

}
