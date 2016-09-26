/**
 * Ejercicio3. Crear un fichero aleatorio pidiendo POR TECLADO Codigo, nombre, sueldo de los empleados en total nos tiene que pedir 5.
 * El fichero aleatorio se llamará empleado.txt .Una vez lo tengamos creado tenemos que mostrar:
 *      todos los datos introducidos
 *      El último dato introducido.
 *      El primero y el tercero dato que hayáis escrito
 */
package Ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile fsalida = new RandomAccessFile("ejercicio6", "rw");
        for (int i=0; i<6; i++){
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
}
