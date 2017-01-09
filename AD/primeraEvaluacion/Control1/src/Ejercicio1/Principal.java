/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        // LEER
        SAXBuilder b = new SAXBuilder();
        Document doc = b.build(new FileInputStream("Ejercicio1/cine.xml"));
        
        System.out.println("1. Nombre de las personas de sexo femenino: ");
        Herramientas.xpath(doc, "//personas/persona[@sexo='mujer']/nombre");
        //Herramientas.xpath(doc, "//child::peliculas/child::pelicula/child::titulo");
        
        System.out.println("2. Títulos de las películas en las que Anthony Perkins es actor:");
        Herramientas.xpath(doc, "//peliculas/pelicula[actor='Anthony Perkins']/titulo");
        //Herramientas.xpath(doc, "//child::peliculas/child::pelicula[child::actor='Anthony Perkins']/child::titulo");
        
        System.out.println("3. Nombre de las personas de sexo femenino:");
        Herramientas.xpath(doc, "//personas/persona[@sexo='mujer']/nombre");
        //Herramientas.xpath(doc, "//child::personas/child::persona[@sexo='mujer']/child::nombre");
        
        System.out.println("4. Directores de las películas en las que actua Janet Leigh:");
        Herramientas.xpath(doc, "//peliculas/pelicula[actor='Janet Leigh']/director");
        //Herramientas.xpath(doc, "//child::peliculas/child::pelicula[actor='Janet Leigh']/child::director");
        
        System.out.println("5. Nombre de las personas vivas:");
        Herramientas.xpath(doc, "//personas/persona[not (fechas/@fallecimiento)]/nombre");
        
        System.out.println("6. Nombre de las personas que vivieron toda su vida en el siglo XX:");
        Herramientas.xpath(doc, "//personas/persona[fechas/@nacimiento>'1901' and fechas/@fallecimiento<'2001']/nombre");
        
        System.out.println("7. Fecha de nacimiento de los actores de la película \"Tres en un sofá\":");
        Herramientas.xpath(doc, "//persona[nombre=//pelicula[titulo='Tres en un sofa']/actor]/fechas/@nacimiento");
    }
    
}
