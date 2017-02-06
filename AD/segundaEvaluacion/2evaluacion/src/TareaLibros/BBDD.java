package TareaLibros;

import java.sql.*;

/**
 *
 * @author Alvaro Gomez
 */
public class BBDD {

    String servidor = null;
    private static Connection c = null;

    BBDD(String nombreBBDD) {
        this.servidor = "jdbc:sqlite:C:\\sqlite3\\" + nombreBBDD;
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            System.out.println("Error");
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
