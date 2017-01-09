/**
 * Debemos crear una clase Persona con los siguientes datos( rut, y nombre ambos
 * de tipo string)
 *
 * Dicha clase tendrá los métodos get para el nombre ,rut y después sobrecargar
 * el método ToString en el que mostraremos el rut y el nombre.
 *
 *
 * Vamos a guardar el objeto Persona en un Arraylist, una vez hecho debemos usar
 * el patron iterator para mostrar los datos
 */
package Hoja1_01;

import Herramientas.Herramientas;
import java.util.ArrayList;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    static String nombreObjeto(Persona per) {
        String nombre = per.getNombre();
        return nombre;
    }

    public static void main(String[] args) {

        // Creamos el objeto persona
        Persona persona1 = new Persona("casa", "Ingles");
        Persona persona2 = new Persona("chalet", "Juan");
        Persona persona3 = new Persona("playa", "Carlos");

        // creamos el ArrayList
        ArrayList personas = new ArrayList();

        // aniadimos las personas
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        Herramientas.recorrerColeccion(personas);

    }

}
