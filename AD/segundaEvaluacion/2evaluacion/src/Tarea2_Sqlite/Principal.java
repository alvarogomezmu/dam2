package Tarea2_Sqlite;

import java.sql.Connection;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection c = null;

        c = herramientasTarea.conectarBD("Tarea");
        herramientasTarea.leerToken("FicheroDepartamento", "@", c, "insert  into Departamento values(?,?,?)");
    }

}
