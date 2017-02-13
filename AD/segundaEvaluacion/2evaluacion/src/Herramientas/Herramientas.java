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

    public static Connection connectORACLE(String user, String pass) {
        String host = "localhost"; // O ip como "192.168.35.185"
        String puerto = "1521";
        String sid = "XE";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String ulrjdbc = "jdbc:oracle:thin:" + user + "/" + pass + "@" + host + ":" + puerto + ":" + sid;

        Connection c = null;

        try {
            Class.forName(driver).newInstance();
            c = DriverManager.getConnection(ulrjdbc);
            System.out.println("BD Abierta con exito");
        } catch (Exception e) {
            System.out.println("Error al abrir BD");
            e.printStackTrace();
        }
        return c;
    }
}
