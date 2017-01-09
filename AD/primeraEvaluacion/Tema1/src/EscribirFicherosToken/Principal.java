package EscribirFicherosToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author AlumnoT
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Apertura del Buffer para que se genere la comunicacion
        BufferedWriter esc = new BufferedWriter(new FileWriter("eje.txt"));
        // Apertura del buffer para coger todo lo que estoy leyendo y se guarde en teclado
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 2; i++) {
            System.out.println("Formato. Para el primero = nombre@edad@sexo. Para el resto @nombre@edad@sexo");
            // Cuando leemos por teclado vamos a tener en cuenta el token que hemos marcado, en este caso el @, 
            // de este modo, cuando lleguemos a un token lo saltaremos para seguir leyendo
            StringTokenizer st = new StringTokenizer(teclado.readLine(), "@");
            while (st.hasMoreTokens()) {
                esc.write(st.nextToken());
            }
            esc.newLine();

        }
        esc.close();
    }

}
