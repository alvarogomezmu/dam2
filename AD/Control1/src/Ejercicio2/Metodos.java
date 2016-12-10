/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void crearXML(Document doc, Element raiz) {
        // Alumno 1
        Element alumno = new Element("alumno");
        Element apellido1 = new Element("apellido1");
        Element apellido2 = new Element("apellido2");
        Element nombre = new Element("nombre");
        Element sexo = new Element("sexo");
        Element estudios = new Element("estudios");
        Element asignatura = new Element("asignatura");

        alumno.setAttribute("id", "e01");
        apellido1.setText("Rivas");
        apellido2.setText("Santos");
        nombre.setText("Victor Manuel");
        sexo.setText("Hombre");

        alumno.addContent(apellido1).addContent(apellido2).addContent(nombre).addContent(sexo);

        estudios.addContent(new Element("carrera").setAttribute("codigo", "c01"));
        estudios.addContent(new Element("asignaturas").addContent(new Element("asignatura").setAttribute("codigo", "a01")).
                addContent(new Element("asignatura").setAttribute("codigo", "a03")).
                addContent(new Element("asignatura").setAttribute("codigo", "a05")).
                addContent(new Element("asignatura").setAttribute("codigo", "a09")));
        alumno.addContent(estudios);

        raiz.addContent(alumno);

        // Alumno 2
        alumno = new Element("alumno");
        apellido1 = new Element("apellido1");
        apellido2 = new Element("apellido2");
        nombre = new Element("nombre");
        sexo = new Element("sexo");
        estudios = new Element("estudios");

        alumno.setAttribute("id", "e02");
        apellido1.setText("Perez");
        apellido2.setText("Santos");
        nombre.setText("Luisa");
        sexo.setText("Mujer");

        alumno.addContent(apellido1).addContent(apellido2).addContent(nombre).addContent(sexo);

        estudios.addContent(new Element("carrera").setAttribute("codigo", "c02"));
        estudios.addContent(new Element("asignaturas").addContent(new Element("asignatura").setAttribute("codigo", "a02")).
                addContent(new Element("asignatura").setAttribute("codigo", "a01")));
        estudios.addContent(new Element("proyecto").setText("Web de IBM.com"));
        alumno.addContent(estudios);
        raiz.addContent(alumno);

        // Alumno 3
        alumno = new Element("alumno");
        apellido1 = new Element("apellido1");
        apellido2 = new Element("apellido2");
        nombre = new Element("nombre");
        sexo = new Element("sexo");
        estudios = new Element("estudios");

        alumno.setAttribute("id", "e03").setAttribute("beca", "si");
        apellido1.setText("Perez");
        apellido2.setText("Romero");
        nombre.setText("Fernando");
        sexo.setText("Hombre");

        alumno.addContent(apellido1).addContent(apellido2).addContent(nombre).addContent(sexo);

        estudios.addContent(new Element("carrera").setAttribute("codigo", "c02"));
        estudios.addContent(new Element("asignaturas").addContent(new Element("asignatura").setAttribute("codigo", "a02")).
                addContent(new Element("asignatura").setAttribute("codigo", "a01")).
                addContent(new Element("asignatura").setAttribute("codigo", "a04")).
                addContent(new Element("asignatura").setAttribute("codigo", "a09")));
        alumno.addContent(estudios);

        raiz.addContent(alumno);

        // Alumno 4
        alumno = new Element("alumno");
        apellido1 = new Element("apellido1");
        apellido2 = new Element("apellido2");
        nombre = new Element("nombre");
        sexo = new Element("sexo");
        estudios = new Element("estudios");

        alumno.setAttribute("id", "e03").setAttribute("beca", "si");
        apellido1.setText("Avanlon");
        apellido2.setText("Jimenez");
        nombre.setText("Maria");
        sexo.setText("Mujer");

        alumno.addContent(apellido1).addContent(apellido2).addContent(nombre).addContent(sexo);

        estudios.addContent(new Element("carrera").setAttribute("codigo", "c01"));
        estudios.addContent(new Element("asignaturas").addContent(new Element("asignatura").setAttribute("codigo", "a02")).
                addContent(new Element("asignatura").setAttribute("codigo", "a01")).
                addContent(new Element("asignatura").setAttribute("codigo", "a07")));
        estudios.addContent(new Element("proyecto").setText("Estudio de Salinidad del Pantano Iris"));
        alumno.addContent(estudios);

        raiz.addContent(alumno);

        try {
            // Generamos el fichero XML
            Herramientas.escribirXMLpantalla(doc);
            //Herramientas.escribirXMLmachacar(doc, "escribirAlumnos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
