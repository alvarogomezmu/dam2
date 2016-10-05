/**
 * Ejercicio3. Crear un fichero aleatorio pidiendo POR TECLADO Codigo, nombre,
 * sueldo de los empleados en total nos tiene que pedir 5. El fichero aleatorio
 * se llamará empleado.txt .Una vez lo tengamos creado tenemos que mostrar:
 * todos los datos introducidos El último dato introducido. El primero y el
 * tercero dato que hayáis escrito
 */
package Ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            RandomAccessFile fleer=new RandomAccessFile("a2.txt","r");
            for(int i=0;i<5;i++)
            {
               fleer.seek(i*30);
               int codigo=fleer.readInt();
               String nombre=fleer.readUTF();
               int sueldo=fleer.readInt();
               System.out.println("Codigo: "+codigo+" Nombre: "+ nombre + "Sueldo: "+sueldo);
            }
            
            fleer.seek(4*30);
            int codigo=fleer.readInt();
            String nombre=fleer.readUTF();
            int sueldo=fleer.readInt();
            System.out.println("Codigo: "+codigo+" Nombre: "+ nombre + "Sueldo: "+sueldo);
            
            fleer.seek(0*30);
            int codigo1=fleer.readInt();
            String nombre1=fleer.readUTF();
            int sueldo1=fleer.readInt();
            System.out.println("Codigo: "+codigo1+" Nombre: "+ nombre1 + "Sueldo: "+sueldo1);
            
            fleer.seek(2*30);
            int codigo2=fleer.readInt();
            String nombre2=fleer.readUTF();
            int sueldo2=fleer.readInt();
            System.out.println("Codigo: "+codigo2+" Nombre: "+ nombre2 + "Sueldo: "+sueldo2);
            
            fleer.close();
           
        }catch(IOException e){
        e.printStackTrace();
        }
        }
    }
    
