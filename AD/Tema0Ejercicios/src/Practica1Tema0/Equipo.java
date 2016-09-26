package Practica1Tema0;

/**
 *
 * @author Alvaro
 */
public class Equipo {

    private String nombre;
    private Integer cantidad;
    private double precio;

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    public Equipo(String nombre, Integer cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
