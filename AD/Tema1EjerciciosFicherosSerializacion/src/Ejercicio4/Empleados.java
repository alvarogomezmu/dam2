package Ejercicio4;

import java.util.*;
import java.io.*;

/**
 *
 * @author AlumnoT
 */
public class Empleados implements java.io.Serializable {

    private String nombre;
    private int edad;
    private double salario;

    public Empleados(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public Empleados() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleados{" + "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + '}';
    }

}
