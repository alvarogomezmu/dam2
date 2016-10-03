/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad1_Ejercicio4;

import Herramientas.Herramientas;

import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    
    public static void main(String[] args) {
         Map <String, String> agenda = new HashMap();
        
        agenda.put("Doctor", "(+52)-4000-5000");
        agenda.put("Casa", "(888)-4500-3400");
        agenda.put("Hermano", "(575)-2042-3233");
        agenda.put("Tio", "(421)-1010-0020");
        agenda.put("Suegros", "(334)-6105-4334");
        agenda.put("Oficina", "(304)-5205-8454");
        agenda.put("Abogado", "(756)-1205-3454");
        agenda.put("Papa", "(55)-9555-3270");
        agenda.put("Tienda", "(874)-2400-8600");

       Herramientas.recorrerMap_b(agenda);
       
       String[] array = new String[3];
       array[0]="Tio";
       array[1]="Suegros";
       array[2]="Abogado";
       for(int i=0;i<3;i++){
            if(agenda.containsKey(array[i])){
                agenda.remove(array[i]);
            }
       }
       Herramientas.recorrerMap_b(agenda);
    }
    
}
