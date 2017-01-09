
package Herramientas;

import java.util.*;
import java.io.*;
 
public class herramientas 
{
    
    public static void recorrerCollection (Collection A )
    {
        Iterator it = A.iterator();
        while( it.hasNext() )
        {
          System.out.println(it.next());
        }
    }
    
    
    public static void recorrerMap_SO (Map B)
    {
        Iterator it=B.keySet().iterator();
        while(it.hasNext())
        {
           String clave=(String) it.next();
           Object valor=(Object) B.get(clave);
           System.out.println(clave+" "+valor);
        }
    }
    
    public static void recorrerMap_SS (Map B)
    {
        Iterator it=B.keySet().iterator();
        while(it.hasNext())
        {
           String clave=(String) it.next();
           String valor=(String) B.get(clave);
           System.out.println(clave+" "+valor);
        }
    }
    
    public static void buscarDuplicados(Object obj,Collection c)
    {
        int contador=0;

        Iterator it = c.iterator();
        while( it.hasNext() && contador<2)
        {
            if(obj.equals((String)it.next()))
            {
                contador=contador+1;
            }

        }

        if(contador==2)
        {
            System.out.println("DUPLICADOS.");
            System.out.println("\nCOLLECTION ↓");
            herramientas.recorrerCollection(c);
        }
        else
        {
            c.add(obj);
            System.out.println("OBJETO AÑADIDO.");
            System.out.println("\nCOLLECTION ↓");
            herramientas.recorrerCollection(c);
        }

    }
    
    
    public static void LeerFichero(String fichero)
    {
        try
        {
            BufferedReader leer=new BufferedReader(new FileReader(fichero));
            String linea;
            while(leer.ready())
            {
                linea=leer.readLine();
                System.out.println(linea);
            }
            leer.close();
        
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void LeerxTeclado_EscribirFichero (String fichero,int veces)
    {
        try
        {
            
          BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter escribir=new BufferedWriter(new FileWriter(fichero,true));
        
            for(int i=0;i<veces;i++)
            {
            System.out.print("Escribe: "); 
            escribir.write(teclado.readLine());
            escribir.newLine();  
            }
        
          escribir.close();
        
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    //FICHEROS ALEATORIOS
    public static String ConvertUTF(String txt, int largo)
    {
        String cadena=txt;
        if(cadena.length()>largo)
        {
            return cadena.substring(0,largo); 
        }
        else
        {
            for(int i=cadena.length();i<largo;i++)
            {
                cadena=cadena+" ";
            }
            return cadena;
        }
        
    }
    
    
  
}
