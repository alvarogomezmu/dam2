package Ejercicio1;

import java.io.Serializable;

/**
 *
 * @author Alvaro
 */
public class Animal implements Serializable{

    String nombre;
    Integer edad;
    String raza;

    public Animal(String nombre, Integer edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Animales{" + "nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + '}';
    }

}
