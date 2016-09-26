package EscribirLeerFichero;

import java.util.*;
import java.io.*;

public class herramientas {

    public static void recorrerCollection(Collection A) {
        Iterator it = A.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void recorrerMap_SO(Map B) {
        Iterator it = B.keySet().iterator();
        while (it.hasNext()) {
            String clave = (String) it.next();
            Object valor = (Object) B.get(clave);
            System.out.println(clave + " " + valor);
        }
    }

    public static void recorrerMap_SS(Map B) {
        Iterator it = B.keySet().iterator();
        while (it.hasNext()) {
            String clave = (String) it.next();
            String valor = (String) B.get(clave);
            System.out.println(clave + " " + valor);
        }
    }

    public static void LeerFichero(String fichero) {
        try {
            BufferedReader leer = new BufferedReader(new FileReader(fichero));
            String linea;
            while (leer.ready()) {
                linea = leer.readLine();
                System.out.println(linea);
            }
            leer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LeerxTeclado_EscribirFichero(String fichero, int veces) {
        try {

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero, true));

            for (int i = 0; i < veces; i++) {
                System.out.print("Escribe: ");
                escribir.write(teclado.readLine());
                escribir.newLine();
            }

            escribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirArrayPares(ArrayList<String> ar, String fichero) throws IOException {
        Iterator it = ar.iterator();

        BufferedWriter escribir = new BufferedWriter(new FileWriter(fichero));

        // Recorremos la coleccion e imprimimos todos los valores 
        while (it.hasNext()) {
            escribir.write((String) it.next());
            escribir.newLine();
        }
        escribir.close();
    }
}
