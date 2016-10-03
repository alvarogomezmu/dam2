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

import java.util.HashSet;
import java.util.Set;

public class ColeccionTest {

    private String color;

    public ColeccionTest(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColeccionTest{" + "color=" + color + '}';
    }

}
