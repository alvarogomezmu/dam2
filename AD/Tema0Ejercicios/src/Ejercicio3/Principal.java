/*
 Crear una instancia de Hashmap con los siguientes datos:
 ("Doctor", "(+52)-4000-5000");("Casa", "(888)-4500-3400");("Hermano", "(575)-2042-3233");
 agenda.put("Tio", "(421)-1010-0020");("Suegros", "(334)-6105-4334");("Oficina", "(304)-5205-8454");("Abogado", "(756)-1205-3454");
 ("Papa", "(55)-9555-3270");("Tienda", "(874)-2400-8600");
 Crear un método  para que contenga el códigio para usar el patron Iterator y mostrar los datos guardados en el map.
 */
package Ejercicio3;

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
    }
}
