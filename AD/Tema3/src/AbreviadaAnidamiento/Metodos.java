package AbreviadaAnidamiento;

import org.jdom2.Document;
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
public class Metodos {

    // 1 Mostrar el titulo de las películas que fueron rodadas por el mismo director de Asesinato en el Orient Express.
    public static void apartado1(Document doc) {
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//pelicula[director=//pelicula[titulo='Asesinato en el Orient Express']/director]/titulo", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("1.Mostrar el titulo de las películas que fueron rodadas por el mismo director de Asesinato en el Orient Express:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    // 2.Nombre de las personas que han nacido después del la fecha de nacimiento del director de la película los pajaros
    public static void apartado2(Document doc) {
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//persona[fechas/@nacimiento>//persona[nombre=//pelicula[titulo='Los Pajaros']/director]/fechas/@nacimiento]/nombre", Filters.element());
        //persona[fecha/@nacimiento>//persona[nombre=//pelicula[titulo='los pajaros']/director]/fechas/@nacimiento]/nombre
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        System.out.println("\n2.Nombre de las personas que han nacido después del la fecha de nacimiento del director de la película los pajaros:");
        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getValue());
        }
    }

    // 3.Mostrar las películas que tengan 1 actor o que su titulo se igual a alguno /s de los titulos donde haya actuado Lauren Bacall
    public static void apartado3(Document doc) {
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//pelicula[count(actor)=1 or titulo=//pelicula[actor='Lauren Bacall']/titulo]/titulo", Filters.element());
        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        System.out.println("\n3.Mostrar las películas que tengan 1 actor o que su titulo se igual a alguno /s de los titulos donde haya actuado Lauren Bacall:");
        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println(at.getValue());
        }
    }

    // 4.Mostrar el titulo de la película donde ha actuado la actriz que tenía como conyugue Tony Curtis
    public static void apartado4(Document doc) {
        XPathExpression<Element> xpath4 = XPathFactory.instance().compile("//pelicula[actor=//persona[conyugue=' Tony curtis ']/nombre]/titulo", Filters.element());
        List<Element> elemento4 = xpath4.evaluate(doc);
        Iterator it4 = elemento4.iterator();

        System.out.println("\n4.Mostrar el titulo de la película donde ha actuado la actriz que tenía como conyugue Tony Curtis:");
        while (it4.hasNext()) {
            Element at = (Element) it4.next();
            System.out.println(at.getValue());
        }
    }

    // 5.Mostrar los nombres de las personas que tengan como pareja “desconocidos” y que a demás hayan dirigido peliculas donde trabaje Janet Leight
    public static void apartado5(Document doc) {
        XPathExpression<Element> xpath5 = XPathFactory.instance().compile("//persona[conyugue='desconocido' and nombre=//pelicula[actor='Janet Leight']/director]/nombre", Filters.element());
        List<Element> elemento5 = xpath5.evaluate(doc);
        Iterator it5 = elemento5.iterator();

        System.out.println("\n5.Mostrar los nombres de las personas que tengan como pareja “desconocidos” y que a demás hayan dirigido peliculas donde trabaje Janet Leight:");
        while (it5.hasNext()) {
            Element at = (Element) it5.next();
            System.out.println(at.getValue());
        }
    }

    //6. Mostrar los actores que han nacido antes que Anthony Perkins
    public static void apartado6(Document doc) {
        XPathExpression<Element> xpath6 = XPathFactory.instance().compile("//persona/fechas[@nacimiento<//persona[nombre='Anthony Perkins']/fechas/@nacimiento and ../nombre=//actor]/../nombre", Filters.element());
        List<Element> elemento6 = xpath6.evaluate(doc);
        Iterator it6 = elemento6.iterator();

        System.out.println("\n6. Mostrar los actores que han nacido antes que Anthony Perkins:");
        while (it6.hasNext()) {
            Element at = (Element) it6.next();
            System.out.println(at.getValue());
        }
    }
}
