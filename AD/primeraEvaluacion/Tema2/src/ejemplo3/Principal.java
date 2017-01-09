package ejemplo3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import static org.jdom2.filter.Filters.element;
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

        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("arbol3.xml"));
        Element raiz = doc.getRootElement();
        System.out.println(raiz.getName() +":"+ raiz.getAttributeValue("nombre") +" ubicacion:"+ raiz.getAttributeValue("ubicacion"));

        List<Element> tipo = raiz.getChildren("tipo");
        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            Element c = e.getChild("computadora");
            System.out.println(c.getName() +": "+ c.getAttributeValue("nombre") +" precio:"+ c.getAttributeValue("precio"));

            Element h = e.getChild("historieta");
            System.out.println(h.getName() +":"+ h.getAttributeValue("nombre") +" precio:"+ h.getAttributeValue("precio"));

            Element p = e.getChild("nivel");
            System.out.println(p.getName() +":"+ p.getAttributeValue("precio"));
        }

    }

}
