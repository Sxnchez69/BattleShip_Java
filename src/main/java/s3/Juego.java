package s3;
import java.util.Scanner;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("");
        System.out.print("Nombre del Jugador 1: ");
        jugador1 = new Jugador(scanner.nextLine());
        System.out.println("");
        System.out.println("== Colocación de barcos de " + jugador1.getNombre());
        jugador1.tb.colocarBarco();
        limpiarPantalla();

        System.out.print("Nombre del Jugador 2: ");
        jugador2 = new Jugador(scanner.nextLine());
        System.out.println("");

        System.out.println("== Colocación de barcos de " + jugador2.getNombre());
        jugador2.tb.colocarBarco();
        limpiarPantalla();

        // Turnos
        boolean jugando = true;
        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (jugando) {
            System.out.println("Turno de " + actual.getNombre());
            actual.dispararMisil(oponente.tb);
            oponente.tb.getTablero_barcos_juego();
            System.out.println("");
            System.out.println("");


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
        System.out.println("");
        System.out.println("== Colocación de barcos de " + jugador1.getNombre());
        jugador1.tb.colocarBarco();
        limpiarPantalla();

        jugador2 = new JugadorIA("CHATGPT2000(IA)");
        System.out.println("== Colocación de barcos de " + jugador2.getNombre());
        jugador2.tb.colocarBarcoIA();
        limpiarPantalla();
        System.out.println("");
        // Turnos
        boolean jugando = true;
        Jugador actual = jugador1;
        Jugador oponente = jugador2;

        while (jugando) {
            boolean disparoValido = true;
            System.out.println("Turno de " + actual.getNombre());
            do {
                disparoValido = actual.dispararMisil(oponente.tb);
            }while (disparoValido == false);
            oponente.tb.getTablero_barcos_juego();
            System.out.println("");



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
    private static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
