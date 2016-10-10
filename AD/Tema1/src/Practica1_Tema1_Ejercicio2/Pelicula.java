/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1_Tema1_Ejercicio2;

/**
 *
 * @author Alvaro
 */
public class Pelicula {
    String titulo;
    Double precio;

    public Pelicula(String titulo, Double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", precio=" + precio + '}';
    }
    
    
}
