package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Element raiz = new Element ("alumnos");
        
        Document doc = new Document (raiz);
        
        Metodos.crearXML(doc, raiz);
        Herramientas.Herramientas.LeerFichero("Ejercicio2/escribirAlumnos.xml");
    }

}
