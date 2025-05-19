package s3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Misil {
    Scanner teclado = new Scanner(System.in);
    private int fila;
    private int columna;
    private boolean[][] posiciones;

    private int[][] area;
    public Misil() {
        this.fila = fila;
        this.columna = columna;
        this.area = area;
        this.posiciones = new boolean[9][9];
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


    public int[] lanzarMisil(){

        System.out.println("============");
        System.out.println("Lanzar misil");
        System.out.println("============");
        // fila
        int fila=0;
        int columna=0;
        do {



        do {
            boolean valido = false;
            do {
                System.out.print("Fila (1 a 8): ");
                try {
                    fila = teclado.nextInt();
                    valido = false;
                } catch (InputMismatchException e) {
                    System.out.println("Valor No Válido");
                    valido = true;
                    teclado.nextLine();
                }
            }while (valido==true);
            if (fila < 1 || fila > 8) {
                System.out.println("Fila fuera de rango.");
            }
        } while (fila < 1 || fila > 8);

        // columna
        do {
            boolean valido = false;
            do {
                System.out.print("Columna (1 a 8): ");
                try {
                    columna = teclado.nextInt();
                    valido = false;
                } catch (InputMismatchException e) {
                    System.out.println("Valor No Válido");
                    valido = true;
                    teclado.nextLine();
                }
            }while (valido==true);
            if (columna < 1 || columna > 8) {
                System.out.println("Columna fuera de rango.");
            }
        } while (columna < 1 || columna > 8);
        }while(posiciones[fila][columna]==true);
        posiciones[fila][columna]=true;
        teclado.nextLine();
        return new int[]{fila, columna};
    }
}
