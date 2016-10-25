package ejemplo;

import java.io.FileInputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        try {
            // crear el SAX para poder leer
            SAXBuilder b = new SAXBuilder();

            // crear el documento a leer
            Document doc = b.build(new FileInputStream("arbol.xml"));

            // XMLOUTPUTTER
            // crear un objeto para leer un documento ROR LA SALIDA ESTANDARD.
            new XMLOutputter().output(doc, System.out);
        } catch (JDOMException e) {
            System.out.println(e.getMessage());
        }
    }

}
