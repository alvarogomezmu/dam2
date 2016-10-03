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
        try {
            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alvaro\\Documents\\strings.txt"));
            String linea;
            int count = 0;

            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "#");
                StringTokenizer st2 = new StringTokenizer(linea, "#");

                String token = st2.nextToken();

                while (st.hasMoreTokens()) {
                    if (token.equals(st.nextToken())) {
                        count++;
                    }
                }
            }
            System.out.println("El valor se repite " + count + " veces");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
