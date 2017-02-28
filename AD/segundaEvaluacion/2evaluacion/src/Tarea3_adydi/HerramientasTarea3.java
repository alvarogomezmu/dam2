package Tarea3_adydi;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvaro
 */
public class HerramientasTarea3 {

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

    public static void createTableEmpleado() {
        // conexion a sqlite
        String url = "jdbc:sqlite:C:\\sqlite3\\tarea3.db";

        // id, nom, genero, edad, sueldo, movil, pais, ciudad, mail, fijo, direccion)
        // SQL declaracion para crear nuevas tablas
        String Empleado = "CREATE TABLE IF NOT EXISTS Empleado (\n"
                + "	id integer PRIMARY KEY not null,\n"
                + "	nom VARCHAR(30),\n"
                + "	genero VARCHAR(30),\n"
                + "	edad integer not null,\n"
                + "	sueldo double not null,\n"
                + "	movil integer not null,\n"
                + "	pais VARCHAR(30),\n"
                + "	ciudad VARCHAR(30),\n"
                + "	mail VARCHAR(30),\n"
                + "	fijo integer not null,\n"
                + "	direccion VARCHAR(30)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(Empleado);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerTokenEmpleado(String fichero, String tokenBase, Connection c, String orden) throws Exception {
        try {

            PreparedStatement i = c.prepareStatement(orden);
            BufferedReader leer = new BufferedReader(new FileReader(fichero + ".txt"));

            String linea;
            while ((linea = leer.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, tokenBase);
                while (st.hasMoreTokens()) {

                    // id, nom, genero, edad, sueldo, movil, pais, ciudad, mail, fijo, direccion
                    i.setInt(1, Integer.parseInt(st.nextToken()));
                    i.setString(2, (String) st.nextToken());
                    i.setString(3, (String) st.nextToken());
                    i.setInt(4, Integer.parseInt(st.nextToken()));
                    i.setDouble(5, Double.parseDouble(st.nextToken()));
                    i.setInt(6, Integer.parseInt(st.nextToken()));
                    i.setString(7, (String) st.nextToken());
                    i.setString(8, (String) st.nextToken());
                    i.setString(9, (String) st.nextToken());
                    i.setInt(10, Integer.parseInt(st.nextToken()));
                    i.setString(11, (String) st.nextToken());
                    i.executeUpdate();

                }
            }
            leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarEmpleados() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\tarea3.db");
        PreparedStatement psEmpleado = conn.prepareStatement("SELECT * from empleado;");
        ResultSet rsEmpleado = psEmpleado.executeQuery();
        System.out.println("La tabla 'Empleado' contiene los siguientes datos:");
        while (rsEmpleado.next()) {
            // id, nom, genero, edad, sueldo, movil, pais, ciudad, mail, fijo, direccion
            System.out.println("id:" + rsEmpleado.getString(1) + " nom:" + rsEmpleado.getString(2) + " genero:" + rsEmpleado.getString(3) + " edad:" + rsEmpleado.getString(4) + " sueldo:" + rsEmpleado.getString(5) + " movil:" + rsEmpleado.getString(6) + " pais:" + rsEmpleado.getString(7) + " ciudad:" + rsEmpleado.getString(8) + " mail:" + rsEmpleado.getString(9) + " fijo:" + rsEmpleado.getString(10) + " direccion:" + rsEmpleado.getString(11));
        }
        rsEmpleado.close();
    }

    public static void borrarEmpleado() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\tarea3.db");
        PreparedStatement psDelete = conn.prepareStatement("DELETE from empleado where id = 2;");
        PreparedStatement psSelect = conn.prepareStatement("SELECT * from empleado;");
        psDelete.execute();
        ResultSet rsEmpleado = psSelect.executeQuery();
        System.out.println("Tabla Empleado actualizada:");
        while (rsEmpleado.next()) {
            // id, nom, genero, edad, sueldo, movil, pais, ciudad, mail, fijo, direccion
            System.out.println("id:" + rsEmpleado.getString(1) + " nom:" + rsEmpleado.getString(2) + " genero:" + rsEmpleado.getString(3) + " edad:" + rsEmpleado.getString(4) + " sueldo:" + rsEmpleado.getString(5) + " movil:" + rsEmpleado.getString(6) + " pais:" + rsEmpleado.getString(7) + " ciudad:" + rsEmpleado.getString(8) + " mail:" + rsEmpleado.getString(9) + " fijo:" + rsEmpleado.getString(10) + " direccion:" + rsEmpleado.getString(11));
        }
        rsEmpleado.close();
    }
}
