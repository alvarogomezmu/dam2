/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author AlumnoT
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        // TODO code application logic here
        try {
            SAXBuilder b = new SAXBuilder();
            Document doc = b.build(new FileInputStream("arbol4.xml"));

            Element raiz = doc.getRootElement();
            System.out.println(raiz.getName());

            List<Element> tipo = raiz.getChildren("departamento");

            Iterator i = tipo.iterator();
            while (i.hasNext()) {
                Element e = (Element) i.next();
                System.out.println(e.getName());

                Element n = e.getChild("nombre");

                System.out.println(n.getName() + ": " + n.getAttributeValue("nombre"));
            }
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
}
