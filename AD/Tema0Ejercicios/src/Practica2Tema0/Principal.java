/**
 * Crear una clase PartidoFutbol que contenga los siguientes atributos y los
 * métodos pertinentes: equipoLocal; Nombre del equipo que juega de Local
 * equipoVisitante; Nombre del equipo que juega como Visitante golesLocal;
 * Número de goles golesVisitante; Número de goles
 */
/**
 *
 * Crear un main que nos muestre los datos de todos estos atributos y nos diga
 * si ha ganado el equipo local o el Visitante Por ejemplo: Resultados de los
 * partidos de Futbol... Real Sociedad 3-2 Barcelona Ha ganado el equipo local
 * Real Sociedad Real Madrid 7-6 Barcelona Ha ganado el equipo local Real Madrid
 * Podemos tener partidos repetidos. Usa la estructura que creas mejor. Recuerda
 * que en éste caso si tienes que recorrer la estructura (iterator) debes usar
 * el método y si es necesario adaptarlo a tus necesidades.
 */
package Practica2Tema0;

import java.util.ArrayList;
import Herramientas.*;
import java.util.Iterator;

/**
 *
 * @author Alvaro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Resultado de los partidos de futbol... ");
        ArrayList<PartidoFutbol> partidos = new ArrayList();

        partidos.add(new PartidoFutbol("Real Madrid", "Barcelona", 5, 2));
        partidos.add(new PartidoFutbol("Betis", "Rayo Vallecano", 3, 3));
        partidos.add(new PartidoFutbol("Sevilla", "Deportivo", 1, 0));
        partidos.add(new PartidoFutbol("Celta", "Atleti", 2, 3));
        partidos.add(new PartidoFutbol("Barcelona", "Real Madrid", 4, 4));

        PartidoFutbol.ganador(partidos);
    }

}
