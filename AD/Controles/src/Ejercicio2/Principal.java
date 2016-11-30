/**
 * Ejercicio 2. 6puntos
 *
 * Tenemos un fichero telefonoprofe.txt donde vamos a guardar Clases Profesores
 * (Nombre, edad, titulación, debe tener implementados los getter y setter) y que hemos
 * vinculado a cada profesor su número de teléfono que será único. Sabemos que el
 * Número de teléfono tiene que ser Entero.(0,5 puntos)
 * Lo primero que debemos hacer es generar dicho fichero, se pueden crear los
 * ejemplos de Profesor y teléfono directamente en el método pertinente.(0,5 puntos)
 * Una vez hecho éste primer paso, crear un pequeño menú donde podamos
 * seleccionar: (no es necesario la repetición):
 *
 * a) Debemos borrar un teléfono y por lo tanto el objeto asociado. Dicho teléfono se
 * pedirá por teclado y en cuanto coincida lo debe borrar. Una vez hecha dicha operación
 * nos debe mostrar cómo queda el fichero ( 2puntos)
 *
 * b) Debemos modificar el nombre de un profesor. Para ello se nos pedirá el teléfono del
 * profesor y una vez encontrado, debemos modificar su nombre con el que vosotros
 * hayáis fijado. Una vez hecha dicha operación nos debe mostrar cómo queda el
 * fichero. (3 puntos)
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    public static void main(String[] args) throws IOException {

        // Ruta del fichero
        String ruta = "telefonoprofe.txt";

        // Map que contendra los valores del fichero
        HashMap<String, Integer> mapProductos = new HashMap<String, Integer>();

        // Inicializamos el map
        Metodos.inicializarMap(mapProductos);

        try {
            // Escribimos el map en el fichero
            Metodos.escribirFichero(ruta, mapProductos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Variable para almacenar la opcion introducida por el usuario
        // Es de tipo String para evitar errores al introducir letras o numeros
        String opcion = "";

        while (!opcion.equals("3")) {
            // Mostramos el menu
            Metodos.mostrarMenu();
            try {
                // Pedimos al usuario que escoja una opcion del menu
                opcion = Metodos.pedirOpcion();
                // Salto de linea para separar resultados
                System.out.println("");
                // Tratamos la opcion
                Metodos.tratarOpciones(ruta, opcion, mapProductos);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}