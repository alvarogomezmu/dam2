/**
 * Vamos a crear una agenda de teléfonos donde la clave será el nombre de un familiar y el valor será un teléfono de tipo integer.
 * Primero tendremos esa agenda en un fichero Token donde los datos tienen el formato:
 *
 * nombre,telefono
 * ;nombre,telefono
 * y sabemos que  no tenemos datos repetidos.
 *
 * Lo  que debemos hacer es recorrerlo  para guardar los datos en un Hashmap  con el formato
 * <nombre,telefono>.
 *
 * Una vez hecho los pasos anteriores debemos contestar:
 *
 * Mostrar todos los datos del token
 *
 * Mostrar todos los datos volcados en el Hashmap
 *
 * Mostrar el teléfono de una familiar concreto
 *
 * Mostrar el nombre de un familiar de un teléfono concreto
 *
 */
package Ejercicio7;

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
        Metodos obj = new Metodos();
        HashMap<String, String> map = new HashMap();

        System.out.println("Mostrar todos los datos del token: ");
        File fich = new File("fichero.txt");
        obj.leerFicheroToken(fich, map);
        

        System.out.println("");

        // Mostrar todos los datos volcados en el Hashmap
        System.out.println("\nMostrar todos los datos volcados en el Hashmap: ");
        Herramientas.recorrerMapStr(map);

        // Mostrar telefono de un familiar en concreto
        System.out.println("\nMostrar telefono de un familiar en concreto: ");
        System.out.println(map.get("Jorge"));

        // Mostrar el nombre de un familiar de un teléfono concreto
    }
}
