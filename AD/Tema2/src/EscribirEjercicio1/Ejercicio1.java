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

        // Creamos la etiqueta fruta
        Element fruta = new Element("Fruta");

        // Creamos la etiqueta nombre
        Element nombre = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre
        nombre.setText("Cereza");
        raiz.addContent(fruta);

        // Creamos la etiqueta fruta2
        Element fruta2 = new Element("Fruta");

        // Creamos la etiqueta nombre2
        Element nombre2 = new Element("Nombre");

        // Añadimos un nombre a la etiqueta nombre2
        nombre2.setText("naranja");
        raiz.addContent(fruta2);

        // Creamos el arbol
        fruta.addContent(nombre);
        fruta2.addContent(nombre2);

        // Creamos el documento que contendrá el arbol
        Document doc = new Document(raiz);

        try {
            // Generamos el fichero XML
            Herramientas.escribirFichero(doc, "frutas");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
