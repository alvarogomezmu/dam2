/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import Herramientas.*;
import java.io.*;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    public static void mostrarMenu() {
        System.out.println("\n1- Escribir el archivo de datos");
        System.out.println("2- Leer y procesar los datos");
        System.out.println("3.- Terminar");
    }

    public static void escribir(ObjectOutputStream escribir) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nAlumnos = 0;
        String nombre = "";
        String sexo = "";
        int edad = 0;
        double estatura = 0;
        double peso = 0;

        System.out.println("numero Alumnos");
        nAlumnos = Integer.parseInt(br.readLine());
        System.out.println("Nombre");
        nombre = br.readLine();
        System.out.println("Sexo");
        sexo = br.readLine();
        System.out.println("Edad");
        edad = Integer.parseInt(br.readLine());
        System.out.println("Estatura");
        estatura = Double.parseDouble(br.readLine());
        System.out.println("Peso");
        peso = Double.parseDouble(br.readLine());

        Alumnos a1 = new Alumnos(nAlumnos, nombre, sexo, edad, estatura, peso);

        Herramientas.escribirObjetos(escribir, a1);
    }

}
