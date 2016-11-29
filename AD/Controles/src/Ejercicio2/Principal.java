/**
 * Ejercicio 2. 6puntos
 *
 * Tenemos un fichero telefonoprofe.txt donde vamos a guardar Clases Profesores
 *
 * (Nombre, edad, titulación, debe tener implementados los getter y setter) y que hemos
 *
 * vinculado a cada profesor su número de teléfono que será único. Sabemos que el
 *
 * Número de teléfono tiene que ser Entero.(0,5 puntos)
 *
 * Lo primero que debemos hacer es generar dicho fichero, se pueden crear los
 *
 * ejemplos de Profesor y teléfono directamente en el método pertinente.(0,5 puntos)
 *
 * Una vez hecho éste primer paso, crear un pequeño menú donde podamos
 *
 * seleccionar: (no es necesario la repetición)
 *
 * a) Debemos borrar un teléfono y por lo tanto el objeto asociado. Dicho teléfono se
 *
 * pedirá por teclado y en cuanto coincida lo debe borrar. Una vez hecha dicha operación
 *
 * nos debe mostrar cómo queda el fichero ( 2puntos)
 *
 * b) Debemos modificar el nombre de un profesor. Para ello se nos pedirá el teléfono del
 *
 * profesor y una vez encontrado, debemos modificar su nombre con el que vosotros
 *
 * hayáis fijado. Una vez hecha dicha operación nos debe mostrar cómo queda el
 *
 * fichero. (3 puntos)
 */
package Ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creamos varios profesores
        Profesor prof1 = new Profesor();
        prof1.nuevoProfesor("Pepe", 33, "Matematico");

        Profesor prof2 = new Profesor();
        prof2.nuevoProfesor("Carlos", 27, "Filosofo");

        Profesor prof3 = new Profesor();
        prof3.nuevoProfesor("Tomas", 50, "Medico");

        Profesor prof4 = new Profesor();
        prof4.nuevoProfesor("Pepe", 44, "Gimnasia");

        // declaramos los 2 hashmap
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();

        // aniadimos los profesores a los map poniendo 2 en cada uno
        map1.put("645433290", prof1);
        map1.put("666779584", prof2);
        map2.put("655667889", prof3);
        map2.put("690008761", prof4);

        // iteramos los dos hashmap a la vez
        for (Map.Entry obj2 : map2.entrySet()) {
            // Almacenamos los nombres de cada HashMap en una variable distinta
            String nombre1 = ((Profesor) obj1.getValue()).getNombre();
            String nombre2 = ((Profesor) obj2.getValue()).getNombre();
        }
    }
}
