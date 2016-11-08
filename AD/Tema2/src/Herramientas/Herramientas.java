package Herramientas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Alvaro
 */
public class Herramientas {

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
