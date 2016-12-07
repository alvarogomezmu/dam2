package futbolarbol;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class FutbolArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("futbol.xml"));

        Element raiz = doc.getRootElement();
        System.out.println(raiz.getName());

        Element jhijo = raiz.getChild("jugadores");
        System.out.println(jhijo.getName());
        List<Element> tipo = jhijo.getChildren("jugador");
        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println(e.getName() + " nombre=" + e.getAttributeValue("nombre")
                    + " nacido=" + e.getAttributeValue("nacido"));

        }
    }
}
