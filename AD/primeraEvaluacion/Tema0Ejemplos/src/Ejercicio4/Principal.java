package Ejercicio4;

import java.util.HashMap;
import java.util.Iterator;
import Herramientas.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Generar un hasmap donde la clave sea 01, 02, 03, 04
        /*
            01 - Urgente
            02 - Imortante
            03 - Normal
            04 - Baja
        
         */

         // Crear HashMap 
         HashMap prioridad = new HashMap(); 
          
         // Añadir niveles de prioridad al HashMap 
         prioridad.put("Urgente", 01); 
         prioridad.put("Importante", 02); 
         prioridad.put("Normal", 03); 
         prioridad.put("Baja Prioridad", 04); 
          
         // Mostrar la información del HashMap          
         //Herramientas.recorrerMapStr(prioridad);
         
         //mostrar el elemento de prioridad normal
         System.out.println(prioridad.get(03));
         
         //mostrar el tamanio del Map
         System.out.println(prioridad.size());
         
         // vaciar la estructura
         prioridad.clear();
         
         Herramientas.recorrerMapStr(prioridad);
         
         
         

    }

}
