package s3;


import java.util.ArrayList;
import java.util.Random;

public class JugadorIA extends Jugador {
    private Random rand = new Random();
    private boolean[][] posiciones;

    /**
     *
     * @param nombre Nombre del jugador consola
     */
    public JugadorIA(String nombre) {
        super(nombre);
        posiciones = new boolean[9][9];

    }

    /**
     *
     * @param tableroEnemigo Tablero del rival de una partida
     * @return Devuelve la posición deonde se lanó un misil aleatoriamente
     */
    @Override
    public boolean dispararMisil(TableroBarcos tableroEnemigo) {
        int fila=0;
        int columna=0;
        do {
            fila = rand.nextInt(8) + 1;
            columna = rand.nextInt(8) + 1;
        }while(posiciones[fila][columna]==true);
        posiciones[fila][columna]=true;
        System.out.println(getNombre() + " dispara a [" + fila + ", " + columna + "]");
        boolean impacto = tableroEnemigo.recibirDisparoNormal(fila, columna);
        return impacto;
    }

    /**
     * La consola coloca sus barcos aleatoriamente en el tablero
     */
    public void colocarBarcosAleatoriamente() {
        tb.colocarBarcoIA();
    }
}
