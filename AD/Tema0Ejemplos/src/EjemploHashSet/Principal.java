package EjemploHashSet;

import java.util.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    public static void main(String[] args) {
        // Para eliminar repetidos y que salga ordenado
        SortedSet<String> s = new TreeSet<String>();
        s.add("100");
        s.add("101");
        s.add("100");
        s.add("102");
        s.add("110");
        Herramientas.recorrerColeccion(s);

    }
}
