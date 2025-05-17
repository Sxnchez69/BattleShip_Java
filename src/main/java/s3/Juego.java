package s3;
import java.util.Scanner;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.print("Nombre del Jugador 1: ");
        jugador1 = new Jugador(scanner.nextLine());

        System.out.print("Nombre del Jugador 2: ");
        jugador2 = new Jugador(scanner.nextLine());

        System.out.println("== Colocación de barcos de " + jugador1.getNombre());
        jugador1.tb.colocarBarco();

        System.out.println("== Colocación de barcos de " + jugador2.getNombre());
        jugador2.tb.colocarBarco();

        // Turnos
        boolean jugando = true;
        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (jugando) {
            System.out.println("Turno de " + actual.getNombre());
            actual.dispararMisil(oponente.tb);
            oponente.tb.getTablero_barcos();


            if (estanTodosHundidos(oponente)) {
                System.out.println(actual.getNombre() + " ha ganado la partida!");
                jugando = false;
            }

            // Cambiar turnos
            Jugador temp = actual;
            actual = oponente;
            oponente = temp;
        }
    }

    public boolean estanTodosHundidos(Jugador jugador) {
        for (Barco barco : jugador.tb.barcos) {
            boolean[] estado = barco.getEstado_barco();
            for (boolean parte : estado) {
                if (!parte) return false;
            }
        }
        return true;
    }

    public void iniciarIA() {
        System.out.print("Nombre del Jugador: ");
        jugador1 = new Jugador(scanner.nextLine());

        jugador2 = new JugadorIA("CHATGPT2000(IA)");

        System.out.println("== Colocación de barcos de " + jugador1.getNombre());
        jugador1.tb.colocarBarco();

        System.out.println("== Colocación de barcos de " + jugador2.getNombre());
        jugador2.tb.colocarBarcoIA();

        // Turnos
        boolean jugando = true;
        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (jugando) {
            System.out.println("Turno de " + actual.getNombre());
            actual.dispararMisil(oponente.tb);
            oponente.tb.getTablero_barcos();


            if (estanTodosHundidos(oponente)) {
                System.out.println(actual.getNombre() + " ha ganado la partida!");
                jugando = false;
            }

            // Cambiar turnos
            Jugador temp = actual;
            actual = oponente;
            oponente = temp;
        }
    }
}
