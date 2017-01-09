package ejemplo1;

import java.io.FileInputStream;
import java.io.IOException;
import static org.jdom2.Content.CType.Element;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {

        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("arbol1.xml"));

        // leer la raiz
        Element raiz = doc.getRootElement();
        System.out.println(raiz.getName());
        System.out.println(raiz.getAttributeValue("nombre"));
        System.out.println(raiz.getAttribute("nombre"));
        System.out.println(raiz.getAttribute("ubicacion"));
        
        Element c = raiz.getChild("computadora");
        System.out.println("La computadora "+c.getAttributeValue("nombre")+" con precio "+c.getAttributeValue("precio"));
        
        Element h = raiz.getChild("historieta");
        System.out.println("La historieta "+h.getAttributeValue("nombre")+" con precio "+h.getAttributeValue("precio"));
    }
}
