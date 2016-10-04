/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroSerializableEjercicio3;

import Herramientas.Herramientas;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Metodos {

    public static void setContactoDatos(Contacto c) throws IOException {
        // Creamos un escaner para permitir al usuario introducir datos
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        // Pedimos al usuario que meta los datos de la persona
        System.out.print("Introduce el nombre: ");
        c.setNombre(teclado.readLine());
        System.out.print("Introduce el apellido: ");
        c.setApellido(teclado.readLine());
        System.out.print("Introduce el DNI: ");
        c.setDni(teclado.readLine());
        System.out.print("Introduce la edad: ");
        c.setEdad(Integer.parseInt(teclado.readLine()));
    }
}
    