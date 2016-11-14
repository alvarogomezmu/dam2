package EscribirEjercicio4;

import EscribirEjercicio4.Metodos;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Alvaro
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element raiz = new Element("Personas");

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);

        Metodos.crearXML(doc, raiz);
        Metodos.nuevaDireccion(doc, raiz);
        Metodos.modificarCP(doc, raiz);
        Metodos.modificarSexo(doc, raiz);
        Metodos.modificaAno(doc, raiz);
    }

}
