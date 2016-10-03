/**
 * Ejercicio6. Leer  el contenido de un fichero de texto info.txt, guardar sus
 * datos en un arraylist llamada contenido. Borrar uno de los  elemento del
 * arraylist  una vez hecha dicha acción, sobreescribir el fichero info.txt con
 * los nuevos datos del arraylist contenido. Repetir dicho ejercicio ,sabiendo
 * que debemos usar una colección que no acepte repetidos.
 */
package Ejercicio6;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import Herramientas.*;

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
            ArrayList nombres = new ArrayList();
            RandomAccessFile fich = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\info.txt", "rw");
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < 4; i++) {
                System.out.println("Nombre: ");
                fich.writeUTF(Herramientas.ConvertUTF(sc.readLine(), 20));
            }
            fich.close();

            fich = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\info.txt", "r");
            //Se introducen los datos en el arraylist
            System.out.println("SIN MODIFICAR");

            for (int i = 0; i < 4; i++) {
                fich.seek(i * 22);
                System.out.println(fich.readUTF());
                nombres.add(fich.readUTF());

            }

            fich.close();

            //SE borra un elemento
            nombres.remove(2);

            fich = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\info.txt", "rw");
            //Se sobreescribe el fichero
            Iterator it = nombres.iterator();
            while (it.hasNext()) {
                fich.writeUTF(Herramientas.ConvertUTF((String) it.next(), 20));
            }
            fich.close();

            fich = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\info.txt", "r");
            System.out.println("MODIFICADO");

            for (int i = 0; i < nombres.size(); i++) {
                fich.seek(i * 22);
                System.out.println(fich.readUTF());
            }

            fich.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }

}
