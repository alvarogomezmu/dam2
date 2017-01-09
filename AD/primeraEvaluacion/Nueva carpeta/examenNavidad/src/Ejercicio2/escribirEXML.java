/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Alvaro
 */
public class escribirEXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Element raiz = new Element("tebeos");

        Document doc = new Document(raiz);

        Element alumno = new Element("alumno");
        Element modulos = new Element("modulos");
        Element asignaturas = new Element("asignaturas");
    }
    
}
