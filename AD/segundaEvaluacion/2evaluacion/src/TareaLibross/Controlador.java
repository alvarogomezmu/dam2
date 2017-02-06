package TareaLibross;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import modeloVistaControlador.BBDD;

/**
 *
 * @author AlumnoT
 */
public class Controlador implements ActionListener {

    Vista visto;

    Controlador(Vista view) {
        this.visto = view;
    }

    public void actionPerformed(ActionEvent arg0) {
        Statement cs;
        PreparedStatement sp;
        ResultSet res;
        Vector<Object> fila;

        String comando = arg0.getActionCommand();

        Statement cs2;
        ResultSet rs2;
        Vector<Object> fila2;

        switch (comando) {
            case "MOSTRAR":
                for (int i = this.visto.dtm1.getRowCount(); i > 0; i--) {
                    this.visto.dtm1.removeRow(i - 1);
                }

                //Cargar datos2 en la tabla
                try {
                    //Preparar la llamada
                    cs = BBDD.getConexion().createStatement();

                    //Ejecutarla y recoger el resultado
                    res = cs.executeQuery("SELECT * FROM libros");

                    //Recorrer el resultado
                    while (res.next()) {
                        //Añadir registro a registro en el vector
                        fila = new Vector<Object>();
                        fila.add(res.getString(1));
                        fila.add(res.getString(2));
                        fila.add(res.getInt(3));
                        //Añadir el vector a la tabla de la clase View
                        this.visto.dtm1.addRow(fila);
                    }
                } catch (Exception ex) {
                    System.out.println("Error en la consulta 1.");
                }

                break;
            case "BUSCAR":
                for (int i = visto.dtm2.getRowCount(); i > 0; i--) {
                    this.visto.dtm2.removeRow(i - 1);
                }

                //Cargar datos2 en la tabla
                try {
                    //Preparar la llamada
                    sp = BBDD.getConexion().prepareStatement("SELECT * FROM libros WHERE isbn=?");

                    //Ejecutarla y recoger el resultado
                    sp.setInt(1, Integer.parseInt(this.visto.txt.getText()));

                    res = sp.executeQuery();

                    //Recorrer el resultado
                    while (res.next()) {
                        //Añadir registro a registro en el vector
                        fila2 = new Vector<Object>();
                        fila2.add(res.getString(1));
                        fila2.add(res.getString(2));
                        fila2.add(res.getInt(3));
                        //Añadir el vector a la tabla de la clase View
                        this.visto.dtm2.addRow(fila2);
                    }

                    sp.close();
                } catch (Exception ex) {
                    System.out.println("Error en la consulta 2.");
                }
                break;
        }
    }

}
