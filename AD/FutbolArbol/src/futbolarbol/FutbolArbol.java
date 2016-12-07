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
        System.out.println("<" + raiz.getName() + ">");

        // JUGADORES
        Element jhijo = raiz.getChild("jugadores");
        System.out.println("<" + jhijo.getName() + ">");
        List<Element> jugadores = jhijo.getChildren("jugador");
        Iterator it1 = jugadores.iterator();
        while (it1.hasNext()) {
            Element e = (Element) it1.next();
            System.out.println("\t<" + e.getName() + " nombre=" + e.getAttributeValue("nombre") + " nacido=" + e.getAttributeValue("nacido") + "/>");
        }
        System.out.println("</" + jhijo.getName() + ">");

        // ENTRENADORES
        Element ehijo = raiz.getChild("entrenadores");
        System.out.println("<" + ehijo.getName() + ">");
        List<Element> entrenadores = ehijo.getChildren("entrenador");
        Iterator it2 = entrenadores.iterator();
        while (it2.hasNext()) {
            Element e = (Element) it2.next();
            System.out.println("\t<" + e.getName() + ">");
            System.out.println("\t\tnombre" + e.getChildText("nombre"));
            System.out.println("\t\tciudad" + e.getChildText("ciudad"));
            System.out.println("\t\tsueldo" + e.getChildText("sueldo"));
            System.out.println("\t</" + e.getName() + ">");
        }
        System.out.println("</" + ehijo.getName() + ">");

//        // PRESIDENTES
        Element phijo = raiz.getChild("presidentes");
        System.out.println("<" + phijo.getName() + ">");
        List<Element> presidentes = phijo.getChildren("presidente");
        Iterator it3 = presidentes.iterator();
        while (it3.hasNext()) {
            Element e = (Element) it3.next();
            System.out.println("\t<" + e.getName() + " nombre " + e.getAttributeValue("nombre")
                    + " nacido " + e.getAttributeValue("nacido") + "/>");
        }
        System.out.println("</" + phijo.getName() + ">");

        // EQUIPOS
        Element eqhijo = raiz.getChild("equipos");
        System.out.println("<" + eqhijo.getName() + ">");
        List<Element> equipos = eqhijo.getChildren("equipo");
        Iterator it4 = equipos.iterator();
        while (it4.hasNext()) {
            Element e = (Element) it4.next();
            System.out.println("\t<" + e.getName() + ">");
            System.out.println("\t\tnombre " + e.getChildText("nombre"));
            System.out.println("\t\tciudad " + e.getChildText("ciudad"));
            System.out.println("\t</" + e.getName() + ">");
        }
        System.out.println("</" + eqhijo.getName() + ">");

        // PLANTILLAS
        Element plhijo = raiz.getChild("plantillas");
        System.out.println("<" + plhijo.getName() + ">");
        List<Element> plantillas = plhijo.getChildren("plantilla");
        Iterator it5 = plantillas.iterator();
        while (it5.hasNext()) {
            Element e = (Element) it5.next();
            System.out.println("\t<" + e.getName() + " temporada=" + e.getAttributeValue("temporada") + " equipo=" + e.getAttributeValue("equipo") + "/>");
            System.out.println("\t\t" + "jugador " + e.getChildText("jugador")+e.get);
        }
        System.out.println("</" + plhijo.getName() + ">");
        System.out.println("</" + raiz.getName() + ">");

    }
}
