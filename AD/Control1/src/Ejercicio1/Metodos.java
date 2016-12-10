package Ejercicio1;

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
 * @author Alvaro
 */
public class Metodos {

//     ABREVIADA
//     1. Títulos de las películas
    public static void apartado1(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//peliculas/pelicula/titulo", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("1.Mostrar Títulos de las películas:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    public static void apartado1_NoAbreviado(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::peliculas/child::pelicula/child::titulo", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("1.\nMostrar Títulos de las películas:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

//     2. Títulos de las películas en las que Anthony Perkins es actor
    public static void apartado2(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//peliculas/pelicula[actor='Anthony Perkins']/titulo", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n2.Títulos de las películas en las que Anthony Perkins es actor:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    public static void apartado2_NoAbreviada(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::peliculas/child::pelicula[child::actor='Anthony Perkins']/child::titulo", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n2.Títulos de las películas en las que Anthony Perkins es actor:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }
//     3. Nombre de las personas de sexo femenino

    public static void apartado3(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//personas/persona[@sexo='mujer']/nombre", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n3.Nombre de las personas de sexo femenino:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    public static void apartado3_NoAbreviada(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::personas/child::persona[@sexo='mujer']/child::nombre", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n3.Nombre de las personas de sexo femenino:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }
//     4. Directores de las películas en las que actua Janet Leigh

    public static void apartado4(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//peliculas/pelicula[actor='Janet Leigh']/director", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n4.Directores de las películas en las que actua Janet Leigh:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }

    public static void apartado4_NoAbreviada(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::peliculas/child::pelicula[actor='Janet Leigh']/child::director", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n4.Directores de las películas en las que actua Janet Leigh:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }
//     5. Nombre de las personas vivas

    public static void apartado5(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//personas/persona/fechas[@fallecimiento!=0]/nombre", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n5.Nombre de las personas vivas:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }
//     6. Nombre de las personas que vivieron toda su vida en el siglo XX

    public static void apartado6(Document doc) {

        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//persona/nombre", Filters.element());
        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        System.out.println("\n6.Nombre de las personas que vivieron toda su vida en el siglo XX:");
        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getValue());
        }
    }
//     7. Fecha de nacimiento de los actores de la película "Tres en un sofá"
//     
}
