/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.io.FileInputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {

        SAXBuilder obj_leer = new SAXBuilder();
        Document doc = obj_leer.build(new FileInputStream("arbol2.xml"));
        Element raiz = doc.getRootElement();

        System.out.print("<" + raiz.getName() + " ");
        System.out.println("id=" + raiz.getAttributeValue("id") + ">");

        Element hijo = raiz.getChild("nombre");
        System.out.print("\t<" + hijo.getName() + ">");
        System.out.println(hijo.getText() + "</" + hijo.getName() + ">");

        Element hijo2 = raiz.getChild("planta");
        System.out.print("\t<" + hijo2.getName() + ">");
        System.out.println(hijo2.getText() + "</" + hijo2.getName() + ">");

        Element hijo3 = raiz.getChild("personal");
        System.out.print("\t<" + hijo3.getName() + " ");
        System.out.println("dni=" + hijo3.getAttributeValue("dni") + "/>");

        Element hijo4 = raiz.getChild("capital");
        System.out.print("\t<" + hijo4.getName() + " ");
        System.out.print("cantidad=" + hijo4.getAttributeValue("cantidad") + " ");
        System.out.println("tipo=" + hijo4.getAttributeValue("tipo") + "/>");

        System.out.println("</" + raiz.getName() + ">");
    }
}
