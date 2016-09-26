/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tema0Ejercicios2_Uno;

/**
 *
 * @author Alvaro
 */
public class Persona {

    String nombre;
    String apellidos;
    String dni;
    int edad;

    public void nuevaPersona(String nom, String ape, String d, int e) {
        nombre = nom;
        apellidos = ape;
        dni = d;
        edad = e;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setApellidos(String ape) {
        apellidos = ape;
    }

    public void setDNI(String d) {
        dni = d;
    }

    public void setEdad(int e) {
        edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
}
