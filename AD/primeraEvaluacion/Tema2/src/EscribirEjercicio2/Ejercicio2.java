package EscribirEjercicio2;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author AlumnoT
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Element raiz = new Element("menu_almuerzo");
        
        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);
        
        Metodos.crearXML(doc, raiz);

        Metodos.modifica1(doc, raiz);

        Metodos.modifica2(doc, raiz);

        Metodos.modifica3(doc, raiz);

    }
}
