package NoAbreviada_ejemplo;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        // LEER
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("NoAbreviada\\div.xml"));

        // CONSULTAR
        // 1. Mostrar todos los paises
        System.out.println("1. Mostrar todos los paises: ");
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("/child::div/child::ciudadpais/child::country", Filters.element());
        // Se podria usar tambien esta sintaxis: 
        // XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::country", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // 2. Mostrar la ciudad cuyo atributo es 2
        System.out.println("\n2. Mostrar la ciudad cuyo atributo es 2: ");
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//child::city[attribute::idc='2']", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // 3. Mostrar las ciudades que pertenecen al pais UK
        System.out.println("\n3. Mostrar las ciudades que pertenecen al pais UK: ");
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//child::ciudadpais/child::country[self::country='UK']/parent::ciudadpais/child::city", Filters.element());
        // Se podria usar tambien esta sintaxis: 
        //XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//child::country[self::country='UK']/parent::ciudadpais/child::city", Filters.element());
        //XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//child::ciudadpais[child::country='UK']/child::city", Filters.element());

        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // EJEMPLOS DESCENDANT
        // 4. Mostrar todos los paises y sus ciudades
        System.out.println("\n4. Mostrar todos los paises y sus ciudades: ");
        XPathExpression<Element> xpath4 = XPathFactory.instance().compile("//child::ciudadpais/descendant::*", Filters.element());

        List<Element> elemento4 = xpath4.evaluate(doc);
        Iterator it4 = elemento4.iterator();

        while (it4.hasNext()) {
            Element at = (Element) it4.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // 5. Mostrar todos los paises 
        System.out.println("\n5. Mostrar todos los paises: ");
        XPathExpression<Element> xpath5 = XPathFactory.instance().compile("//child::ciudadpais/descendant::country", Filters.element());

        List<Element> elemento5 = xpath5.evaluate(doc);
        Iterator it5 = elemento5.iterator();

        while (it5.hasNext()) {
            Element at = (Element) it5.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // CONSULTAR
        // EJEMPLOS FOLLOWING
        // 6. Mostrar las ciudades siguientes a Kiev
        System.out.println("\n6. Mostrar las ciudades siguientes a Kiev: ");
        XPathExpression<Element> xpath6 = XPathFactory.instance().compile("//child::city[self::city='Kiev']/following::city", Filters.element());

        List<Element> elemento6 = xpath6.evaluate(doc);
        Iterator it6 = elemento6.iterator();

        while (it6.hasNext()) {
            Element at = (Element) it6.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
    }

}
