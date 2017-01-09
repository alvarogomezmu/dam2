/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Herramientas.Herramientas;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Alvaro
 */
public class Consultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leemos el XML y lo metemos en un document
        Document documento = null;
        try {
            documento = new SAXBuilder().build("Ejercicio3/universidad.xml");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Cogemos el element root
        Element root = documento.getRootElement();
        
        // Mostrar el número del pasaporte del alumno con nombre pinillos
        if (root.getChild("alumnos").getChild("alumno").getChild("apellido").getText().equals("pinillos")){
            System.out.println(root.getChild("alumnos").getChild("alumno").getChild("pasaporte").getText());
        } 
        

    }
}
