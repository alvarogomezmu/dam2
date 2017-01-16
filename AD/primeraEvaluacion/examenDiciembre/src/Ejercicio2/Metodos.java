/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void escribirEXML(Document doc, Element raiz) {
        Element alumno = new Element("alumno");
        Element modulos = new Element("modulos");
        Element asignaturas = new Element("asignaturas");

        // alumno1
        alumno.setAttribute("id", "e01");
        alumno.addContent(new Element("apellido1").setText("Sanchez"));
        alumno.addContent(new Element("apellido2").setText("Cuarental"));
        alumno.addContent(new Element("nombre").setText("Sonia"));
        alumno.addContent(new Element("sexo").setText("Mujer"));

        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a01").setText("Matematicas"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a03").setText("Fisica"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a05").setText("Lengua"));

        modulos.addContent(asignaturas);
        alumno.addContent(modulos);
        raiz.addContent(alumno);

        // alumno2
        alumno = new Element("alumno");
        alumno.setAttribute("id", "e02");
        alumno.addContent(new Element("apellido1").setText("Perez"));
        alumno.addContent(new Element("apellido2").setText("Garcia"));
        alumno.addContent(new Element("nombre").setText("Luis"));
        alumno.addContent(new Element("sexo").setText("Hombre"));

        asignaturas = new Element("asignaturas");
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a05").setText("Lengua"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a06").setText("Lengua inglesa"));

        modulos = new Element("modulos");
        modulos.addContent(asignaturas);
        alumno.addContent(modulos);
        raiz.addContent(alumno);

        //alumno3
        alumno = new Element("alumno");
        alumno.setAttribute("id", "e03").setAttribute("becado", "si");
        alumno.addContent(new Element("apellido1").setText("Perez"));
        alumno.addContent(new Element("apellido2").setText("Perez"));
        alumno.addContent(new Element("nombre").setText("Sofia"));
        alumno.addContent(new Element("sexo").setText("Mujer"));

        asignaturas = new Element("asignaturas");
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a02").setText("Lengua Arabe"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a01").setText("Matematicas"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a03").setText("Fisica"));
        asignaturas.addContent(new Element("asignatura").setAttribute("codigo", "a05").setText("Lengua"));

        modulos = new Element("modulos");
        modulos.addContent(asignaturas);
        alumno.addContent(modulos);
        raiz.addContent(alumno);

        try {
            // Generamos el fichero XML
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "escribirEXML");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void leerEXML(Document doc, Element raiz) throws JDOMException, IOException {
        SAXBuilder b = new SAXBuilder();

        System.out.println("<" + raiz.getName() + ">");

        List<Element> listaAlumnos = raiz.getChildren("alumno");
        Iterator i = listaAlumnos.iterator();
        while (i.hasNext()) {
            Element alumno = (Element) i.next();

            System.out.print("<" + alumno.getName() + " id='" + alumno.getAttributeValue("id"));
            String becado = alumno.getAttributeValue("becado");
            if (becado != null) {
                System.out.print(" becado='" + alumno.getAttributeValue("becado"));
            }
            System.out.println("'>");

            Element ape1 = alumno.getChild("apellido1");
            System.out.print("\t<" + ape1.getName() + ">");
            System.out.println(ape1.getText() + "</" + ape1.getName() + ">");

            Element ape2 = alumno.getChild("apellido2");
            System.out.print("\t<" + ape2.getName() + ">");
            System.out.println(ape2.getText() + "</" + ape2.getName() + ">");

            Element nombre = alumno.getChild("nombre");
            System.out.print("\t<" + nombre.getName() + ">");
            System.out.println(nombre.getText() + "</" + nombre.getName() + ">");

            Element sexo = alumno.getChild("sexo");
            System.out.print("\t<" + sexo.getName() + ">");
            System.out.println(sexo.getText() + "</" + sexo.getName() + ">");

            List<Element> listaModulos = alumno.getChildren("modulos");
            Iterator it = listaModulos.iterator();
            while (it.hasNext()) {
                Element modulos = (Element) it.next();
                System.out.println("\t<" + modulos.getName() + ">");

                Element asignaturas = (Element) modulos.getChild("asignaturas");
                System.out.println("\t\t<" + asignaturas.getName() + ">");

                List<Element> listaAsignaturas = asignaturas.getChildren("asignatura");
                Iterator iteAs = listaAsignaturas.iterator();
                while (iteAs.hasNext()) {
                    Element asignatura = (Element) iteAs.next();

                    System.out.print("\t\t\t<" + asignatura.getName() + " codigo='" + asignatura.getAttributeValue("codigo") + "'>");
                    System.out.println(asignatura.getText() + "</" + asignatura.getName() + ">");
                }
                System.out.println("\t\t</" + asignaturas.getName() + ">");

                System.out.println("\t</" + modulos.getName() + ">");
            }
            System.out.println("</" + alumno.getName() + ">");

        }
        System.out.println("</" + raiz.getName() + ">");
    }
    
    public static void OperacionesXML(Document doc, Element raiz){
        //System.out.println("1. Modificar  el id del alumno cuyas asignaturas empiezan en febrero y que sea mujer. Pondremos E0555. ");
        /*
        List<Element> listaAlumn = raiz.getChildren("alumno");
        Iterator iteAlum = listaAlumn.iterator();
        while (iteAlum.hasNext()) {
            Element alumno = (Element) iteAlum.next();

            Element modulos = alumno.getChild("modulos");
            List<Element> listaAsig = modulos.getChildren("asignatura");
            Iterator itAsig = listaAsig.iterator();
            while (itAsig.hasNext()) {
                Element asig = (Element) itAsig.next();
                if (asig.getText().equals("Matematicas")) {
                    alumno.setAttribute("repetidor", "NO");
                }

            }

        }
        */
        
        System.out.println("2. Añadir un nuevo atributo en la etiqueta alumno repetidor=NO, pero en los alumnos que están matriculado en Matematicas");
        if(raiz.getChild("alumno").getChild("modulos").getChild("asignaturas").getChild("asignatura").getText().equals("Matematicas")){
            raiz.getChild("alumno").setAttribute("repetidor", "NO");
        }
        
       
        
        // Escribimos las modificaciones
        try {
            Herramientas.escribirXMLpantalla(doc);
            Herramientas.escribirXMLmachacar(doc, "operacion1");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
        //System.out.println("3. Borrar la asignatura de código a05  del alumno que tiene beca");
    }
}
