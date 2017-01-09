/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosLectura;

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
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("arbol6.xml"));

        Element raiz = doc.getRootElement();
        System.out.println(raiz.getName());

        Element nhijo = raiz.getChild("nombre_instituto");
        System.out.print("\t<" + nhijo.getName() + ">");
        System.out.println(nhijo.getText() + "</" + nhijo.getName() + ">");

        Element dhijo = raiz.getChild("direccion");
        System.out.print("\t<" + dhijo.getName() + ">");
        System.out.println(dhijo.getText() + "</" + dhijo.getName() + ">");

        Element phijo = raiz.getChild("profesores");
        System.out.println("<" + phijo.getName() + ">");

        List<Element> tipo = phijo.getChildren("profesor");

        Iterator i = tipo.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println(e.getName());

            Element p = e.getChild("nombre_profesor");
            System.out.print("\t<" + p.getName() + ">");
            System.out.println(p.getText() + "</" + p.getName() + ">");

            Element c = e.getChild("cuerpo_profesor");
            System.out.print("\t<" + c.getName() + ">");
            System.out.println(c.getText() + "</" + c.getName() + ">");

        }

        Element ahijo = raiz.getChild("alumnos");
        System.out.println("<" + ahijo.getName() + ">");

        
        List<Element> tip = ahijo.getChildren("alumno");
        Iterator it = tip.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            System.out.println(e.getName());

            Element n = e.getChild("nombre");
            System.out.print("\t<" + n.getName() + ">");
            System.out.println(n.getText() + "</" + n.getName() + ">");
            
            Element a1 = e.getChild("apellido1");
            System.out.print("\t<" + a1.getName() + ">");
            System.out.println(a1.getText() + "</" + a1.getName() + ">");
            
            Element a2 = e.getChild("apellido2");
            System.out.print("\t<" + a2.getName() + ">");
            System.out.println(a2.getText() + "</" + a2.getName() + ">");
            
            Element foto = e.getChild("foto");
            System.out.print("\t<" + foto.getName() + ">");
            System.out.println(foto.getText() + "</" + foto.getName() + ">");
            
            
        }
    }
}
