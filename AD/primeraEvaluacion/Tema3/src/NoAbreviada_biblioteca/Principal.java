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
        Document doc = b.build(new FileInputStream("NoAbreviada\\biblioteca.xml"));

        // 1. Parent. Mostrar los datos del libro con isbn  950151725
        System.out.println("1. Parent. Mostrar los datos del libro con isbn  950151725: ");
        Herramientas.xpath(doc, "//child::libro//child::isbn[self::isbn='950151725']/parent::libro/descendant::*");

        // 2. Descendant Mostrar los datos de todos los libros
        System.out.println("\n2. Descendant Mostrar los datos de todos los libros: ");
        Herramientas.xpath(doc, "//child::libro/descendant::*");

        // 3. Descendant Mostrar los autores de todos los libros
        System.out.println("\n3. Descendant Mostrar los autores de todos los libros: ");
        Herramientas.xpath(doc, "//child::libro//child::autor");

        // 4. Following  Mostrar los autores  de libros sin incluir a   Deepak Chopra
        System.out.println("\n4. Following  Mostrar los autores  de libros sin incluir a   Deepak Chopra: ");
        Herramientas.xpath(doc, "//child::libro/following::libro/child::autor");

        // 5. Following Mostrar todos los isbn incluido el del autor Deepak Chopra
        System.out.println("\n5. Following Mostrar todos los isbn incluido el del autor Deepak Chopra: ");
        Herramientas.xpath(doc, "//child::libro//child::isbn/following::isbn");

        // 6. Following Mostrar todos los autores incluidos los de disco sin que entre el deepak chopra
        System.out.println("\n6. Following Mostrar todos los autores incluidos los de disco sin que entre el Deepak Chopra: ");
        Herramientas.xpath(doc, "//child::libro[child::autor='Deepak Chopra']/following::autor");
        //child::libro//child::autor[self::autor='Deepak Chopra']/parent::libro/child::autor/following::autor        

        // 7. Following-sibling Mostrar el último libro
        System.out.println("\n7. Following-sibling Mostrar el último libro: ");
        Herramientas.xpath(doc, "/child::biblioteca/child::libro[3]/child::autor/following-sibling::*");

        // 8. Following-sibling . Mostrar los datos del libro escrito por miguel de cervantes
        System.out.println("\n8. Following-sibling . Mostrar los datos del libro escrito por miguel de cervantes: ");
        Herramientas.xpath(doc, "/child::biblioteca/child::libro[autor='Miguel Cervantes']/following-sibling::*");
    }
}
