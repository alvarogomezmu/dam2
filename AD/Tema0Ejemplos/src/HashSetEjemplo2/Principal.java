/**
 * Crear un HashSet que sea un objeto producto que tenga nombre y precio. Vamos
 * a generar 5 instancias de ese producto repitiendo una de ellas. Lo
 * guardaremos en un HashSet. ¿Veré las 5 instancias o sólo 4? pd: El producto
 * tiene que tener nombre y precio.
 */
package HashSetEjemplo2;

import java.util.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    public static void main(String args[]) {
        Set<Object> productos = new HashSet<>();

        Producto producto1 = new Producto("Pan", 2);

        Producto producto2 = new Producto("Queso", 10);

        Producto producto3 = new Producto("Pan", 2);

        Producto producto4 = new Producto("Leche", 5);
        
        productos.add(producto1);

        productos.add(producto2);

        productos.add(producto3);

        productos.add(producto4);
        
        productos.clear();
        
        productos.addAll(productos);

        

    }
}
