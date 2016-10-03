package Herramientas;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author AlumnoT
 */
public class Herramientas {

    // Sirve tanto para ArrayList como para hashSet
    public static void recorrerColeccion(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }

    //   public static void recorrerMap() {
    //     Iterator it = Object.keySet().iterator();
    //   while (it.hasNext()) {
    //     String clave = (String) it.next();
    //   Object valor = (Object) Object.get(clave);
    // System.out.println(clave + " " + valor);
    //}
    //}
    /**
     * Metodo para recorrer maps con clave String
     */
    public static void recorrerMapStr(Map map) {
        // Iteramos el map 
        Iterator it = map.keySet().iterator();

        // Recorremos el map e imprimimos la clave y el valor 
        while (it.hasNext()) {
            String clave = (String) it.next();
            Object valor = (Object) map.get(clave);
            System.out.println(clave + " " + valor);
        }
    }

    /**
     * Metodo para recorrer maps con clave Integer
     *
     * @param map Cualquier map
     */
    public static void recorrerMapInt(Map map) {
        // Iteramos el map 
        Iterator it = map.keySet().iterator();

        // Recorremos el map e imprimimos la clave y el valor 
        while (it.hasNext()) {
            Integer clave = (Integer) it.next();
            Object valor = (Object) map.get(clave);
            System.out.println(clave + " " + valor);
        }
    }

    /**
     * Metodo para escribir "n" objetos entro de un fichero
     *
     * @param escribir
     * @param objeto
     * @throws IOException
     */
    public static void escribirObjetos(ObjectOutputStream escribir, Object objeto) throws IOException {
        escribir.writeObject(objeto);
    }

    /**
     *
     * @param array
     * @param ruta
     * @throws IOException
     */
    public static void serializarArray(int array[], String ruta) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
        salida.writeObject(array);
        salida.close();
    }

    /**
     *
     * @param ruta
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void deserializarArray(String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
        int[] obj = (int[]) entrada.readObject();
        for (int i = 0; i < obj.length; i++) {
            System.out.println("El objeto es: " + obj[i]);
        }
        entrada.close();
    }

    /**
     *
     * @param obj
     * @param ruta
     * @throws IOException
     */
    public static void serializarObject(Object obj, String ruta) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
        salida.writeObject(obj);
        salida.close();
    }

    /**
     *
     * @param ruta
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserializarObject(String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
        Object obj = (Object) entrada.readObject();
        //System.out.println("El objeto es: " + obj);
        entrada.close();
        return obj;
    }

    /**
     * Metodo para leer "n" objetos dentro de un fichero
     *
     * @param leer
     * @param objeto
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void leerObjetos(ObjectInputStream leer, Object objeto) throws IOException, ClassNotFoundException {
        try {
            while (true) {
                Object c = (Object) leer.readObject();
            }
            // tratamiento de accion > pintar pantalla / guardar en un map / guardar en una colection / guardar fichero
            // sout (final fichero)
        } catch (EOFException ex) {
            System.out.println("EOFException: " + ex);
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
    }

    public static void escribirMap(ObjectOutputStream ob, Map mapa) throws IOException {
        ob.writeObject(mapa);
    }

    public static void leerMap(ObjectInputStream ob) throws IOException, ClassNotFoundException {
        Map m = null;
        try {
            while (true) {
                m = (HashMap) ob.readObject();
            }
        } catch (EOFException e) {
            System.out.println("Final del fichero");

            Iterator it = m.keySet().iterator();
            while (it.hasNext()) {
                Integer clave = (Integer) it.next();
                Object valor = (Object) m.get(clave);
                System.out.println(m.toString());
            }
        } finally {
            if (ob != null) {
                ob.close();
            }
        }
    }

    // Metodo para convertir String a un tamanio
    // La idea es que todos los string que nosotros escribamos tengan el mismo tamaño
    public static String ConvertUTF(String txt, int largo) {
        String s = txt;
        if (s.length() > largo) {
            return s.substring(0, largo);
        }
        for (int n = s.length(); n < largo; n++) {
            s = s + " ";
        }
        return s;
    }

    /**
     * Metodo para leer fichero mediante BufferedReader
     *
     * @param br BufferedReader declarado previamente
     * @param ar ArrayList de Integer declarado previamente
     */
    public static void leerFichero(BufferedReader br, ArrayList<Integer> ar) {
        // Declaramos variable para luego almacenar las lineas leidas del fichero
        String linea;
        try {
            // Se almacenan las lineas mientras haya lineas
            while ((linea = br.readLine()) != null) {
                // Declaracion de StringTokenizer para la linea almacenada
                // con el token !
                StringTokenizer tok = new StringTokenizer(linea, "!");
                // Mientras haya tokens, añadirlos al ArrayList<Integer>
                while (tok.hasMoreTokens()) {
                    ar.add(Integer.parseInt(tok.nextToken()));
                    ar.add(Integer.parseInt(tok.nextToken()));
                }
            }
            // Cerrar el fichero
            br.close();
            // SI ha habido un error, mostrarlo
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // metodo para escribir (serializar)
    public static void escribirArchivo(ObjectOutputStream esc, Object o) throws IOException {
        esc.writeObject(o);
    }

    //metodo para leer (deserializar)
    public static void leerArchivo(ObjectInputStream lec) throws IOException, ClassNotFoundException {
        Object c = null;
        try {
            while (true) {
                c = (Object) lec.readObject();
                System.out.println(c.toString());
            }
        } catch (EOFException ex) {
            System.out.println("\nTordo bien");

        } finally {
            if (lec != null) {
                lec.close();
            }
        }
    }

}
