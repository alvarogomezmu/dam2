package SwingHolaMundo;

import javax.swing.*;

/**
 *
 * @author Alvaro Gomez
 */
public class HolaMundoSwing extends JFrame {

    private JLabel texto1, texto2;

    public static void main(String[] args) {
        HolaMundoSwing ventana = new HolaMundoSwing();
        ventana.setBounds(400, 100, 300, 200);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }

    public HolaMundoSwing() {
        setLayout(null);
        texto1 = new JLabel("Sistema de facturacion");
        texto2 = new JLabel("Version 1.0");
        texto1.setBounds(10, 25, 200, 40);
        texto2.setBounds(10, 100, 200, 40);
        add(texto1);
        add(texto2);
    }

}
