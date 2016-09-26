/*
package Ejercicio3;

import java.util.*;
import Herramientas.*;

public class ejercicio3 
{
    //Crear un arraylist y le vamos añadir 3 paises(nombres)
    //luego mostraremos el contenido del arraylist
    //intercalar un nuevo pais en la posicion 1
    //borrar de la lista el pais que esta en la posicion 2
    //luego volveremosa mostrar el contenido del arraylist
    //PEDIR por teclado el nombre de un pais y deberemos de indicar en que posicion se encuentra
    //mostrar la longitud que tiene el arraylist
    //pedir por teclado y mirar si esta o no esta.
    
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner (System.in,"UTF-8");
        
        String nuevo,nuevo2;
        
        ArrayList paises=new ArrayList();
        paises.add("COLOMBIA");
        paises.add("FRANCIA");
        paises.add("ESPAÑA");
        System.out.println("CONTENIDO DEL ARRAYLIST ↓ ");
        herramientas.recorrerCollection(paises);
        
        paises.add(1,"ALEMANIA");
        paises.remove(2);
        System.out.println();
        System.out.println("CONTENIDO DEL ARRAYLIST ↓ ");
        herramientas.recorrerCollection(paises);
        
        
        System.out.println("Introduce el nombre de un pais: ");
        nuevo=(teclado.nextLine().toUpperCase());    
        System.out.println("El pais se encuentra en la posicion: "+paises.indexOf(nuevo));
        
        System.out.println("\nLa lista tiene "+paises.size()+" paises");
        
        System.out.println("Introduce el nombre de un pais: ");
        nuevo2=(teclado.nextLine().toUpperCase());
        
        if(paises.contains(nuevo2))
        {
            System.out.println("El pais SI se encuentra");
        }
        else
        {
            System.out.println("El pais NO se encuentra");
        }
    
    }
    
}
*/