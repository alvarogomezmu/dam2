/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorios;

/**
 *
 * @author Alvaro
 */
public class Herramientas {
    public static String ConvertUTF(String txt, int largo) {
        String s = txt;
        // Si la longitud del String es mayor que el integer asociado
        // Devuelve un substring del String dado
        if (s.length() > largo) {
            return s.substring(0, largo);
        }
        // Si el String es menor, añadirle espacios en blanco
        for (int n = s.length(); n < largo; n++) {
            s = s + " ";
        }
        return s;
    }
}
