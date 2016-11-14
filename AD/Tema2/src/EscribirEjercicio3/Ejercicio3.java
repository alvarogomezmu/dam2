package EscribirEjercicio3;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Alvaro
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Element raiz = new Element("Vehiculos");

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);

        Metodos.crearXML(doc, raiz);
    }

}
