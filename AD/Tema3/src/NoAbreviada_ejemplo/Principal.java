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

        // CONSULTAR
        // EJEMPLOS PARENT
        // 7. Mostrar todas las ciudades menos la del pais francia
        System.out.println("\n7. Mostrar todas las ciudades menos la del pais francia: ");
        XPathExpression<Element> xpath7 = XPathFactory.instance().compile("//child::ciudadpais/child::country[self::country='France']/parent::ciudadpais/child::city/following::city", Filters.element());

        List<Element> elemento7 = xpath7.evaluate(doc);
        Iterator it7 = elemento7.iterator();

        while (it7.hasNext()) {
            Element at = (Element) it7.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // 8. Mostrar todas las ciudades de UK menos Londres
        System.out.println("\n8. Mostrar todas las ciudades de UK menos Londres: ");
        XPathExpression<Element> xpath8 = XPathFactory.instance().compile("//child::country[self::country='UK']/parent::ciudadpais/child::city/following::city", Filters.element());

        List<Element> elemento8 = xpath8.evaluate(doc);
        Iterator it8 = elemento8.iterator();

        while (it8.hasNext()) {
            Element at = (Element) it8.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // CONSULTAR
        // EJEMPLOS PRECEDING
        // 9. Mostrar todas las ciudades menos las de ucrania
        System.out.println("\n9. Mostrar todas las ciudades menos las de ucrania: ");
        XPathExpression<Element> xpath9 = XPathFactory.instance().compile("//child::country[self::country='Ukraine']/preceding::city", Filters.element());

        List<Element> elemento9 = xpath9.evaluate(doc);
        Iterator it9 = elemento9.iterator();

        while (it9.hasNext()) {
            Element at = (Element) it9.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // CONSULTAR
        // 10. Mostrar las ciudades que forman parte del pais ucrania y que no sean Odessa
        System.out.println("\n10. Mostrar las ciudades que forman parte del pais ucrania y que no sean Odessa: ");
        XPathExpression<Element> xpath10 = XPathFactory.instance().compile("//child::city[self::city='Odessa']/preceding-sibling::city", Filters.element());
        
        List<Element> elemento10 = xpath10.evaluate(doc);
        Iterator it10 = elemento10.iterator();

        while (it10.hasNext()) {
            Element at = (Element) it10.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // HACER EN CLASE
        // 11. Mostrar toda la informacion de las ciudadespaises que tenemos en nuestro arbol
        System.out.println("\n11. Mostrar toda la informacion de las ciudadespaises que tenemos en nuestro arbol: ");
        XPathExpression<Element> xpath11 = XPathFactory.instance().compile("//child::ciudadpais/descendant::*", Filters.element());

        List<Element> elemento11 = xpath11.evaluate(doc);
        Iterator it11 = elemento11.iterator();

        while (it11.hasNext()) {
            Element at = (Element) it11.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // 12. Mostrar las ciudades nordicas
        System.out.println("\n12. Mostrar las ciudades nordicas: ");
        XPathExpression<Element> xpath12 = XPathFactory.instance().compile("//child::city[self::city='Liverpool']/following::city", Filters.element());

        List<Element> elemento12 = xpath12.evaluate(doc);
        Iterator it12 = elemento12.iterator();

        while (it12.hasNext()) {
            Element at = (Element) it12.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // 13. Mostrar toda la informacion de las ciudadespaises menos las de Ucrania
        System.out.println("\n13. Mostrar toda la informacion de las ciudadespaises menos las de Ucrania: ");
        XPathExpression<Element> xpath13 = XPathFactory.instance().compile("//child::country[self::country='Ukraine']/preceding::city", Filters.element());

        List<Element> elemento13 = xpath13.evaluate(doc);
        Iterator it13 = elemento13.iterator();

        while (it13.hasNext()) {
            Element at = (Element) it13.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
    }
}
