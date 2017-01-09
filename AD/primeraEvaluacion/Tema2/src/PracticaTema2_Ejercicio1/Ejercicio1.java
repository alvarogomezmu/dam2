package PracticaTema2_Ejercicio1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("practica1Ej1.xml"));
        Element raiz = doc.getRootElement();

        System.out.println("<" + raiz.getName() + ">");

        Element thijo = raiz.getChild("teachers");
        

        List<Element> tipo = thijo.getChildren("teacher");

        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println("<" + e.getName() + ">");

            Element id = e.getChild("id");
            System.out.print("\t<" + id.getName() + ">");
            System.out.println(id.getText() + "</" + id.getName() + ">");

            Element na = e.getChild("name");
            System.out.print("\t<" + na.getName() + ">");
            System.out.println(na.getText() + "</" + na.getName() + ">");

        }

        Element shijo = raiz.getChild("students");

        List<Element> tip = shijo.getChildren("student");
        Iterator it = tip.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            System.out.println("<" + e.getName() + ">");

            Element id = e.getChild("id");
            System.out.print("\t<" + id.getName() + ">");
            System.out.println(id.getText() + "</" + id.getName() + ">");

            Element na = e.getChild("name");
            System.out.print("\t<" + na.getName() + ">");
            System.out.println(na.getText() + "</" + na.getName() + ">");

            Element hw1 = e.getChild("hw1");
            System.out.print("\t<" + hw1.getName() + ">");
            System.out.println(hw1.getText() + "</" + hw1.getName() + ">");

            Element hw2 = e.getChild("hw2");
            System.out.print("\t<" + hw2.getName() + ">");
            System.out.println(hw2.getText() + "</" + hw2.getName() + ">");

            Element pro = e.getChild("project");
            System.out.print("\t<" + pro.getName() + ">");
            System.out.println(pro.getText() + "</" + pro.getName() + ">");

            Element fin = e.getChild("final");
            System.out.print("\t<" + fin.getName() + ">");
            System.out.println(fin.getText() + "</" + fin.getName() + ">");
            System.out.println("</" + e.getName() + ">");
        }
        System.out.println("</" + raiz.getName() + ">");
    }
}
