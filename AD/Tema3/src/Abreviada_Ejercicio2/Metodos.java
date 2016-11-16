package Abreviada_Ejercicio2;

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

    // 1.Lista de títulos de libros:
    public static void apartado1(Document doc) {
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//book/title", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("1. Lista de títulos de libros:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    // 2. Lista de libros con sus números isbn de la biblioteca.
    public static void apartado2(Document doc) {
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//book[@isbn]/title", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        System.out.println("\n2. Lista de libros con sus números isbn de la biblioteca: ");
        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getValue());
        }
    }

    // 3. Lista de títulos de libros publicados el año 2000:
    public static void apartado3(Document doc) {
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//book[@year='2000']/title", Filters.element());
        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        System.out.println("\n3. Lista de títulos de libros publicados el año 2000: ");
        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println(at.getValue());
        }
    }

    // 4. Lista el primero autor de los distintos libros:
    public static void apartado4(Document doc) {
        XPathExpression<Element> xpath4 = XPathFactory.instance().compile("//book/author[position()='1']", Filters.element());
        // "//capitulo[not(position()=last())]"
        List<Element> elemento4 = xpath4.evaluate(doc);
        Iterator it4 = elemento4.iterator();

        System.out.println("\n4. Lista el primero autor de los distintos libros: ");
        while (it4.hasNext()) {
            Element at = (Element) it4.next();
            System.out.println(at.getValue());
        }
    }

    // 5. Lista el segundo autor de los distintos libros:
    public static void apartado5(Document doc) {
        XPathExpression<Element> xpath5 = XPathFactory.instance().compile("//book/author[position()='2']", Filters.element());
        // "//capitulo[not(position()=last())]"
        List<Element> elemento5 = xpath5.evaluate(doc);
        Iterator it5 = elemento5.iterator();

        System.out.println("\n5. Lista el segundo autor de los distintos libros: ");
        while (it5.hasNext()) {
            Element at = (Element) it5.next();
            System.out.println(at.getValue());
        }
    }

    // 6. Lista de títulos de libros publicados por Abiteboul después de 1995:
    public static void apartado6(Document doc) {
        XPathExpression<Element> xpath6 = XPathFactory.instance().compile("//book[@year>='1995']/title", Filters.element());
        // "//capitulo[not(position()=last())]"
        List<Element> elemento6 = xpath6.evaluate(doc);
        Iterator it6 = elemento6.iterator();

        System.out.println("\n6. Lista de títulos de libros publicados por Abiteboul después de 1995: ");
        while (it6.hasNext()) {
            Element at = (Element) it6.next();
            System.out.println(at.getValue());
        }
    }

}
