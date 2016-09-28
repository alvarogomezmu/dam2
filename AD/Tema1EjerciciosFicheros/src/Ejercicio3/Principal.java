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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        // TODO code application logic here
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile fsalida = new RandomAccessFile("empleado", "rw");
        for (int n = 0; n < 5; n++) {
            System.out.println("Escribe un nombre: ");
            fsalida.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), 20));
            
            System.out.println("Numerito");
            fsalida.writeInt(teclado.read());
        }
        fsalida.close();
        fsalida.close();
        
        teclado.close();
        teclado.close();
        RandomAccessFile fentrada = new RandomAccessFile("empleado", "r");
        System.out.println("\nLos nombres que ha introducido son:");

        for (int i = 0; i < 4; i++) {
            // Siempre hay que aniadir +2bytes de cabecera
            fentrada.seek(i * 22);
            String nombre = fentrada.readUTF();
            System.out.println(nombre);
            
            fentrada.seek(i * 22);
            Integer numero = fentrada.readInt();
            System.out.println(numero);
        }

        fentrada.close();
        fentrada.close();
    }
}
