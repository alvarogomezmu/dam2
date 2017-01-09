package EscribirEjercicio5;

import EscribirEjercicio5.Metodos;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Alvaro
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element raiz = new Element("Pedido");

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);

        Metodos.crearXML(doc, raiz);
        //Metodos.precioNuevo(doc, raiz);
        Metodos.modificaCant(doc, raiz);
        //Metodos.borrarObserv(doc, raiz);
        Metodos.mostrarCp(doc, raiz);
    }

}
