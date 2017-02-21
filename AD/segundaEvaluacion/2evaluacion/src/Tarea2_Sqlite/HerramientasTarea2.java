package Tarea2_Sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class HerramientasTarea2 {

    public static Connection conectarBD(String nombre) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\" + nombre + ".db");
            System.out.println("Abierta la BBDD");

        } catch (Exception e) {
            System.out.println("Error en la conexion");
            System.exit(0);
        }

        return c;
    }

    public static void leerTokenLocalidad(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerTokenDepartamento(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.setInt(3, Integer.parseInt(st.nextToken()));
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para insertar datos en una base de datos de sqlite
     */
    public static void insertarDatosEmpleados() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite3\\tarea2.db";

        // SQL declaracion de inserciones
        String Empleado1 = "INSERT INTO Empleados VALUES (111, 'Rodriguez', 1.1, 1123);";
        String Empleado2 = "INSERT INTO Empleados VALUES (222, 'Gomez', 2.2, 1456);";
        String Empleado3 = "INSERT INTO Empleados VALUES (333, 'Carrasco', 3.3, 1123);";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // inserccion de datos
            stmt.execute(Empleado1);
            stmt.execute(Empleado2);
            stmt.execute(Empleado3);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
