package Herramientas;

import java.util.*;
import java.io.*;
import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author AlumnoT
 */
public class Herramientas {

    /**
     * Metodo para recorrer tanto ArrayList como hashSet
     *
     * @param colec Cualquier coleccion
     */
    public static void recorrerColeccion(Collection colec) {
        // Iteraramos la coleccion
        Iterator it = colec.iterator();

        // Recorremos la coleccion e imprimimos todos los valores
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * Metodo para recorrer maps con clave String
     *
     * @param map Cualquier map
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
     * Metodo para determinar el tamaño de una cadena dentro de un fichero
     * aleatorio.
     *
     * (La idea es que todos los string que nosotros escribamos tengan el mismo
     * tamaño).
     *
     * @param txt Cualquier string
     * @param largo Integer asociado al string
     * @return Cadena generada
     */
    public static String ConvertUTF(String txt, int largo) {
        String s = txt;
        // Si la longitud del String es mayor que el integer asociado
        // Devuelve un substring del String dado
        if (s.length() > largo) {
            return s.substring(0, largo);
        }
        // Si el String es menor, añadirle espacios en blanco
        for (int n = s.length(); n < largo; n++) {
            s = s + " ";
        }
        return s;
    }

//    /**
//     * Metodo para leer fichero mediante BufferedReader
//     *
//     * @param br BufferedReader declarado previamente
//     * @param ar ArrayList de Integer declarado previamente
//     */
//    public static void leerFichero(BufferedReader br, ArrayList<Integer> ar) {
//        // Declaramos variable para luego almacenar las lineas leidas del fichero
//        String linea;
//        try {
//            // Se almacenan las lineas mientras haya lineas
//            while ((linea = br.readLine()) != null) {
//                // Declaracion de StringTokenizer para la linea almacenada
//                // con el token !
//                StringTokenizer tok = new StringTokenizer(linea, "!");
//                // Mientras haya tokens, añadirlos al ArrayList<Integer>
//                while (tok.hasMoreTokens()) {
//                    ar.add(Integer.parseInt(tok.nextToken()));
//                    ar.add(Integer.parseInt(tok.nextToken()));
//                }
//            }
//            // Cerrar el fichero
//            br.close();
//            // SI ha habido un error, mostrarlo
//        } catch (IOException e) {
//            System.out.println("Error: " + e);
//        }
//    }

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

    /**
     * Metodo para recorrer un ArrayList de Integers e imprimirlos
     *
     * @param ar ArrayList de Integers declarado previamente
     */
    public static void listarFichero(ArrayList<Integer> ar) {
        for (int i = 0; i < ar.size(); i++) {
            System.out.print(ar.get(i) + " ");
        }
    }

    /**
     * Metodo para serializar un array en el fichero de la ruta introducida
     *
     * @param array Array introducido con cualquier tipo de valores
     * @param ruta Ruta donde se creara el fichero serializado
     * @throws IOException
     */
    public static void serializarArray(int array[], String ruta) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
        salida.writeObject(array);
        salida.close();
    }

    /**
     * Metodo para deserializar un array del fichero de la ruta indicada
     *
     * @param ruta Ruta donde esta el fichero serializado
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
     * Metodo para leer un map dentro de un fichero
     *
     * @param ob ObjectInputStream con la ruta del fichero
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    // metodo para escribir map
    public static void escribirMap(ObjectOutputStream ob, Map mapa) throws IOException {
        ob.writeObject(mapa);
    }

    /**
     * Metodo para escribir "n" objetos dentro de un fichero
     *
     * @param escribir
     * @param objeto
     * @throws IOException
     */
    public static void escribirObjetos(ObjectOutputStream escribir, Object objeto) throws IOException {
        escribir.writeObject(objeto);
    }

    /**
     * Metodo para leer "n" objetos dentro de un fichero
     *
     * @param leer ObjectInputStream con la ruta del fichero
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void leerObjetos(ObjectInputStream leer) throws IOException, ClassNotFoundException {
        Object c = null;
        try {
            while (true) {
                c = (Object) leer.readObject();
                System.out.println(c.toString());
            }
        } catch (EOFException ex) {
            // tratamiento de accion > pintar pantalla / guardar en un map / guardar en una colection / guardar fichero
            System.out.println("Todo bien. Final de fichero");
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
    }

    /**
     * Metodo para serializar un objeto en la ruta indicada
     *
     * @param obj Objeto introducido
     * @param ruta Ruta donde se creara el fichero serializado
     * @throws IOException
     */
    public static void serializarObject(Object obj, String ruta) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta));
        salida.writeObject(obj);
        salida.close();
    }

    /**
     * Metodo para deserializar el objeto del fichero de la ruta indicada
     *
     * @param ruta Ruta donde esta el fichero serializado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void deserializarObject(String ruta) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ruta));
        Object obj = (Object) entrada.readObject();
        System.out.println("El objeto es: " + obj);
        entrada.close();
    }

    /**
     * Coge los hijos y muestra su nombre y su texto
     *
     * @param lista
     * @param nombres
     */
    public static void cogerHijos(Document doc, String nombreHijo, String nombreHijoHijo) {

        // Cogemos el Element root
        Element root = doc.getRootElement();

        System.out.println("El nombre de la raiz es: " + root.getName());

        // Cogemos los hijos de root
        List<Element> hijos = root.getChildren(nombreHijo);

        Iterator i = hijos.iterator();

        while (i.hasNext()) {
            Element h = (Element) i.next();

            System.out.println("El nombre del elemento es: " + h.getName());

            List<Element> hijosHijos = h.getChildren(nombreHijoHijo);

            Iterator i2 = hijosHijos.iterator();

            while (i2.hasNext()) {
                Element hijo = (Element) i2.next();
                System.out.println("El nombre del elemento es: " + hijo.getName());
                System.out.println("El texto que contiene es: " + hijo.getText());
            }
        }
    }

    /**
     * Crear arbol de dos niveles
     *
     * @param root Element root
     * @param hijo ArrayList<Element> hijos de root
     */
    public static void crearArbolNivel2(Element root, ArrayList<Element> hijo) {
        Element child;
        for (int i = 0; i < hijo.size(); i++) {
            child = hijo.get(i);
            root.addContent(child);
        }
    }

    /**
     * Crear arbol de tres niveles
     *
     * @param root Element root
     * @param hijo ArrayList<Element> hijos de root
     * @param hijoDeHijo ArrayList<ArrayList<Element>> hijos de hijos de root
     */
    public static void crearArbolNivel3(Element root,
            ArrayList<Element> hijo,
            ArrayList<ArrayList<Element>> hijoDeHijo) {

        Element child;
        Element childchild;

        for (int j = 0; j < hijo.size(); j++) {
            child = hijo.get(j);
            for (int i = 0; i < hijoDeHijo.get(j).size(); i++) {
                childchild = hijoDeHijo.get(j).get(i);
                child.addContent(childchild);
            }
            root.addContent(child);
        }
    }

    /**
     * Crear arbol de cuatro niveles
     *
     * @param root Element Root
     * @param hijo ArrayList<Element> hijos de root
     * @param hijoDeHijo ArrayList<ArrayList<Element>> hijos de hijos de root
     * @param hijoDeHijoDeHijo ArrayList<ArrayList<ArrayList<Element>>> hijos de
     * hijos de hijos de root
     */
    public static void crearArbolNivel4(Element root,
            ArrayList<Element> hijo,
            ArrayList<ArrayList<Element>> hijoDeHijo,
            ArrayList<ArrayList<ArrayList<Element>>> hijoDeHijoDeHijo) {

        Element child;
        Element childchild;
        Element childchildchild;

        for (int j = 0; j < hijo.size(); j++) {
            child = hijo.get(j);
            for (int i = 0; i < hijoDeHijo.get(j).size(); i++) {
                childchild = hijoDeHijo.get(j).get(i);
                for (int l = 0; l < hijoDeHijoDeHijo.get(l).size(); l++) {
                    childchildchild = hijoDeHijoDeHijo.get(j).get(i).get(l);
                    childchild.addContent(childchildchild);
                }
                child.addContent(childchild);
            }
            root.addContent(child);
        }
    }

    /**
     * Escribe el fichero pero solo lo muestra por pantalla (SIN MACHACAR)
     *
     * @param doc
     * @throws IOException
     */
    public static void escribirXMLpantalla(Document doc) throws IOException {
        XMLOutputter salida = new XMLOutputter();

        salida.output(doc, System.out);
    }

    /**
     * Machaca el fichero original.
     *
     * @param doc
     * @param nombre
     * @throws IOException
     */
    public static void escribirXMLmachacar(Document doc, String nombre) throws IOException {
        XMLOutputter salida = new XMLOutputter();

        salida.output(doc, new FileOutputStream(nombre + ".xml"));
    }
}
