/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

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

        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("arbol3.xml"));

        // leer la raiz
        Element raiz = doc.getRootElement();
        System.out.println(raiz.getAttributeValue("id"));

        Element n = raiz.getChild("nombre");
        System.out.println(" " + n.getAttributeValue("nombre") + " con planta " + c.getAttributeValue("planta"));
//
//        Element h = raiz.getChild("historieta");
//        System.out.println("La historieta " + h.getAttributeValue("nombre") + " con precio " + h.getAttributeValue("precio"));
    }
}
