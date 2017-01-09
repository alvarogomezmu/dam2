/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        int opc = 0;
        String fichero = "producto.dat";

        Metodos.fichProd = new RandomAccessFile(fichero, "rw");
        String nombre;
        Double precio;
        Producto producto;

        do {
            Metodos.pintarMenu();
            opc = Metodos.pedirOpcion();
            switch (opc) {
                case 1:
                    nombre = Metodos.pedirNombre();
                    precio = Metodos.pedirPrecio();
                    Metodos.nuevoProducto(new Producto(nombre, precio));
                    break;
                case 2:
                    nombre = Metodos.pedirNombre();
                    producto = Metodos.getProducto(nombre);
                    if (producto.nombre == "") {
                        System.out.println("El producto no existe");
                    } else {
                        Metodos.mostrarProducto(producto);  
                        precio = Metodos.pedirPrecio();
                        producto.precio = precio;
                        Metodos.guardarProducto(producto);
                    }
                    break;
                case 3:
                    producto = Metodos.mayorPrecio();
                    Metodos.mostrarProducto(producto);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpcion no valida\n");
                    break;
            }
        } while (opc
                != 4);

    }

}
