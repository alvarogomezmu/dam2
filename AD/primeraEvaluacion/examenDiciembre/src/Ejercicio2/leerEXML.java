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

            Element ape1 = e.getChild("apellido1");
            System.out.print("\t<" + ape1.getName() + ">");
            System.out.println(ape1.getText() + "</" + ape1.getName() + ">");

            Element ape2 = e.getChild("apellido2");
            System.out.print("\t<" + ape2.getName() + ">");
            System.out.println(ape2.getText() + "</" + ape2.getName() + ">");

            Element nombre = e.getChild("nombre");
            System.out.print("\t<" + nombre.getName() + ">");
            System.out.println(nombre.getText() + "</" + nombre.getName() + ">");

            Element sexo = e.getChild("sexo");
            System.out.print("\t<" + sexo.getName() + ">");
            System.out.println(sexo.getText() + "</" + sexo.getName() + ">");

            List<Element> modulos = e.getChildren("modulos");
            Iterator it = modulos.iterator();
            while (it.hasNext()) {
                Element ele = (Element) it.next();
                System.out.println("\t<" + ele.getName() + ">");

                List<Element> asignaturas = ele.getChildren("asignaturas");
                Iterator ite = asignaturas.iterator();
                while (ite.hasNext()) {
                    Element elem = (Element) ite.next();
                    System.out.println("\t\t<" + elem.getName() + ">");

                    Element asig = elem.getChild("asignatura");
                    System.out.print("\t\t\t<" + asig.getName() + " codigo='" + asig.getAttributeValue("codigo") + "'>");
                    System.out.println(asig.getText() + "</" + asig.getName() + ">");
                    System.out.println("\t\t</" + elem.getName() + ">");
                }
                System.out.println("\t</" + ele.getName() + ">");
            }
            System.out.println("</" + e.getName() + ">");
//            Element modulos = e.getChild("modulos");
//            System.out.println("\t<" + modulos.getName() + ">");

//            List<Element> asignaturas = ele.getChildren("asignaturas");
//            Iterator ite = asignaturas.iterator();
//            while (ite.hasNext()) {
//                Element elem = (Element) ite.next();
//                System.out.println("\t\t<" + elem.getName() + ">");
//
//                Element asig = elem.getChild("asignatura");
//                System.out.print("\t\t\t<" + asig.getName() + " codigo='" + asig.getAttributeValue("codigo") + "'>");
//                System.out.println(asig.getText() + "</" + asig.getName() + ">");
//            }
        }
        System.out.println("</" + raiz.getName() + ">");
        
    }
}
