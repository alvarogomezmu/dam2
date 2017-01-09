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
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class leerXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("escribirAlumnos.xml"));

        Element raiz = doc.getRootElement();
        System.out.println("<" + raiz.getName() + ">");

        //------------ RAIZ
        List<Element> lista = raiz.getChildren("alumno");
        Iterator i = lista.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            System.out.println("<" + e.getName() + " id='" + e.getAttributeValue("id") + "'>");

            //-------- PRIMER NIVEL
            List<Element> datos = e.getChildren();
            Iterator itDatos = datos.iterator();
            while (itDatos.hasNext()) {
                Element dato = (Element) itDatos.next();

                System.out.print("\t<" + dato.getName() + ">" + dato.getValue());

                // --- SEGUNDO NIVEL
                List<Element> hijos = dato.getChildren();
                if (!hijos.isEmpty()) {
                    Iterator itHijo = hijos.iterator();
                    System.out.println("");
                    while (itHijo.hasNext()) {
                        Element hijo = (Element) itHijo.next();

                        System.out.print("\t\t<" + hijo.getName());

                        // ATRIBUTOS DEL SEGUNDO NIVEL
                        if (hijo.hasAttributes()) {
                            List<Attribute> atrib = hijo.getAttributes();
                            Iterator itAtrib = atrib.iterator();
                            while (itAtrib.hasNext()) {
                                Attribute atri = (Attribute) itAtrib.next();
                                System.out.print(" " + atri.getName() + "='" + atri.getValue() + "'");
                            }
                        }
                        if (hijo.getChildren().isEmpty()) {
                            System.out.println(">");
                        } else {
                            //System.out.println("\t\t\t</" + hijo.getName() + ">");

                        }

                        // --- TERCER NIVEL
                        List<Element> hijos3 = hijo.getChildren();
                        if (!hijos.isEmpty()) {
                            Iterator itHijo3 = hijos3.iterator();
                            while (itHijo3.hasNext()) {
                                Element hijo3 = (Element) itHijo3.next();

                                System.out.print("\t\t\t<" + hijo3.getName());

                                // ATRIBUTOS DEL TERCER NIVEL
                                if (hijo3.hasAttributes()) {
                                    List<Attribute> atrib3 = hijo3.getAttributes();
                                    Iterator itAtrib3 = atrib3.iterator();
                                    while (itAtrib3.hasNext()) {
                                        Attribute atri3 = (Attribute) itAtrib3.next();
                                        System.out.print(" " + atri3.getName() + "='" + atri3.getValue() + "'");
                                    }
                                }

                                //hijos del tercer nivel
                                if (hijo3.getChildren().isEmpty()) {
                                    System.out.println(">");
                                }
                            }

                        } else {
                            if (hijo.getChildren().isEmpty()) {
                                System.out.println(">");
                            } else {
                                System.out.println("\t\t\t</" + hijo.getName() + ">");

                            }
                        }
                        System.out.println("\t\t</" + hijo.getName() + ">");
                    }

                }
                System.out.println("</" + dato.getName() + ">");
            }

        }
        System.out.println("</" + raiz.getName() + ">");
    }
}
