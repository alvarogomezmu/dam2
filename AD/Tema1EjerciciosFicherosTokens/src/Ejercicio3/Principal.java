/**
 * Crear un fichero con el siguiente formato:
 *
 * valor#valor#valor #valor#valor#valor #valor#valor#valor
 *
 * valor= cualquier string que queráis , repetido 2 o 3 veces
 *
 * Se os pide que leáis dicho fichero e indiquéis por pantalla cuantas veces se
 * repite dicha palabra.Para ello deberemos de buscarla, para poderlo
 * contabilizar.
 *
 */
package Ejercicio3;

import java.util.*;
import java.io.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    public static void main(String[] args) {
        try{
            String cadena=" ", palabra=" ";
            int contador=0;
            BufferedReader br2 = new BufferedReader(new FileReader("strings.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Palabra a buscar: ");
            palabra=br.readLine();
            
            while((cadena=br2.readLine())!=null){
                StringTokenizer st = new StringTokenizer(cadena,"#");
                while(st.hasMoreElements()){
                    if(palabra.compareTo((String)st.nextToken())==0)
                        contador++;
                }                
            }
            System.out.println("Numero de coincidencias: "+contador);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}