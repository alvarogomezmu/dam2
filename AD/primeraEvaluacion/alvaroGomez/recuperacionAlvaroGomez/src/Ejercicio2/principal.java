/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

/**
 *
 * @author AlumnoT
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException, IOException {
        Element raiz = new Element("alumnos");

        Document doc = new Document(raiz);
        
        System.out.println("ESCRIBIR:");
        Metodos.escribirEXML(doc, raiz);
        
        System.out.println("\nLEER:");
        Metodos.leerEXML(doc, raiz);
        
        System.out.println("\nOPERACIONES:");
        Metodos.OperacionesXML(doc, raiz);
        
    }

}
