/**
 * Ejercicio 7 Crear un fichero  aleatorio llamado países.txt, cargando en él un
 * arrayList formado por 4 paises llamado listaPaises. Una vez tengamos los
 * datos cargados en el fichero.
 *
 * Apartado A: Mostrar los datos de la posición 0,1 y 3 del fichero (NUNCA DEL
 * ARRAY).
 *
 * Apartado B: Modificar el valor de la posición 2 cambiando el pais.( Ayuda:
 * para ello recordad que deberemos borrar el contenido y volverlo abrir).
 * Mostrar el cambio realizado.
 *
 * Apartado C: Finalmente borramos del arraylist listaPaises  los valores de la
 * posición 1 y 3.
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

        Metodos.cargarPaises(listapaises);

        Metodos.crearFichero(listapaises);

        //APARTADO A
        Metodos.apartadoA();

        //APARTADO B
        Metodos.apartadoB();

        //APARTADO C
        Metodos.apartadoC(listapaises);
    }
}
