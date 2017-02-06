package TareaLibross;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlumnoT
 */
public class BBDD {

    String servidor = null;

    private static Connection c = null;

    public BBDD(String nombreBBDD) {
        this.servidor = "jdbc:sqlite:C:\\sqlite3\\" + nombreBBDD;

        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            System.out.println("error de conexion");
            System.exit(0);

        }
        try {

            c = DriverManager.getConnection(this.servidor);

        } catch (SQLException e) {
            System.out.println("Error conexion servidor");
            System.exit(0);

        }
        System.out.println("conexion establecida servidor");

    }

    public static Connection getConexion() {
        return c;
    }
}
