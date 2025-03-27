import java.util.Scanner;

public class Misil {
    private int fila;
    private int columna;

    private int[][] area;

    public Misil(int fila, int columna, int[][] area) {
        this.fila = fila;
        this.columna = columna;
        this.area = area;
    }

    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int[][] getArea() {
        return area;
    }
    public void setArea(int[][] area) {
        this.area = area;
    }

    public int[][] lanzarMisil(Scanner teclado){
        System.out.println("============");
        System.out.println("Lanzar misil");
        System.out.println("============");
        System.out.println("Indica la fila: ");
        fila = teclado.nextInt();
        System.out.println("Indica la columna: ");
        columna = teclado.nextInt();
        return new int[fila][columna];
    }

    public void misilGrande(Scanner teclado){
        if (barco.getTamaño == 1){
            if (barco.Dañado == true){

            }
        }
    }
}
