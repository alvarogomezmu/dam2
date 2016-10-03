
package Ficheros4;

import Herramientas.*;
import java.io.*;
import java.util.*;

public class Menu 
{
    public static void Pares_Impares(String fichero)
    {
        
        try
        {
            BufferedReader leer=new BufferedReader(new FileReader(fichero));
            int num;
            ArrayList<Integer> pares=new ArrayList();
            ArrayList<Integer> impares=new ArrayList();
            while(leer.ready())
            {
                num=Integer.parseInt(leer.readLine());
                if(num%2==0)
                {
                    pares.add(num);
                }
                else
                {
                    impares.add(num);
                }
            }
            leer.close();
            
            System.out.print("Numeros Pares: " );
            for(int i=0;i<pares.size();i++)
            {
                System.out.print(pares.get(i)+" ");
            }
            
            System.out.print("\nNumeros Impares: " );
            for(int i=0;i<impares.size();i++)
            {
                System.out.print(impares.get(i)+" ");
            }
            System.out.println();
            
        
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) 
    {
        /*
        1. pedir por teclado 3 numeros, los vamos a escribir en un fichero secuencial
           leer el fichero completo.
           leer por pantalla diviendo en 2 sout, 1.numeros pares y la otra numeros impares.
        */
        
        herramientas.LeerxTeclado_EscribirFichero("numeros.txt",3);
        System.out.println("FICHERO↓");
        
        herramientas.LeerFichero("numeros.txt");
        Menu.Pares_Impares("numeros.txt");
    }
    
}
