/**
 * Vamos a crear un fichero en el que vamos a guardar nombre de asignaturas y notas, siendo la nota un numero entero.
 * Queremos que esa informacion se guarde en el fichero y se muestre.
 */
package Ejemplo2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import Herramientas.*;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        RandomAccessFile fsalida = new RandomAccessFile("ejemplo2", "rw");
        for (int n = 0; n < 1; n++) {
            System.out.println("Escribe el nombre de una asignatura: ");
            fsalida.writeUTF(Herramientas.ConvertUTF(teclado.readLine(), 20));
            fsalida.writeInt(Integer.BYTES);

        }
        fsalida.close();
        fsalida.close();
        teclado.close();
        teclado.close();
        
        RandomAccessFile fentrada = new RandomAccessFile("ejemplo2", "r");
        for (int i = 0; i < 1; i++) {
            // Siempre hay que aniadir +2bytes de cabecera
            fentrada.seek(i * 22);
            String nombre = fentrada.readUTF();
            Integer nota = fentrada.readInt();
            System.out.println("\nLa asignatura introducida es:" + nombre + nota);
        }
        fentrada.close();
    }
}
