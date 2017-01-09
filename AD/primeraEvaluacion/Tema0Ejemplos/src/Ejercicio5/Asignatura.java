/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author AlumnoT
 */
public class Asignatura {

    private String nombre;
    private Integer numeroHoras;
    private Integer precioCredito;

    public Asignatura(String nombre, Integer numeroHoras, Integer precioCredito) {
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.precioCredito = precioCredito;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", numeroHoras=" + numeroHoras + ", precioCredito=" + precioCredito + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(Integer numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Integer getPrecioCredito() {
        return precioCredito;
    }

    public void setPrecioCredito(Integer precioCredito) {
        this.precioCredito = precioCredito;
    }

}
