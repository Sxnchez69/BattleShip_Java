public class Barco {
    protected String tipo;
    protected int[] tamaño;
    protected String orientacion;
    protected int[][] posicion_barco;
    protected boolean[][] estado_barco;

    public Barco(int[] tamaño, String orientacion, int fila, int columna) {
        this.orientacion = orientacion;
        this.tipo = "Barco";
        this.tamaño = tamaño;
        this.posicion_barco = new int[fila][columna];
        for (int i = 0; i < posicion_barco.length; i++) {
            for (int j = 0; j < posicion_barco[i].length; j++) {
                this.estado_barco[i][j] = false;
            }
        }
    }

    public int[] getTamaño() {
        return tamaño;
    }

    public void setTamaño(int[] tamaño) {
        this.tamaño = tamaño;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public int[][] getPosicion_barco() {
        return posicion_barco;
    }

    public void setPosicion_barco(int[][] posicion_barco) {
        this.posicion_barco = posicion_barco;
    }

    public boolean[][] getEstado_barco() {
        return estado_barco;
    }

    public void setEstado_barco(boolean[][] estado_barco) {
        this.estado_barco = estado_barco;
    }

}
