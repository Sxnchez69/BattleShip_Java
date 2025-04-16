package s3;
import java.util.Scanner;
public class Misil {
    Scanner teclado = new Scanner(System.in);
    private int fila;
    private int columna;

    private int[][] area;
    public Misil() {
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

    public void inventario(){
        System.out.println("MISILES DISPONIBLES");
        System.out.println("1. Misil de 1x1 casillas");
        if (misilGrande() == true){

            System.out.println("2. Misil de 3x3 casillas");
        }
    }
    public int[] lanzarMisil(){
        int opcion;
        inventario();
        System.out.println("============");
        System.out.println("Lanzar misil");
        System.out.println("============");
        do {
            System.out.println("Indeica qué misil desea Lanzar: ");
            opcion = teclado.nextInt();
            if (opcion == 1){
                System.out.println("Se lanzará un misil de 1x1 casillas");
            }
            else if (opcion == 2){
                System.out.println("Se lanzará un misil de 3x3 casillas");
            }
            else{
                System.out.println("ERROR: Opción no válida");
            }
        } while (opcion != 1 && opcion != 2);
        System.out.println("Indica la fila: ");
        fila = teclado.nextInt();
        System.out.println("Indica la columna: ");
        columna = teclado.nextInt();
        return new int[]{fila, columna};
    }

    public boolean misilGrande(){
        GestorBarcos gb = new GestorBarcos();
        for (Barco b : gb.getBarcos()){
            if (b.getTamaño() == 1){
                if (b.getEstado_barco().equals(true)){
                    return true;
                }
            }
        }
        return false;
    }
}
