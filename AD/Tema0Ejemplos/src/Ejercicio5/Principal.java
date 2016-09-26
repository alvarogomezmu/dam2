/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.HashMap;
import Herramientas.*;
import java.util.Scanner;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*DECLARACION DE VARIABLES*/
        Scanner teclado = new Scanner(System.in);
        String clave = "";

        // En el Map guardaremos String y Asignatura
        HashMap<String, Asignatura> asignatura = new HashMap<>();
        Asignatura asig1 = new Asignatura("ingles", 20, 40);
        Asignatura asig2 = new Asignatura("Matematicas", 25, 30);
        Asignatura asig3 = new Asignatura("Latin", 9, 12);
        Asignatura asig4 = new Asignatura("Lengua", 40, 50);
        Asignatura asig5 = new Asignatura("Biologia", 70, 80);

        asignatura.put("01", asig1);
        asignatura.put("02", asig2);
        asignatura.put("03", asig3);
        asignatura.put("04", asig4);
        asignatura.put("05", asig5);

        Herramientas.recorrerMapStr(asignatura);

        /*Pedir clave*/
        System.out.print("\nIntroduce una clave para su previo eliminado: ");
        clave = teclado.nextLine();

        if (asignatura.containsKey(clave)) {
            asignatura.remove(clave);
            Herramientas.recorrerMapStr(asignatura);

        } else {
            System.out.println("\nERROR, CLAVE ERRONEA");
        }

        /*Cambiar y comprobar el valor de una clave*/
        System.out.print("\nIntroduce una clave para su previa edicion: ");
        clave = teclado.nextLine();

        if (asignatura.containsKey(clave)) {
            asignatura.get(clave).setNombre("***");
            Herramientas.recorrerMapStr(asignatura);

        } else {
            System.out.println("\nERROR, CLAVE ERRONEA");
        }
    }

}
