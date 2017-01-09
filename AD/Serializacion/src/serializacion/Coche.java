/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.Serializable;

/**
 *
 * @author Alvaro
 */
public class Coche implements Serializable{
    public String marca;
    public String color;
    public Integer cantidad;

    public Coche(String marca, String color, Integer cantidad) {
        this.marca = marca;
        this.color = color;
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", color=" + color + ", cantidad=" + cantidad + '}';
    }



    
}
