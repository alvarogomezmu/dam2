package EscribirFichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            // Abrimos el buffer
            BufferedWriter escribir = new BufferedWriter(new FileWriter("b.txt", true));

            for (int i = 0; i < 3; i++) {
                escribir.write("eje" + i);

            }
            escribir.close();
        } catch (IOException e) {
            System.out.println("Epic Fail");
        }
    }
}
