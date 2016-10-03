/**
 * Ejercicio3. Crear un fichero aleatorio pidiendo POR TECLADO Codigo, nombre,
 * sueldo de los empleados en total nos tiene que pedir 5. El fichero aleatorio
 * se llamará empleado.txt .Una vez lo tengamos creado tenemos que mostrar:
 * todos los datos introducidos El último dato introducido. El primero y el
 * tercero dato que hayáis escrito
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

        {
            try {
                RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\empleado.txt", "rw");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                for (int i = 0; i < 5; i++) {
                    System.out.println("Codigo: ");
                    raf.writeInt(Integer.parseInt(br.readLine()));
                    System.out.println("Nombre: ");
                    raf.writeUTF(Herramientas.ConvertUTF(br.readLine(), 20));
                    System.out.println("Sueldo: ");
                    raf.writeDouble(Double.parseDouble(br.readLine()));
                }
                raf.close();
            } catch (Exception ex) {
                System.err.println("Error");
            }

            try {
                RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\empleado.txt", "r");

                //lee todo el fichero
                for (int i = 0; i < 5; i++) {
                    raf.seek(i * 34);

                    int codigo = raf.readInt();
                    String nombre = raf.readUTF();
                    double sueldo = raf.readDouble();

                    System.out.println(codigo + " " + nombre + " " + sueldo);
                }

                System.out.println("\n====================================\n");

                // lectura  del ultimo, primer y tercer registro introducido
                // ultimo
                raf.seek(4 * 34);
                int codigo = raf.readInt();
                String nombre = raf.readUTF();
                double sueldo = raf.readDouble();

                System.out.println("Ultimo dato introducido: " + codigo + " " + nombre + " " + sueldo);

                // primero
                raf.seek(0 * 34);

                codigo = raf.readInt();
                nombre = raf.readUTF();
                sueldo = raf.readDouble();

                System.out.println("Primer dato introducido: " + codigo + " " + nombre + " " + sueldo);

                // tercero
                raf.seek(2 * 34);

                codigo = raf.readInt();
                nombre = raf.readUTF();
                sueldo = raf.readDouble();

                System.out.println("Tercer dato introducio: " + codigo + " " + nombre + " " + sueldo);

                raf.close();
            } catch (Exception ex) {
                System.err.println("Error");
            }
        }
    }
}
