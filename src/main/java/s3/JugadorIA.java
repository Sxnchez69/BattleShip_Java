package s3;


import java.util.Random;

public class JugadorIA extends Jugador {
    private Random rand = new Random();

    public JugadorIA(String nombre) {
        super(nombre);
    }

    @Override
    public boolean dispararMisil(TableroBarcos tableroEnemigo) {
        int fila = rand.nextInt(8) + 1;
        int columna = rand.nextInt(8) + 1;

        System.out.println(getNombre() + " (IA) dispara a [" + fila + ", " + columna + "]");
        boolean impacto = tableroEnemigo.recibirDisparoNormal(fila, columna);
        System.out.println("Resultado: " + (impacto ? "¡Impacto!" : "Agua..."));
        return impacto;
    }

    public void colocarBarcosAleatoriamente() {
        tb.colocarBarcoIA();
    }
}
