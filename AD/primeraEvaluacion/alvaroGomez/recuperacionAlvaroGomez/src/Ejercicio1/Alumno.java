package Ejercicio1;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public class Alumno implements Serializable{

    Integer edad;
    String direccion;
    String nombre;

    public Alumno(Integer edad, String direccion, String nombre) {
        this.edad = edad;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "edad=" + edad + ", direccion=" + direccion + ", nombre=" + nombre + '}';
    }
}
