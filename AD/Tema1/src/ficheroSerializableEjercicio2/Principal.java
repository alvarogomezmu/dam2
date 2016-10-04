/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroSerializableEjercicio2;

import java.io.*;
import java.util.*;
import Herramientas.*;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // 2. crear 3 objetos animal
        Animal a1 = new Animal(1, "perro");
        Animal a2 = new Animal(2, "gato");
        Animal a3 = new Animal(3, "tigre");

        // 3. crear un hashmap
        HashMap animales = new HashMap();

        animales.put(1, "perro");
        animales.put(2, "gato");
        animales.put(3, "tigre");

        System.out.println(animales);

    }
}
