/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import Herramientas.Herramientas;
import java.io.*;
import java.util.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void mostrarMenuMedicamentos() {
        System.out.println("1. todos los datos introducidos"); //(0,25 puntos)
        System.out.println("2. El penúltimo dato introducido"); //(0,25 puntos)
        System.out.println("3.El primero y el tercero dato introducido");//(0,25 puntos)
        System.out.println("4.Salir");
    }

    public static void crearMedicamentos(ObjectOutputStream escribir) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String codigo;
        String nombre;
        int precio;
        System.out.println("Introduce los datos para la creacion del medicamento: ");
        for (int i = 0; i < 4; i++) {
            System.out.println("\nNuevo Producto:");
            System.out.print("Codigo: ");
            codigo = br.readLine();
            System.out.print("Nombre: ");
            nombre = br.readLine();
            System.out.print("Precio: ");
            precio = Integer.parseInt(br.readLine());

            Medicamento med1 = new Medicamento(codigo, nombre, precio);

            escribir.writeObject(med1);
        }
    }

    public static void llamadaMedicamentos() throws FileNotFoundException, IOException {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion != 4) {
                mostrarMenuMedicamentos();

                System.out.println("Introduzca una opcion válida del menu \n");
                opcion = Integer.parseInt(br.readLine());
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream("medicamento.bat"));

                switch (opcion) {
                    case 1:
                        Herramientas.leerObjetos(leer);
                        break;
                    case 2:
                        leerPenultimoMedicamento(leer);
                        break;
                    case 3:
                        leerPrimerYtercerMedicamento(leer);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Numero erroneo.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerPenultimoMedicamento(ObjectInputStream leer) throws IOException, ClassNotFoundException {
        Medicamento m;
        ArrayList<Medicamento> lista = new ArrayList<>();
        int conta = 0;

        try {
            while (true) {
                m = (Medicamento) leer.readObject();
                lista.add(m);
                conta += 1;
            }

        } catch (EOFException ex) {
            // tratamiento de accion > pintar pantalla / guardar en un map / guardar en una colection / guardar fichero
            System.out.println("Todo bien. Final de fichero");
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
        m = lista.get(conta - 2);
        System.out.println("Datos del penultimo medicamento:" + "codigo: " + m.codigo + " nombre: " + m.nombre + " precio: " + m.precio);
    }

    public static void leerPrimerYtercerMedicamento(ObjectInputStream leer) throws IOException, ClassNotFoundException {
        Medicamento m;
        ArrayList<Medicamento> lista = new ArrayList<>();
        int conta = 0;

        try {
            while (true) {
                m = (Medicamento) leer.readObject();
                lista.add(m);
                conta += 1;
            }

        } catch (EOFException ex) {
            // tratamiento de accion > pintar pantalla / guardar en un map / guardar en una colection / guardar fichero
            System.out.println("Todo bien. Final de fichero");
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
        m = lista.get(0);
        System.out.println("Datos del primer medicamento:" + "codigo: " + m.codigo + " nombre: " + m.nombre + " precio: " + m.precio);
        m = lista.get(2);
        System.out.println("Datos del tercer medicamento:" + "codigo: " + m.codigo + " nombre: " + m.nombre + " precio: " + m.precio);
    }

    public static void mostrarMenu() {
        System.out.println("1 - Medicamentos");
        System.out.println("2 - Animales");
    }

    public static String pedirOpcion() {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            return teclado.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String pedirOpcionMedicamento() {
        System.out.println("Introduce una opcion: ");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        try {
            return teclado.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void medicamentos() throws IOException {
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("medicamento.bat"));
        crearMedicamentos(escribir);
        llamadaMedicamentos();
    }

    public static void mostrarMenuAnimales() {

        System.out.println("1. Debemos borrar un código de animal y por lo tanto el objeto asociado. "
                + "\nDicho código se pedirá por teclado en cuanto coincida lo debe borrar. "
                + "\nUna vez hecha dicha operación nos debe mostrar cómo queda el fichero."); //(0,75 puntos)
        System.out.println("2. Debemos modificar la raza de un animal. "
                + "\nPara ello se nos pedirá el nombre del animal y una vez encontrado, "
                + "\ndebemos modificar su raza con el que vosotros hayáis pedido por teclado."); //(0,25 puntos)
        System.out.println("3. Salir.");
    }

    public static void crearAnimales(ObjectOutputStream escribir) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        int edad;
        String raza;
        System.out.println("Introduce los datos para la creacion del animal: ");
        for (int i = 0; i < 4; i++) {
            System.out.println("\nNuevo Animal:");
            System.out.print("Nombre: ");
            nombre = br.readLine();
            System.out.print("Edad: ");
            edad = Integer.parseInt(br.readLine());
            System.out.print("Raza: ");
            raza = br.readLine();

            Animal anim1 = new Animal(nombre, edad, raza);

            escribir.writeObject(anim1);
        }
    }

    public static void llamadaAnimales() throws FileNotFoundException, IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion != 4) {
                mostrarMenuAnimales();

                System.out.print("\nIntroduzca una opcion válida del menu: ");
                opcion = Integer.parseInt(br.readLine());
                ObjectInputStream leer = new ObjectInputStream(new FileInputStream("animal.bat"));

                switch (opcion) {
                    case 1:
                        Herramientas.leerObjetos(leer);
                        break;
                    case 2:
                        leerPenultimoMedicamento(leer);
                        break;
                    case 3:
                        leerPrimerYtercerMedicamento(leer);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Numero erroneo.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void animales() throws IOException {
        ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("animal.bat"));
        crearAnimales(escribir);
        llamadaAnimales();
    }
}
