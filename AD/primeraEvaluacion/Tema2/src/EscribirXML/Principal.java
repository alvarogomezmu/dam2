package EscribirXML;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Crear la raiz
        Element raiz = new Element("tienda");
        raiz.setAttribute("nombre", "tienda para geeks");
        raiz.setAttribute("ubicacion", "Tokio, Japon");

        // crear el hijo de computadora
        Element c = new Element("computadora");
        c.setAttribute("nombre", "ibook");

        c.setAttribute("precio", "1200");
        raiz.addContent(c);

        Element h = new Element("historieta");
        h.setAttribute("nombre", "Dragon Ball Volumen 1");
        h.setAttribute("precio", "$9");
        raiz.addContent(h);
        XMLOutputter outputer = new XMLOutputter();
        try {
            Document doc = new Document(raiz);

            // DOS FORMAS PARA PINTAR:
            // pintamos en fichero (que hayamos creado previamente)
            outputer.output(doc, new FileOutputStream("arbol5.xml"));
            // pintamos de forma rapida
            //outputer.output(doc, System.out);
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
}
