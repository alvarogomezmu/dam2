package Tarea2_Sqlite;

import java.sql.Connection;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Connection c = null;

        c = HerramientasTarea2.conectarBD("tarea2");
        HerramientasTarea2.leerTokenLocalidad("FicheroLocalidad", "@", c, "insert  into Localidad values(?,?)");
        HerramientasTarea2.leerTokenDepartamento("FicheroDepartamento", "@", c, "insert  into Departamento values(?,?,?)");
        HerramientasTarea2.insertarDatosEmpleados();
        HerramientasTarea2.menuEmpleados();
    }

}
