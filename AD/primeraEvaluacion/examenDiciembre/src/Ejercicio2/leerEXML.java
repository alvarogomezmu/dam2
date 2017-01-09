/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

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
 * @author Alvaro
 */
public class leerEXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {

        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("escribirEXML.xml"));

        Element raiz = doc.getRootElement();
        System.out.println("<" + raiz.getName() + ">");
        
        List<Element> alumno = raiz.getChildren("alumno");
        Iterator i = alumno.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println("<" + e.getName() + " id='" + e.getAttributeValue("id") + "'>");
        }
    }
}
