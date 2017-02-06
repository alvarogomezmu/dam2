package TareaLibros;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Alvaro Gomez
 */
public class Controlador implements ActionListener {

    Vista visto;

    public Controlador(Vista view) {
        this.visto = view;
    }

    public void actionPerformed(ActionEvent a) {
        Statement s;
        PreparedStatement sp;
        ResultSet res;
        Vector<Object> fila;

        switch (a.getActionCommand()) {
            case "buscar":
                for (int i = visto.dtm2.getRowCount(); i > 0; i--) {
                    visto.dtm2.removeRow(i - 1);
                }
                try {
                    //Preparar la llamada
                    sp = BBDD.getConexion().prepareStatement("SELECT * FROM libros WHERE isbn=?");

                    //Ejecutarla y recoger el resultado
                    sp.setInt(1, Integer.parseInt(visto.txt.getText()));
                    res = sp.executeQuery();

                    //Recorrer el resultado
                    while (res.next()) {

                        //Añadir registro a registro en el vector
                        fila = new Vector<Object>();
                        fila.add(res.getString(2));
                        fila.add(res.getString(3));
                        fila.add(res.getInt(4));

                        //Añadir el vector a la tabla de la clase View
                        visto.dtm2.addRow(fila);

                    }
                } catch (Exception e) {
                    System.err.println("Error al hacer la consuslta");
                }
                break;
            case "todo":
                for (int i = visto.dtm.getRowCount(); i > 0; i--) {
                    visto.dtm.removeRow(i - 1);
                }
                try {
                    //Preparar la llamada
                    s = BBDD.getConexion().createStatement();
                    //Ejecutarla y recoger el resultado
                    res = s.executeQuery("SELECT * FROM libros");

                    //Recorrer el resultado
                    while (res.next()) {
                        //Añadir registro a registro en el vector
                        fila = new Vector<Object>();
                        fila.add(res.getString(2));
                        fila.add(res.getString(3));
                        fila.add(res.getInt(4));

                        //Añadir el vector a la tabla de la clase View
                        visto.dtm.addRow(fila);

                    }
                } catch (Exception e) {
                    System.err.println("Error al hacer la consuslta");
                }

                break;
        }

    }

}
