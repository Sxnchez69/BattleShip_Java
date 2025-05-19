package s3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion;
        do {
            opcion=0;
            Juego juego = new Juego();
            Scanner teclado = new Scanner(System.in);

            System.out.println("=======================================");
            System.out.println("===           BATTLESHIP           ====");
            System.out.println("=======================================");
            System.out.println();

            System.out.println("                 __/___            ");
            System.out.println("           _____/______|           ");
            System.out.println("   _______/____\\_______\\_____     ");
            System.out.println("   \\               < < <       |   ");
            System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();

            System.out.println("=======================================");
            System.out.println("===         MENÚ PRINCIPAL          ===");
            System.out.println("=======================================");
            System.out.println("1. Jugador vs IA");
            System.out.println("2. 2 Jugadores");
            System.out.println("3. Ver estadísticas");
            System.out.println("4. Salir");
            System.out.println("=======================================");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            do {
                switch (opcion) {
                    case 1: {
                        juego.iniciarIA();
                        break;
                    }
                    case 2: {
                        juego.iniciar();
                        break;
                    }
                    case 3: {
                        Estadisticas.mostrarEstadisticas();
                        break;
                    }
                    case 4: {
                        System.out.println("Saliendo....");
                        break;
                    }
                    default: {
                        System.out.println("Opcion no valida");
                        break;
                    }
                }
            }while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
        }while (opcion != 4);


    }
}
