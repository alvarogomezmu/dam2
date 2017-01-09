package EscribirEjercicio1;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos la etiqueta root fruta
        Element raiz = new Element("Frutas");

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);
        
        Metodos.crearXML(doc, raiz);
        Metodos.nuevaFruta(doc, raiz);
        Metodos.cambiarNombreRaiz(doc, raiz);

       
    }
}
