package Tarea1_JavaSqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alvaro Gomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Metodo para conectarnos a una BBDD sqlite
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\tarea1.db");
        } catch (Exception e) {
            System.out.println("error de conexion");
            System.exit(0);
        }
        System.out.println("Abierta la BBDD");

        // llamada a los metodos
        createNewTable();
        insertarDatos();
        mostrarDatos();

    }

    /**
     * Metodo para crear tabla(s) en una base de datos de sqlite
     */
    public static void createNewTable() {
        // conexion a sqlite
        String url = "jdbc:sqlite:C:\\sqlite3\\tarea1.db";

        // SQL declaracion para crear nuevas tablas
        String grado = "CREATE TABLE IF NOT EXISTS grado (\n"
                + "	cod_grado integer PRIMARY KEY not null,\n"
                + "	nom_grado VARCHAR(30),\n"
                + "	creditos integer not null\n"
                + ");";
        String Matricula = "CREATE TABLE IF NOT EXISTS Matricula (\n"
                + "	cod_mat integer not null,\n"
                + "	precio real,\n"
                + "	cod_grado integer not null,\n"
                + "     FOREIGN KEY(cod_grado) REFERENCES grado(cod_grado)\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(grado);
            stmt.execute(Matricula);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para insertar datos en una base de datos de sqlite
     */
    private static void insertarDatos() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite3\\tarea1.db";

        // SQL declaracion de inserciones
        String grado1 = "INSERT INTO grado VALUES (1, 'Matematicas', 10);";
        String grado2 = "INSERT INTO grado VALUES (2, 'Ingles', 20);";

        String matricula1 = "INSERT INTO Matricula VALUES (2256, 100.0, 1);";
        String matricula2 = "INSERT INTO Matricula VALUES (5549, 200.0, 2);";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // inserccion de datos
            stmt.execute(grado1);
            stmt.execute(grado2);

            stmt.execute(matricula1);
            stmt.execute(matricula2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     * Metodo para mostrar las tablas de una base de datos en sqlite 
     */
    private static void mostrarDatos() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\tarea1.db");
        PreparedStatement psGrado = conn.prepareStatement("SELECT * FROM grado");
        PreparedStatement psMatricula = conn.prepareStatement("SELECT * FROM Matricula");
        ResultSet rsGrado = psGrado.executeQuery();
        ResultSet rsMatricula = psMatricula.executeQuery();

        System.out.println("SELECT de la tabla grado");
        while (rsGrado.next()) {
            System.out.println("codigo_grado:" + rsGrado.getString(1) + " nom_grado:" + rsGrado.getString(2) + " creditos:" + rsGrado.getString(3));
        }
        
        System.out.println("SELECT de la tabla Matricula");
        while (rsMatricula.next()) {
            System.out.println("cod_mat:" + rsMatricula.getString(1) + " precio:" + rsMatricula.getString(2) + " cod:grado:" + rsMatricula.getString(3));
        }
        rsGrado.close();
        rsMatricula.close();
    }
}
