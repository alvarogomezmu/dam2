/**
 * Implementar una aplicación en Java que escriba una agenda telefónica con los  siguientes campos para cada individuo.
 * 1. nombre
 * 2. apellidos
 * 3. dirección
 * 4. población
 * 5. teléfono
 * 6. fecha de nacimiento
 *
 * La aplicación deberá tener dos partes:
 * Por una parte escribirá los datos  proporcionados por teclado y los guardará en el fichero.
 * Por otro lado permitirá la  consulta de todos los datos almacenados visualizándose un listado de ellos.
 *
 */
package Ejercicio3;

import Herramientas.*;
import java.io.*;

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

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Introduzca Nombre: ");
            String s_nombre = teclado.readLine();

            System.out.print("Introduzca Apellidos: ");
            String s_apellidos = teclado.readLine();

            System.out.print("Introduzca Direccion: ");
            String s_direccion = teclado.readLine();

            System.out.print("Introduzca Poblacion: ");
            String s_poblacion = teclado.readLine();

            System.out.print("Introduzca Fecha de Nacimiento: ");
            String s_fechanac = teclado.readLine();

            System.out.print("Introduzca Telefono: \n");
            int i_nombre = Integer.parseInt(teclado.readLine());

            Agenda persona1 = new Agenda(s_nombre, s_apellidos, s_direccion, s_poblacion, s_fechanac, i_nombre);

            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("serialej3.dat"));

            Herramientas.escribirObjetos(escribir, persona1);

            escribir.close();

            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("serialej3.dat"));

            System.out.println("Mostramos la agenda: ");
            Herramientas.leerObjetos(leer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
