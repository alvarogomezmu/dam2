/**
 * Esta clase es la que voy a leer 
 */
package ficheroSerializable;

import java.io.Serializable;
import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Persona implements Serializable{
    public String nombre;
    public Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
    
}
