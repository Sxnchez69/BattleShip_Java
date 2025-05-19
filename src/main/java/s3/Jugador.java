package s3;

public class Jugador {
    private String nombre;
    protected TableroBarcos tb;

    /**
     *
     * @param nombre Nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tb = new TableroBarcos();
    }

    /**
     *
     * @return Delvuelve el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre Nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param tableroEnemigo Tablero del rival de una partida
     * @return Devuelve la posición donde se ha lanzado un misil
     */
    public boolean dispararMisil(TableroBarcos tableroEnemigo) {
        Misil misil = new Misil();
        boolean impacto = false;
        do {
            int[] coordenadas = misil.lanzarMisil();
            int fila = coordenadas[0];
            int columna = coordenadas[1];
            impacto = tableroEnemigo.recibirDisparoNormal(fila, columna);
        } while (!impacto);
        return impacto;
    }

//    public boolean dispararMisilGordo(TableroBarcos tableroEnemigo) {
//        Misil misil = new Misil();
//        int[] coordenadas = misil.lanzarMisil();
//        int fila = coordenadas[0];
//        int columna = coordenadas[1];
//
//        boolean impacto = tableroEnemigo.recibirDisparoGordo(fila, columna);
//        return impacto;
//    }

}
