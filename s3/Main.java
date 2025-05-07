package s3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jugador j1 = new Jugador("SUPERPITO");
        Jugador j2 = new Jugador("JUGADOR");
        j1.tb.colocarBarco();

    }
}
