package PracticaTema2_Ejercicio2;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import Herramientas.*;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("practica1Ej2.xml"));

        Element raiz = doc.getRootElement();
        System.out.println("<" + raiz.getName() + ">");

        Element ehijo = raiz.getChild("equipos");

        List<Element> tipo = ehijo.getChildren("equipo");

        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println("\t<" + e.getName() + ">");

            Element n = e.getChild("nombre");
            System.out.print("\t\t<" + n.getName() + ">");
            System.out.println(n.getText() + "</" + n.getName() + ">");

            Element c = e.getChild("ciudad");
            System.out.print("\t\t<" + c.getName() + ">");
            System.out.println(c.getText() + "</" + c.getName() + ">");

            Element en = e.getChild("entrenador");
            System.out.print("\t\t<" + en.getName() + ">");
            System.out.println(en.getText() + "</" + en.getName() + ">");
            System.out.println("\t</" + e.getName() + ">");

            Element hijo = e.getChild("jugadores");
            List<Element> tip = hijo.getChildren("jugador");
            Iterator it = tip.iterator();
            while (it.hasNext()) {
                System.out.println("\t<" + e.getName() + ">");
                Element jug = (Element) it.next();
                System.out.println("\t\t<" + jug.getName() + ">");

                Element po = jug.getChild("posicion");
                System.out.print("\t\t\t<" + po.getName() + ">");
                System.out.println(po.getText() + "</" + po.getName() + ">");

                Element nom = jug.getChild("nombre");
                System.out.print("\t\t\t<" + nom.getName() + ">");
                System.out.println(nom.getText() + "</" + nom.getName() + ">");

                Element nac = jug.getChild("nacionalidad");
                System.out.print("\t\t\t<" + nac.getName() + ">");
                System.out.println(nac.getText() + "</" + nac.getName() + ">");
                System.out.println("\t\t</" + jug.getName() + ">");
                System.out.println("\t</" + e.getName() + ">");
                
            }
        }
        System.out.println("</" + raiz.getName() + ">");

    }
}
