/**
 * Ejercicio 7 Crear un fichero  aleatorio llamado países.txt, cargando en él un
 * arrayList formado por 4 paises llamanda listaPaises. Una vez tengamos los
 * datos cargados en el fichero. Mostrar los datos de la posición 0,1 y 3 del
 * fichero (NUNCA DEL ARRAY). Modificar el valor de la posición 2 cambiando el
 * pais.( Ayuda: para ello recordad que deberemos borrar el contenido y volverlo
 * abrir) Mostrar el cambio realizado. Finalmente borramos del arraylist
 * listaPaises  los valores de la posición 1 y 3.
 */
package Ejercicio7;

import Herramientas.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaramos el arrayList
        ArrayList<String> listapaises = new ArrayList();

        //Declaramos la variable para guardar el flujo de entrada
        String linea;

        //Guardamos los paises en el arrayList
        listapaises.add(Herramientas.ConvertUTF("Espana", 20));
        listapaises.add(Herramientas.ConvertUTF("Francia", 20));
        listapaises.add(Herramientas.ConvertUTF("Canada", 20));
        listapaises.add(Herramientas.ConvertUTF("Brasil", 20));

        Herramientas.recorrerColeccion(listapaises);

        System.out.println(listapaises.size());

        //Cargamos los datos en el fichero partiendo del arrayList
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura
            RandomAccessFile RAF = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\paises1.txt", "rw");

            for (int i = 0; i < listapaises.size(); i++) {

                RAF.writeUTF(listapaises.get(i));

            }

            //Cerramos el fichero
            RAF.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

        //APARTADO A
        System.out.println("Apartado A:");
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura en modo lectura
            RandomAccessFile x = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\paises1.txt", "r");

            System.out.println("Mostramos todos los libros");

            //Mostramos todos
            for (int i = 0; i < 4; i++) {

                x.seek(i * 22);

                linea = x.readUTF();

                System.out.println(linea);

            }

            //Mostramos el primer elemento
            System.out.println("Primer elemento");
            x.seek(0);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Mostramos el segundo elemento
            System.out.println("Segundo elemento");
            x.seek(22);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Mostramos el tercer elemento
            System.out.println("tercer elemento");
            x.seek((22 * 3) - 22);

            //Leemos la linea
            linea = x.readUTF();

            System.out.println(linea);

            //Cerramos el fichero
            x.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

        //APARTADO B
        System.out.println("\nApartado B:");
        //Cargamos los datos en el fichero partiendo del arrayList
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura
            RandomAccessFile RAF = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\paises1.txt", "rw");

            //Nos situamos en la posicion 2
            RAF.seek((2 * 22) - 22);

            //Modificamos el dato
            RAF.writeUTF("Africa");

            //Cerramos el fichero
            RAF.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

        //APARTADO C
        System.out.println("\nApartado C:");
        try {
            //Creamos el objeto del acceso aleatorio con el modo apertura en modo lectura
            RandomAccessFile x = new RandomAccessFile("C:\\Users\\Alvaro\\Documents\\paises1.txt", "r");

            System.out.println("Mostramos todos los libros");

            //Mostramos todos
            for (int i = 0; i < 4; i++) {

                x.seek(i * 22);

                linea = x.readUTF();

                System.out.println(linea);

            }

            //Cerramos el fichero
            x.close();

        } catch (IOException e) {
            System.out.println("Error");
        }

        //Borrar del arrayList la posicion 1 , 3
        System.out.println("Mostramos el arrayList con el borrado");
        System.out.println(listapaises.get(0));
        System.out.println(listapaises.get(1));
        System.out.println(listapaises.get(2));
        System.out.println(listapaises.get(3));

        listapaises.remove(0);
        listapaises.remove(2 - 1);

        System.out.println("Mostramos el arrayList con el borrado");
        Herramientas.recorrerColeccion(listapaises);

    }

}
