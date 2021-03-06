package TareaLibros;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alvaro Gomez
 */
public class Vista extends javax.swing.JFrame {

    DefaultTableModel dtm;
    DefaultTableModel dtm2;

    JPanel panel = new JPanel();
    JPanel pane2 = new JPanel();

    TitledBorder titled = new TitledBorder("Pulse el boton 'MOSTRAR' para mostrar todos los libros.");
    TitledBorder titled2 = new TitledBorder("Introduzca en el cuadro de texto el ISBN para mostrar el libro que desee.");

    JLabel lbl = new JLabel("ISBN");

    JTextField txt = new JTextField(25);

    JButton btn = new JButton("Mostrar");
    JButton btn2 = new JButton("Buscar");
    JButton btn3 = new JButton("Borrar");

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        setTitle("TAREA_LIBROS");

        initComponents();

        setLayout(new GridLayout(2, 1, 0, 0));

        /* //Paneles
        panel.setBackground(Color.WHITE);
        pane2.setBackground(Color.RED);*/
        Object[][] datos = {};
        ////Nombre de las columnas cabeceras
        String[] nomColumna = {"TITULO", "AUTOR", "NºPAGINAS"};

        //UNIR LAS CABECERAS A LOS DATOS
        dtm = new DefaultTableModel(datos, nomColumna);

        //Añado los datos2 a una tabla 
        JTable tabla = new JTable(dtm);

        JScrollPane sp = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setPreferredSize(new Dimension(300, 160));

        //TABLA 2
        Object[][] datos2 = {};
        //Creacion de cabecera
        String[] nomColumna2 = {"TITULO", "AUTOR", "NºPAGINAS"};

        dtm2 = new DefaultTableModel(datos2, nomColumna2);

        JTable tabla2 = new JTable(dtm2);

        JScrollPane sp2 = new JScrollPane(tabla2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setPreferredSize(new Dimension(300, 160));

        //ADD
        add(panel);
        add(pane2);

        panel.setBorder(titled);
        panel.add(sp);
        panel.add(btn);

        pane2.add(lbl);
        pane2.add(txt);
        pane2.add(sp2);
        pane2.add(btn2);
        pane2.add(btn3);
        pane2.setBorder(titled2);

        /* VENTANA */
        setSize(800, 500);
        setDefaultCloseOperation(Vista.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void conectarContador(Controlador co) {
        btn.addActionListener((ActionListener) co);
        btn.setActionCommand("todo");

        btn2.addActionListener((ActionListener) co);
        btn2.setActionCommand("buscar");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
