package s3;

public class Barco {
    protected String tipo;
    protected int tamaño;
    protected String orientacion;
    protected boolean[] estado_barco;
    protected int[] fila;
    protected int[] columna;

    /**
     *
     * @param tamaño Número de casillas que ocupa el barco
     * @param fila Fila en la que se ubica el barco
     * @param columna Columna en la que se ubica el barco
     * @param orientacion La orientación con la que se colocó el barco
     */
    public Barco(int tamaño,int[] fila,int[] columna,String orientacion) {
        this.tipo = "Barco";
        this.tamaño = tamaño;
        this.estado_barco = new boolean[tamaño];
        this.fila = fila;
        this.columna = columna;
        this.orientacion = orientacion;
    }

    /**
     *
     * @param tamaño Número de casillas que ocupa el barco
     */
    public Barco(int tamaño){
        this.tamaño=tamaño;
        this.estado_barco = new boolean[tamaño];
    }

    /**
     *
     * @return Devuelve el tamaño del barco
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     *
     * @param tamaño Número de casillas que ocupa el barco
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     *
     * @return Devuelve la orientación del barco
     */
    public String getOrientacion() {
        return orientacion;
    }

    /**
     *
     * @param orientacion Orientación del barco
     */
    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    /**
     *
     * @return Devuelve el estado del barco (si se encuentra dañado o no)
     */
    public boolean[] getEstado_barco() {
        return estado_barco;
    }

    /**
     *
     * @param estado_barco Estado del barco
     */
    public void setEstado_barco(boolean[] estado_barco) {
        this.estado_barco = estado_barco;
    }

    /**
     *
     * @return Devuelve la fila donde se ubica el barco
     */
    public int[] getFila() {
        return fila;
    }

    /**
     *
     * @param fila Fila en la que se encuantra el barco
     */
    public void setFila(int[] fila) {
        this.fila = fila;
    }

    /**
     *
     * @return Delvuelve la columna en la que se encuantra el barco
     */
    public int[] getColumna() {
        return columna;
    }

    /**
     *
     * @param columna Columna en la que se encuentra el barco
     */
    public void setColumna(int[] columna) {
        this.columna = columna;
    }
}
