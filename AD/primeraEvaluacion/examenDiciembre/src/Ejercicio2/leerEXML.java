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

            Element a1 = e.getChild("apellido1");
            System.out.print("\t<" + a1.getName() + ">");
            System.out.println(a1.getText() + "</" + a1.getName() + ">");

            Element a2 = e.getChild("apellido2");
            System.out.print("\t<" + a2.getName() + ">");
            System.out.println(a2.getText() + "</" + a2.getName() + ">");

            Element nombre = e.getChild("nombre");
            System.out.print("\t<" + nombre.getName() + ">");
            System.out.println(nombre.getText() + "</" + nombre.getName() + ">");

            Element sexo = e.getChild("sexo");
            System.out.print("\t<" + sexo.getName() + ">");
            System.out.println(sexo.getText() + "</" + sexo.getName() + ">");

            // MODULOS
            Element modulos = e.getChild("modulos");
            System.out.println("\t<" + modulos.getName() + ">");
            List<Element> asignaturas = modulos.getChildren("asignaturas");
            Iterator it = asignaturas.iterator();
            while (it.hasNext()) {

                Element el = (Element) it.next();
                System.out.println("\t\t<" + el.getName() + ">");

                Element asig = el.getChild("asignatura");
                System.out.print("\t\t\t<" + asig.getName());
                System.out.println(" codigo='" + asig.getAttributeValue("codigo")+ "'>" +asig.getText() + "</" + asig.getName() + ">");
            }
        }
    }

}
