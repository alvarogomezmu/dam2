package Repaso1;

import java.sql.*;
import Herramientas.*;

/**
 *
 * @author Alvaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Herramientas.connectORACLE("usu1", "root");
            System.out.println("1. Debemos crear un procedimiento o función que  muestre el  nombre del tema, "
                    + "y la categoría del libro  teniendo en cuenta que la categoría del libro  nos interesa que "
                    + "tengan 2  “es” y que la longitud  del nombre del tema tiene que ser mayor o igual a 7 caracteres");
            Metodos.ApartadoUno();
            // -----
            System.out.println("2. Vamos a crear un procedimiento  o una  función que pasándole el tema Aventura "
                    + "por parámetro, nos debe mostrar los autores que han escrito 2 o más libros sobre ese tema");
            Metodos.ApartadoDos();
            // -----
            System.out.println("3. Crear un procedimiento o una función que  nos muestre el  socio más viejo que "
                    + "haya  pedido prestado más de 1 libro");
            Metodos.ApartadoTres();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

}
