/**
 * Crear un contenedor que almacene pares de datos, teniendo en cuenta que vamos
 * a guardar la siguiente información en dichos pares:
 *
 * <String DNI, objeto de clase Empleado>
 *
 * El objeto de clase empleado va a tener el nombre y apellido de los empleados.
 * Concretamente vamos a guardar los siguientes datos:
 *
 * <“34806408V”, Empleado(“Pedro Mtnez”)>;
 * <“34186581A”, Empleado(“Pablo Fdez”)>;
 *
 * Una vez lo tengamos guardado en el contenedor pertinente, debemos mostrar
 * todos los datos, y finalement borramos a uno de los dos pares de datos
 * guardados (dni. 34186581A)
 *
 */
package Hoja1_06;

import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    public static void main(String[] args) {
        // Creamos los dos empleados
        Empleado emp1 = new Empleado();
        Empleado emp2 = new Empleado();
        emp1.nuevoEmpleado("Pedro", "Mtnez");
        emp2.nuevoEmpleado("Pablo", "Fdez");

        // Creamos un contenedor
        HashMap<String, Object> list = new HashMap<String, Object>();

        list.put("34806408V", emp1);
        list.put("34186581A", emp2);

        // Mostramos el contenido del mapa
        for (Map.Entry obj1 : list.entrySet()) {
            //System.out.println(((Empleado) obj1.getValue()).getNombre() + " " + ((Empleado) obj1.getValue()).getApellido());
            
        }

        // Borramos uno de los datos
        list.remove("34186581A");
    }
}
