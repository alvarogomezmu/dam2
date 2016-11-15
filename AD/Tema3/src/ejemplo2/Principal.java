/**
 * Operaciones:
 * añadir al primer libro un autor llamado Pedro Perez Perez
 * borrar del último libro el isbn
 *
 * Consulta xPath:
 * mostrar el título del libro que tiene más de un autor
 * mostrar los libros cuya editorial no sea EDICIONES RIALP SA
 * mostrar todos los libros menos el último
 * mostrar el título del libro cuya editorial sea la misma que la editorial que publica libros del autor Víctor Victor Garcia Hoz.
 *
 */
package ejemplo2;

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
        Document doc = b.build(new FileInputStream("biblioteca.xml"));

        // CONSULTAR
        // añadir al primer libro un autor llamado Pedro Perez Perez
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//libro/[count(autor)>1]/titulo", Filters.element());
        List<Element> elemento = xpath1.evaluate(doc);
        Iterator it1 = elemento.iterator();

        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // borrar del último libro el isbn
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//libro[editorial 1='EDICIONES RIALP SA']/titulo", Filters.element());
        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        // // libro[position!=last()]
        // //libro[editorial =//libro[autor='Victor Garcia Hoz']/editorial]/autor
    }

}
