package Ejercicios_Alumnos6;

import Herramientas.herramienta1;
import java.util.HashMap;
import java.util.Map;

public class Principal_ejer6 {

    public static void main(String[] args) {

        Empleado ob1 = new Empleado("Carla", "Valencia Terron");
        Empleado ob2 = new Empleado("Martin", "Ramirez Garcia");

        Map<String, Empleado> lista_emple = new HashMap();

        lista_emple.put("34806408V", ob1);
        lista_emple.put("34186581A", ob2);

        herramienta1.recorrerMap_SO(lista_emple);

        lista_emple.remove("34186581A");
        
        System.out.println("\n");
         herramienta1.recorrerMap_SO(lista_emple);
        
    }

}
