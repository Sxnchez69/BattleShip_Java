package s3;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorBarcos {
    Scanner teclado = new Scanner(System.in);
    private ArrayList<Barco> barcos;
    private ArrayList<Submarino> submarinos;
    private String[][] tablero_barcos;
    private String[][] tablero_submarino;

    public GestorBarcos() {
        this.barcos = new ArrayList<>();
        this.submarinos = new ArrayList<>();
        this.tablero_barcos = new String[8][8];
        this.tablero_submarino = new String[8][8];

        Barco b1 = new Barco(1);
        Barco b2_1 = new Barco(2);
        Barco b2_2 = new Barco(2);
        Barco b2_3 = new Barco(2);
        Barco b2_4 = new Barco(2);
        Barco b3_1 = new Barco(3);
        Barco b3_2 = new Barco(3);
        Barco b3_3 = new Barco(3);
        Barco b5_1 = new Barco(5);
        Barco b5_2 = new Barco(5);

        Submarino s2_1= new Submarino(2);
        Submarino s2_2= new Submarino(2);
        Submarino s2_3= new Submarino(2);
        Submarino s2_4= new Submarino(2);
        Submarino s2_5= new Submarino(2);
        Submarino s3_1= new Submarino(3);
        Submarino s3_2= new Submarino(3);
        Submarino s3_3= new Submarino(3);

        barcos.add(b1);
        barcos.add(b2_1);
        barcos.add(b2_2);
        barcos.add(b2_3);
        barcos.add(b2_4);
        barcos.add(b3_1);
        barcos.add(b3_2);
        barcos.add(b3_3);
        barcos.add(b5_1);
        barcos.add(b5_2);
        submarinos.add(s2_1);
        submarinos.add(s2_2);
        submarinos.add(s2_3);
        submarinos.add(s2_4);
        submarinos.add(s2_5);
        submarinos.add(s3_1);
        submarinos.add(s3_2);
        submarinos.add(s3_3);

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                tablero_barcos[i][j] = "~";
            }
        }

        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                tablero_submarino[i][j] = "-";
            }
        }

    }
    public ArrayList<Submarino> getSubmarinos() {
        return submarinos;
    }
    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public void getTablero_barcos() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(tablero_barcos[i][j]+"  ");
            }
            System.out.println("");
        }
    }

    public void getTablero_submarino() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                System.out.print(tablero_submarino[i][j]+"  ");
            }
            System.out.println("");
        }
    }

    public boolean colocarBarco(int tamaño) {
        int fila=0;
        int columna=0;
        String orientacion;
        System.out.println("Colocando Barco");


        do {
            System.out.print("Indique la orientacion: ");
            orientacion = teclado.nextLine();

            if (!orientacion.equalsIgnoreCase("V")&&!orientacion.equalsIgnoreCase("Vertical")&&!orientacion.equalsIgnoreCase("H")&&!orientacion.equalsIgnoreCase("Horizontal")){
                System.out.println("Orientacion incorrecta");
                System.out.println("Orientaciones diponibles: Vertical V, Horizontal H");
            }
        }while(!orientacion.equalsIgnoreCase("V")&&!orientacion.equalsIgnoreCase("Vertical")&&!orientacion.equalsIgnoreCase("H")&&!orientacion.equalsIgnoreCase("Horizontal"));


        System.out.println("Indique fila y columna: ");
        do {
            System.out.print("Fila: ");
            fila = teclado.nextInt();
            if (fila<1) {
                System.out.println("No puedes poner una fila menor que 1");
            } else if (fila>8) {
                System.out.println("No puedes poner una fila mayor que 8");
            }
        }while(fila<1 || fila>8);
        teclado.nextLine();

        do {
            System.out.print("Columna: ");
            columna = teclado.nextInt();
            if (columna<1) {
                System.out.println("No puedes poner una columna menor que 1");
            } else if (columna>8) {
                System.out.println("No puedes poner una columna mayor que 8");
            }
        }while(columna<1 || columna>8);
        teclado.nextLine();

        //Comprobar ocupacion
        if (orientacion.equalsIgnoreCase("H")||orientacion.equalsIgnoreCase("Horizontal")) {
            for(int i=1; i<=tamaño;i++){
                if (tablero_barcos[fila-1][columna+i-2].equals("0")) {
                    System.out.println("Posicion ocupada");
                    return false;
                }
            }
        } else if (orientacion.equalsIgnoreCase("V")||orientacion.equalsIgnoreCase("Vertical")) {
            for(int i=1; i<=tamaño;i++){
                if (tablero_barcos[fila+i-2][columna-1].equals("0")) {
                    System.out.println("Posicion ocupada");
                    return false;
                }
            }
        }

        //Colocacion
        if (orientacion.equalsIgnoreCase("H")||orientacion.equalsIgnoreCase("Horizontal")) {
            for(int i=1; i<=tamaño;i++){
                tablero_barcos[fila-1][columna+i-2]="0";
            }
            System.out.println("Barco colocado");
        } else if (orientacion.equalsIgnoreCase("V")||orientacion.equalsIgnoreCase("Vertical")) {
            for(int i=1; i<=tamaño;i++){
                tablero_barcos[fila+i-2][columna-1]="0";
            }
            System.out.println("Barco colocado");
        }

        return true;

    }

    public boolean colocarSubmarino(int tamaño) {
        int fila=0;
        int columna=0;
        String orientacion;
        System.out.println("Colocando Submarino");


        do {
            System.out.print("Indique la orientacion: ");
            orientacion = teclado.nextLine();

            if (!orientacion.equalsIgnoreCase("V")&&!orientacion.equalsIgnoreCase("Vertical")&&!orientacion.equalsIgnoreCase("H")&&!orientacion.equalsIgnoreCase("Horizontal")){
                System.out.println("Orientacion incorrecta");
                System.out.println("Orientaciones diponibles: Vertical V, Horizontal H");
            }
        }while(!orientacion.equalsIgnoreCase("V")&&!orientacion.equalsIgnoreCase("Vertical")&&!orientacion.equalsIgnoreCase("H")&&!orientacion.equalsIgnoreCase("Horizontal"));


        System.out.println("Indique fila y columna: ");
        do {
            System.out.print("Fila: ");
            fila = teclado.nextInt();
            if (fila<1) {
                System.out.println("No puedes poner una fila menor que 1");
            } else if (fila>8) {
                System.out.println("No puedes poner una fila mayor que 8");
            }
        }while(fila<1 || fila>8);
        teclado.nextLine();

        do {
            System.out.print("Columna: ");
            columna = teclado.nextInt();
            if (columna<1) {
                System.out.println("No puedes poner una columna menor que 1");
            } else if (columna>8) {
                System.out.println("No puedes poner una columna mayor que 8");
            }
        }while(columna<1 || columna>8);
        teclado.nextLine();

        //Comprobar ocupacion
        if (orientacion.equalsIgnoreCase("H")||orientacion.equalsIgnoreCase("Horizontal")) {
            for(int i=1; i<=tamaño;i++){
                if (tablero_submarino[fila-1][columna+i-2].equals("0")) {
                    System.out.println("Posicion ocupada");
                    return false;
                }
            }
        } else if (orientacion.equalsIgnoreCase("V")||orientacion.equalsIgnoreCase("Vertical")) {
            for(int i=1; i<=tamaño;i++){
                if (tablero_submarino[fila+i-2][columna-1].equals("0")) {
                    System.out.println("Posicion ocupada");
                    return false;
                }
            }
        }

        //Colocacion
        if (orientacion.equalsIgnoreCase("H")||orientacion.equalsIgnoreCase("Horizontal")) {
            for(int i=1; i<=tamaño;i++){
                tablero_submarino[fila-1][columna+i-2]="0";
            }
            System.out.println("Submarino colocado");
        } else if (orientacion.equalsIgnoreCase("V")||orientacion.equalsIgnoreCase("Vertical")) {
            for(int i=1; i<=tamaño;i++){
                tablero_submarino[fila+i-2][columna-1]="0";
            }
            System.out.println("Submarino colocado");
        }

        return true;

    }
    public boolean comprobarEstadoBarcos(){
        Misil misil = new Misil();
        int[] coordenadas = misil.lanzarMisil();
        int filaMisil = coordenadas[0];
        int columnaMisil = coordenadas[1];

        for (Barco barco : barcos) {
            if (barco.getFila() == filaMisil && barco.getColumna() == columnaMisil) {
                System.out.println("¡Se ha dañado un barco!");
                return true;
            }
        }
        System.out.println("Se lanzó un misil al agua");
        return false;
    }
}
