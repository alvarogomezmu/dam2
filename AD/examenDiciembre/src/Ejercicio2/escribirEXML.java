/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;
import java.io.IOException;

/**
 *
 * @author Alvaro
 */
public class escribirEXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element raiz = new Element("alumnos");

        Document doc = new Document(raiz);

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

}
