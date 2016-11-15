package xpathEjercicio1;

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

    // 1. Seleccionar el segundo capitulo:
    public static void apartado1(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//capitulo[position()=2]", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println("El segundo capitulo es: " + at.getValue());
        }
    }

    // 2. Seleccionar el último capitulo:
    public static void apartado2(Document doc) {

        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//capitulo[last()]", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println("El ultimo capitulo es: " + at.getValue());
        }
    }

    // 3.Seleccionar todos los capitulo menos el último:
    public static void apartado3(Document doc) {
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//capitulo[not(position()=last())]", Filters.element());
        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println("Todos los capitulos menos el ultimo: " + at.getValue());
        }
    }

    // 4.Mostrar todos los parrafos de todos los libros:
    public static void apartado4(Document doc) {
        XPathExpression<Element> xpath4 = XPathFactory.instance().compile("//capitulo/parrafo", Filters.element());
        List<Element> elemento4 = xpath4.evaluate(doc);
        Iterator it4 = elemento4.iterator();

        System.out.println("Todos los parrafos de todos los libros:");
        while (it4.hasNext()) {
            Element at = (Element) it4.next();
            System.out.println(at.getValue());
        }
    }

    // 5.Para seleccionar todos los elementos hijo de párrafo cuyo atributo destacar sea igual a "si".
    public static void apartado5(Document doc) {
        XPathExpression<Element> xpath5 = XPathFactory.instance().compile("//capitulo/parrafo[@destacar='si']", Filters.element());
        List<Element> elemento5 = xpath5.evaluate(doc);
        Iterator it5 = elemento5.iterator();

        while (it5.hasNext()) {
            Element at = (Element) it5.next();
            System.out.println("Todos los elementos hijo de párrafo cuyo atributo destacar sea igual a 'si':\n" + at.getValue());
        }
    }

}
