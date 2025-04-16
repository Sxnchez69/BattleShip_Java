package s3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorBarcos g1 = new GestorBarcos();
        Misil m1 = new Misil();

//        g1.colocarBarco(3);
//        g1.getTablero_barcos();
//
//        g1.colocarSubmarino(2);
//        g1.getTablero_submarino();
//
//        g1.colocarSubmarino(2);
//        g1.getTablero_submarino();
        m1.lanzarMisil();
    }
}
