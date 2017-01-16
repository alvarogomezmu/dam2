/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

/**
 *
 * @author AlumnoT
 */
public class Metodos {
    public static void xpath(Document doc, String ruta) {

        XPathExpression<Element> xpath = XPathFactory.instance().compile(ruta, Filters.element());
        List<Element> elemento = xpath.evaluate(doc);
        Iterator it = elemento.iterator();

        while (it.hasNext()) {
            Element at = (Element) it.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
    }
}
