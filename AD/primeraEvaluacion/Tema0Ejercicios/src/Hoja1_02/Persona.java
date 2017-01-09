package Hoja1_02;

import Herramientas.Herramientas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Persona {

    private String rut;
    private String nombre;

    public Persona(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "rut: " + rut + "\nnombre: " + nombre;
    }

}
