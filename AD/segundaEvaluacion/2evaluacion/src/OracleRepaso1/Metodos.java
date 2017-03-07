package OracleRepaso1;

import java.sql.*;

/**
 *
 * @author Alvaro
 */
public class Metodos {

    public static void callOracleStoredProcOUTParameter(Connection dbConnection) throws SQLException {

        CallableStatement callableStatement = null;

        String getDBUSERByUserIdSql = "{call CATEGORIA_ES(?,?)}";

        try {
            callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

            callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            String titulo = callableStatement.getString(1);
            String categoria = callableStatement.getString(2);

            System.out.println("titulo : " + titulo);
            System.out.println("categoria : " + categoria);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                callableStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
