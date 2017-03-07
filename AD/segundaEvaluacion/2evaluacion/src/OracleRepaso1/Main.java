package OracleRepaso1;

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
            Connection dbConnection;
            dbConnection = Herramientas.connectORACLE("usu1", "root");
            System.out.println("1. Debemos crear un procedimiento o función que  muestre el  nombre del tema, "
                    + "y la categoría del libro  teniendo en cuenta que la categoría del libro  nos interesa que "
                    + "tengan 2  “es” y que la longitud  del nombre del tema tiene que ser mayor o igual a 7 caracteres");
            Metodos.callOracleStoredProcOUTParameter(dbConnection);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

}
