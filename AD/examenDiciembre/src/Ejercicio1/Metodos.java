/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Herramientas.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static RandomAccessFile fichProd;

    public static String pedirNombre() throws IOException {
        System.out.println("Introduzca el nombre del producto");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        return Herramientas.ConvertUTF(teclado.readLine(), 20);
    }

    public static Double pedirPrecio() throws IOException {
        System.out.println("Introduzca el precio del producto");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(teclado.readLine());

    }

    public static void pintarMenu() {
        System.out.println("1. Introduce un producto"
                + "\n2. Modifica el precio de un producto"
                + "\n3. Mostrar el producto con mayor precio"
                + "\n4. Salir");
    }

    public static Integer pedirOpcion() throws IOException {
        System.out.println("Introduzca opcion");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(teclado.readLine());

    }

    public static void mostrarProducto(Producto producto) {
        System.out.println("El nombre del producto es: " + producto.nombre);
        System.out.println("El precio del producto es: " + producto.precio);

    }

    private static Producto siguienteProducto() throws FileNotFoundException, IOException {
        String nombre;
        Double precio;

        try {
            nombre = fichProd.readUTF();

            precio = fichProd.readDouble();
            Producto producto = new Producto(nombre, precio);
            return producto;
        } catch (EOFException e) {
            return new Producto("", 0.0);

        }
    }

    public static Producto getProducto(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
        fichProd.seek(0);
        Producto producto = siguienteProducto();
        while (true && !producto.nombre.equals("")) {
            if (!producto.nombre.equals("") && (producto.nombre.substring(0, nombre.length()).equals(nombre))) {
                return producto;
            }
            producto = siguienteProducto();

        }
        return new Producto("", Double.NaN);

    }

    public static void guardarProducto(Producto producto) throws FileNotFoundException, IOException, ClassNotFoundException {
        fichProd.seek(0);
        int pos = 0;

        while (true) {
            Producto wProducto = siguienteProducto();
            if (!wProducto.nombre.equals("") && (wProducto.nombre.substring(0, producto.nombre.length()).equals(producto.nombre))) {
                //if (wProducto.nombre.equals(producto.nombre)) {
                fichProd.seek(pos * 28);
                fichProd.writeUTF(producto.nombre);
                fichProd.writeDouble(producto.precio);
                return;
            }
            pos += 1;
        }
    }

    public static void nuevoProducto(Producto producto) throws FileNotFoundException, IOException, ClassNotFoundException {

        fichProd.writeUTF(producto.nombre);
        fichProd.writeDouble(producto.precio);
    }

    public static Producto mayorPrecio() throws IOException {
        Producto mayorPrecio = new Producto("", 0.0);
        fichProd.seek(0);
        Producto wProducto = siguienteProducto();
        while (true && !wProducto.nombre.equals("")) {
            if (wProducto.precio > mayorPrecio.precio) {
                mayorPrecio = wProducto;
            }
            wProducto = siguienteProducto();
        }
        return mayorPrecio;
    }
}
