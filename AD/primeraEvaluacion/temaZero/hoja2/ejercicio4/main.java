/*
4. Crear una clase  llamada ColecciónTest  que nos permita añadir colores en ella, sin que sean repetidos.
Las acciones que debe  implementar

 a.Añadir los colores   → añade  por ejemplo 4 colores que tendrési guardados en distintas varaibles
b. Listar el contenido
c. Mostrar el tamaño de la Colección
d. Borrar el contenido concreto → borra uno de los colores que hayáis insertado
e. Mostrar contenido y tamaño una vez borrado
f. Borrar toda la colección

 */
package A17_ejCollections_hoja2_4;

import herramientas.herramientas;
import java.util.HashSet;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        Set colores = new HashSet();
        
        //creacion colores
        ColeccionTest color1 = new ColeccionTest("verde");
        ColeccionTest color2 = new ColeccionTest("amarillo");
        ColeccionTest color3 = new ColeccionTest("rosita");
        ColeccionTest color4 = new ColeccionTest("lila");
        ColeccionTest color5 = new ColeccionTest("morado");

        //añadir colores
        colores.add(color1);
        colores.add(color2);
        colores.add(color3);
        colores.add(color4);
        colores.add(color5);
        
        //ver todos los colores listados
        herramientas.recorrerColeccion(colores);

        //mostrar cuantos elementos hay
        System.out.println(colores.size());

        //eliminar un color y comprobar que se ha eliminado mostrando todos los colores y el numero de elementos
        colores.remove(color3);
        herramientas.recorrerColeccion(colores);
        System.out.println(colores.size());

        //eliminar todos los colores y comprobar que se han eliminado
        colores.clear();
        herramientas.recorrerColeccion(colores);
        
    }

}
