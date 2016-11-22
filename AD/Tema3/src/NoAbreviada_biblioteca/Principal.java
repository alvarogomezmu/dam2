/*

 Parent. Mostrar los datos del libro con isbn  950151725
 Descendant Mostrar los datos de todos los libros
 Descendant Mostrar los autores de todos los libros
 Following  Mostrar los autores  de libros sin incluir a   Deepak Chopra
 Following Mostrar todos los isbn incluido el del autor deepak chopra:
 Following Mostrar todos los autores incluidos los de disco sin que entre el deepak chopra

 Following-sibling Mostrar el último libro
 Following-sibling . Mostrar los datos del libro escrito por miguel de cervantes
 Following-sibling  Mostrar  solo el isbn
 Preceding Mostrar el primer libro
 Preceding Mostrar  todas las editoriales  que publican libros cuyo precio sea distinto a 20
 Preceding-sibling .Mostrar el primer libro

 */
package NoAbreviada_biblioteca;

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
        Document doc = b.build(new FileInputStream("NoAbreviada\\biblioteca.xml"));

        // 1. Parent. Mostrar los datos del libro con isbn  950151725
        System.out.println("1. Parent. Mostrar los datos del libro con isbn  950151725: ");
        XPathExpression<Element> xpath1 = XPathFactory.instance().compile("//child::libro//child::isbn[self::isbn='950151725']/parent::libro/descendant::*", Filters.element());

        List<Element> elemento1 = xpath1.evaluate(doc);
        Iterator it1 = elemento1.iterator();

        while (it1.hasNext()) {
            Element at = (Element) it1.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // 2. Descendant Mostrar los datos de todos los libros
        System.out.println("\n2. Descendant Mostrar los datos de todos los libros: ");
        XPathExpression<Element> xpath2 = XPathFactory.instance().compile("//child::libro/descendant::*", Filters.element());

        List<Element> elemento2 = xpath2.evaluate(doc);
        Iterator it2 = elemento2.iterator();

        while (it2.hasNext()) {
            Element at = (Element) it2.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // 3. Descendant Mostrar los autores de todos los libros
        System.out.println("\n3. Descendant Mostrar los autores de todos los libros: ");
        XPathExpression<Element> xpath3 = XPathFactory.instance().compile("//child::libro//child::autor", Filters.element());

        List<Element> elemento3 = xpath3.evaluate(doc);
        Iterator it3 = elemento3.iterator();

        while (it3.hasNext()) {
            Element at = (Element) it3.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // 4. Following  Mostrar los autores  de libros sin incluir a   Deepak Chopra
        System.out.println("\n4. Following  Mostrar los autores  de libros sin incluir a   Deepak Chopra: ");
        XPathExpression<Element> xpath4 = XPathFactory.instance().compile("//child::libro//child::autor[self::autor='Deepak Chopra']/parent::libro//child::autor/following::autor", Filters.element());

        List<Element> elemento4 = xpath4.evaluate(doc);
        Iterator it4 = elemento4.iterator();

        while (it4.hasNext()) {
            Element at = (Element) it4.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // 5. Following Mostrar todos los isbn incluido el del autor Deepak Chopra
        System.out.println("\n5. Following Mostrar todos los isbn incluido el del autor Deepak Chopra: ");
        XPathExpression<Element> xpath5 = XPathFactory.instance().compile("//child::libro//child::isbn/following::isbn", Filters.element());

        List<Element> elemento5 = xpath5.evaluate(doc);
        Iterator it5 = elemento5.iterator();

        while (it5.hasNext()) {
            Element at = (Element) it5.next();
            System.out.println(at.getName() + ": " + at.getText());
        }

        // 6. Following Mostrar todos los autores incluidos los de disco sin que entre el deepak chopra
        System.out.println("\n6. Following Mostrar todos los autores incluidos los de disco sin que entre el Deepak Chopra: ");
        XPathExpression<Element> xpath6 = XPathFactory.instance().compile("//child::libro//child::autor[self::autor='Deepak Chopra']/parent::libro/child::autor/following::autor", Filters.element());

        List<Element> elemento6 = xpath6.evaluate(doc);
        Iterator it6 = elemento6.iterator();

        while (it6.hasNext()) {
            Element at = (Element) it6.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // 7. Following-sibling Mostrar el último libro
        System.out.println("\n7. Following-sibling Mostrar el último libro: ");
        XPathExpression<Element> xpath7 = XPathFactory.instance().compile("/child::biblioteca/child::libro[3]/child::autor/following-sibling::*", Filters.element());

        List<Element> elemento7 = xpath7.evaluate(doc);
        Iterator it7 = elemento7.iterator();

        while (it7.hasNext()) {
            Element at = (Element) it7.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
        
        // 8. Following-sibling . Mostrar los datos del libro escrito por miguel de cervantes
        System.out.println("\n8. Following-sibling . Mostrar los datos del libro escrito por miguel de cervantes: ");
        XPathExpression<Element> xpath8 = XPathFactory.instance().compile("/child::biblioteca/child::libro[autor='Miguel Cervantes']/following-sibling::*", Filters.element());

        List<Element> elemento8 = xpath8.evaluate(doc);
        Iterator it8 = elemento8.iterator();

        while (it8.hasNext()) {
            Element at = (Element) it8.next();
            System.out.println(at.getName() + ": " + at.getText());
        }
    }

}
