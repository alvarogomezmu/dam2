/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroSerializableEjercicio2;

import java.io.Serializable;

/**
 *
 * @author AlumnoT
 */
public class Animal implements Serializable {

    public Integer codigo;
    public String nombre;

    public Animal(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }

}
