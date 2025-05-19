package s3;

public class Jugador {
    private String nombre;
    protected TableroBarcos tb;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tb = new TableroBarcos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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



}
