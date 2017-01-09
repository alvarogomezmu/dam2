/**
 * Esta clase es la que voy a leer
 */
package ficheroSerializableEjercicio;

import ficheroSerializable.*;
import java.io.Serializable;
import java.io.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Persona implements Serializable {

    public String nombre;
    public Integer codigo;
    public Integer nota;

    public Persona(String nombre, Integer codigo, Integer nota) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", codigo=" + codigo + ", nota=" + nota + '}';
    }

}
