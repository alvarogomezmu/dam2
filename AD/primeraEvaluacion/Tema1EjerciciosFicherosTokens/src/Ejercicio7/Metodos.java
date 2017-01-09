package Ejercicio7;

import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    public void leerFicheroToken(File text, HashMap<String, String> m) {
        try {
            BufferedReader c = new BufferedReader(new FileReader(text));
            String linea;
            while ((linea = c.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, "=,:");
                while (st.hasMoreTokens()) {
                    String nom = st.nextToken();
                    String tel = st.nextToken();
                    m.put(nom, tel);
                    System.out.println(nom + " " + tel);
                }
            }
            c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
