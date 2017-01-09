/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroSerializableEjercicio3;

/**
 *
 * @author AlumnoT
 */
public class Contacto {

    String nombre;
    String apellido;
    String dni;
    Integer edad;

    public void nuevoContacto(String nom, String ape, String d, Integer e) {
        nombre = nom;
        apellido = ape;
        dni = d;
        edad = e;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }
    
    public void setApellido(String ape) {
        apellido = ape;
    }
    
    public void setDni(String d) {
        dni = d;
    }
    
    public void setEdad(int e) {
        edad = e;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getDni() {
        return dni;
    }
    
    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", edad=" + edad + '}';
    }

}
