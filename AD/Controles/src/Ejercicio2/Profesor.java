/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author AlumnoT
 */
public class Profesor {

    String nombre;
    int edad;
    String titulacion;
    
    public void nuevoProfesor(String n, int e, String t) {
        nombre = n;
        edad = e;
        titulacion = t;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getTitulacion() {
        return titulacion;
    }
}