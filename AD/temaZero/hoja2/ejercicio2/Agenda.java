
package Tema0_Ejs2_2;

import java.util.*;
import Herramientas.*;

public class Agenda {
    public static void anadirTelefono(String nombre, int num, Map m){
        m.put(nombre, num);
    }
    public static void consultaNombre(String nombre, Map m){
        if(m.containsKey(nombre)){
            System.out.println("El nombre a consultar esta");
        } else {
            System.out.println("El nombre a consultar no esta");
        }
    }
    public static void consultaTelefono(String nombre, Map m){
        if(m.containsKey(nombre)){
            System.out.println(nombre + " " + m.get(nombre));
        } else {
            System.out.println("El contacto no existe");
        }
    }
    public static void mostrarNumeros(Map m){
        Herramientas.recorrerMap(m);
    }
}
