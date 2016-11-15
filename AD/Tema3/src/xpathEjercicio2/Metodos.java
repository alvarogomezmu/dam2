package xpathEjercicio2;

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
    public static void apartado1(Document doc){
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
    public static void apartado2(Document doc){
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//book[@isbn]/title", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        System.out.println("\n2. Lista de libros con sus números isbn de la biblioteca: ");
        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getValue());
        }
    }
}
