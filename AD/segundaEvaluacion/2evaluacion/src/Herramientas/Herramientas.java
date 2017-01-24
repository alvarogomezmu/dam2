package Herramientas;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author AlumnoT
 */
public class Herramientas {

    // Metodo para conectarnos a una BBDD sqlite
    public static Connection connectSQLite(String ruta) {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\" + ruta + ".db");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al iniciar la DB D:");
        }
        return c;
    }
}
