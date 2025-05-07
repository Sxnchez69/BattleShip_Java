package s3;

public class Submarino extends Barco{


    public Submarino(int tamaño,int[] fila,int[] columna,String orientacion) {
        super(tamaño, fila, columna, orientacion);
        super.tipo="Submarino";
    }

}
