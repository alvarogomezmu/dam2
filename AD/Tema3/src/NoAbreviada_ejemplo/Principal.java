package NoAbreviada_ejemplo;

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
        Herramientas.xpath(doc, "/child::div/child::ciudadpais/child::country");
        // Se podria usar tambien esta sintaxis: 
        //Herramientas.xpath(doc, "//child::country");

        // CONSULTAR
        // 2. Mostrar la ciudad cuyo atributo es 2
        System.out.println("\n2. Mostrar la ciudad cuyo atributo es 2: ");
        Herramientas.xpath(doc, "//child::city[attribute::idc='2']");

        // CONSULTAR
        // 3. Mostrar las ciudades que pertenecen al pais UK
        System.out.println("\n3. Mostrar las ciudades que pertenecen al pais UK: ");
        Herramientas.xpath(doc, "//child::ciudadpais/child::country[self::country='UK']/parent::ciudadpais/child::city");
        // Se podria usar tambien esta sintaxis: 
        //Herramientas.xpath(doc, "//child::country[self::country='UK']/parent::ciudadpais/child::city");
        //Herramientas.xpath(doc, "//child::ciudadpais[child::country='UK']/child::city");

        // CONSULTAR
        // EJEMPLOS DESCENDANT
        // 4. Mostrar todos los paises y sus ciudades
        System.out.println("\n4. Mostrar todos los paises y sus ciudades: ");
        Herramientas.xpath(doc, "//child::ciudadpais/descendant::*");

        // CONSULTAR
        // 5. Mostrar todos los paises 
        System.out.println("\n5. Mostrar todos los paises: ");
        Herramientas.xpath(doc, "//child::ciudadpais/descendant::country");

        // CONSULTAR
        // EJEMPLOS FOLLOWING
        // 6. Mostrar las ciudades siguientes a Kiev
        System.out.println("\n6. Mostrar las ciudades siguientes a Kiev: ");
        Herramientas.xpath(doc, "//child::city[self::city='Kiev']/following::city");

        // CONSULTAR
        // EJEMPLOS PARENT
        // 7. Mostrar todas las ciudades menos la del pais francia
        System.out.println("\n7. Mostrar todas las ciudades menos la del pais francia: ");
        Herramientas.xpath(doc, "//child::ciudadpais/child::country[self::country='France']/parent::ciudadpais/child::city/following::city");

        // CONSULTAR
        // 8. Mostrar todas las ciudades de UK menos Londres
        System.out.println("\n8. Mostrar todas las ciudades de UK menos Londres: ");
        Herramientas.xpath(doc, "//child::country[self::country='UK']/parent::ciudadpais/child::city/following::city");

        // CONSULTAR
        // EJEMPLOS PRECEDING
        // 9. Mostrar todas las ciudades menos las de ucrania
        System.out.println("\n9. Mostrar todas las ciudades menos las de ucrania: ");
        Herramientas.xpath(doc, "//child::country[self::country='Ukraine']/preceding::city");

        // CONSULTAR
        // 10. Mostrar las ciudades que forman parte del pais ucrania y que no sean Odessa
        System.out.println("\n10. Mostrar las ciudades que forman parte del pais ucrania y que no sean Odessa: ");
        Herramientas.xpath(doc, "//child::city[self::city='Odessa']/preceding-sibling::city");

        // HACER EN CLASE
        // 11. Mostrar toda la informacion de las ciudadespaises que tenemos en nuestro arbol
        System.out.println("\n11. Mostrar toda la informacion de las ciudadespaises que tenemos en nuestro arbol: ");
        Herramientas.xpath(doc, "//child::ciudadpais/descendant::*");

        // 12. Mostrar las ciudades nordicas
        System.out.println("\n12. Mostrar las ciudades nordicas: ");
        Herramientas.xpath(doc, "//child::city[self::city='Liverpool']/following::city");

        // 13. Mostrar toda la informacion de las ciudadespaises menos las de Ucrania
        System.out.println("\n13. Mostrar toda la informacion de las ciudadespaises menos las de Ucrania: ");
        Herramientas.xpath(doc, "//child::country[self::country='Ukraine']/preceding::city");

        // 14. Todas las ciudades menos las que preceden a UK y las siguientes a Ukraine
        System.out.println("\n14. Todas las ciudades menos las que preceden a UK y las siguientes a Ukraine: ");
        Herramientas.xpath(doc, "//child::ciudadpais/child::city[preceding::country='UK' and following::country='Ukraine']");

        // 15. Mostrar todas las ciudades de habla no francesa (Todas menos francia)
        System.out.println("\n15. Mostrar todas las ciudades de habla no francesa (Todas menos francia): ");
        Herramientas.xpath(doc, "//child::ciudadpais/child::city[preceding::country='UK']");

        // 17. Mostrar todas las ciudades de habla francesa  (Francia)
        System.out.println("\n17. Mostrar todas las ciudades de habla francesa (Francia): ");
        Herramientas.xpath(doc, "//child::ciudadpais/child::city[following::country='UK']");
        // Se podria usar tambien esta sintaxis:
        // Herramientas.xpath(doc, "//child::ciudadpais/child::city[preceding::country='France' and following::country='UK']");
    }
}
