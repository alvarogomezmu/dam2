/**
 * ¿Qué sentencia falta en la línea de puntos, si queremos leer el primer entero
 * del cuarto registro de un fichero?Cada registro contiene dos números, el
 * primero un entero (int, 4 bytes) y el segundo un real en precisión
 * simple(float,4 bytes)
 *
 * import java.io.*; class ArchivoAleatorio { public static void main (String
 * args[]) throws IOException{
 *
 * RandomAccessFile entrada; entrada=new RandomAccessFile("fichero","r");
 * …………………… int dato=entrada.readInt(); } } //fin clase
 *
 */
package Ejercicio1;

import java.io.*;

/**
 *
 * @author Alvaro
 */
public class ArchivoAleatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        RandomAccessFile entrada;
        entrada = new RandomAccessFile("fichero.txt", "r");

        entrada.seek(4 * 30);
        int dato = entrada.readInt();
        //float datoF = entrada.readFloat();
        System.out.println("Dato: "+dato);

    }

}
