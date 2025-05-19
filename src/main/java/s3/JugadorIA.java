package s3;


import java.util.ArrayList;
import java.util.Random;

public class JugadorIA extends Jugador {
    private Random rand = new Random();

    private boolean[][] posiciones;
    public JugadorIA(String nombre) {
        super(nombre);

    }

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

    public void colocarBarcosAleatoriamente() {
        tb.colocarBarcoIA();
    }
}
