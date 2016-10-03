/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividades.ejercicio2;

import java.util.*;
import herramientas.*;

public class main {

    public static void buscarDuplicados(Object per, Collection lista){
        
        int i = 0;
        Iterator it = lista.iterator();
	while (it.hasNext() && i<2) { // Comprueba si hay valor
            if(it.next()==per){
                i++;
            }
	}
        
        if(i>=2) {
            System.out.println("El objeto esta Duplicado");
        } else{
            System.out.println("El objeto NO esta Duplicado, añadiendo...");
            lista.add(per);
        }
        
        Herramientas.recorrerColeccion(lista);
    }
    
    public static void main(String[] args) {
        
        ArrayList <persona> lista = new ArrayList();
        
        persona per1 = new persona("rut1", "persona1");
        persona per2 = new persona("rut2", "persona2");
        persona per3 = new persona("rut3", "persona3");
        
        lista.add(per1);
        lista.add(per2);
        lista.add(per1);
        
        buscarDuplicados(per2, lista);
        
    }  
}