/**
 * Modifica el ejercicio anterior, de tal manera que debemos crear un array con
 * tres valores fijos {"Tio", "Suegros", "Abogado"};. Debemos borrar del Hashmap
 * los valors que coincidan con estos tres. Una vez borrado debemos mostrar el
 * contenido del map mediante el patrón iterator
 *
 */
package Hoja1_04;

import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    // Contiene la clave para usar el patron Iterator y mostrar los valores guardados en el map
    public static void recorrerMapa(Map map) {

        Iterator it = map.keySet().iterator();

        while (it.hasNext()) {
            String clave = (String) it.next();
            String valor = (String) map.get(clave);
            System.out.println(clave + " " + valor);
        }
    }

    public static void borrarDatos(Map map, ArrayList ar) {
        for (int i = 0; i < ar.size(); i++) {
            if (map.containsKey(ar.get(i)) == true) {
                map.remove(ar.get(i));
            }
        }
    }

    public static void main(String args[]) {

        // Declaramos el mapa
        HashMap<String, String> agenda = new HashMap<>();

        // Aniadimos los datos al mapa
        agenda.put("Doctor", "(+52)-4000-5000");
        agenda.put("Casa", "(888)-4500-3400");
        agenda.put("Hermano", "/575)-2042-3233");
        agenda.put("Tio", "(421)-1010-0020");
        agenda.put("Suegros", "(334)-6105-4334");
        agenda.put("Oficina", "(304)-5205-8454");
        agenda.put("Abogado", "(756)-1205-3454");
        agenda.put("Papa", "(55)-9555-3270");
        agenda.put("Tienda", "(874)-2400-8600");

        System.out.println("Mostramos el HashMap: ");
        recorrerMapa(agenda);

        // Declaramos un ArrayList que contendra los valores fijos  Tio, Suegros y Abogado
        ArrayList list = new ArrayList();

        // Aniadimos los valores fijos al ArrayList
        list.add("Tio");
        list.add("Suegros");
        list.add("Abogado");

        // borrar del Hashmap los valors que coincidan con estos tres.
        borrarDatos(agenda, list);

        System.out.println("\nMostramos el HashMap con los 3 valores fijos eliminados: ");
        recorrerMapa(agenda);

    }
}
