package s3;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Misil {
    Scanner teclado = new Scanner(System.in);
    private int fila;
    private int columna;
    private boolean[][] posiciones;
    private int[][] area;

    /**
     * Constructor de un Misil
     */
    public Misil() {
        this.fila = fila;
        this.columna = columna;
        this.area = area;
        this.posiciones = new boolean[9][9];
    }

    /**
     *
     * @return Devuelve la fila donde se lanzará un misil
     */
    public int getFila() {
        return fila;
    }

    /**
     *
     * @param fila Fila donde se lanza un misil
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *
     * @return Devuelve la columna donde se lanzará en misil
     */
    public int getColumna() {
        return columna;
    }

    /**
     *
     * @param columna Columna en la que se lanza un misil
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     *
     * @return Devuelve el área que abarca un misil
     */
    public int[][] getArea() {
        return area;
    }

    /**
     *
     * @param area Área que abarca un misil
     */
    public void setArea(int[][] area) {
        this.area = area;
    }

    /**
     *
     * @return Devuelve la fila y columna donde se lanzará un misil
     */
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
            if (posiciones[fila][columna]) {
                System.out.println("Ya has disparado en la posición" + fila + ", "+columna +". Intenta con otra.");
            }
        }while(posiciones[fila][columna]==true);
        posiciones[fila][columna]=true;
        teclado.nextLine();
        return new int[]{fila, columna};
    }
}
