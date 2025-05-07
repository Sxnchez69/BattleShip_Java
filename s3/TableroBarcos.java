package s3;

import java.util.ArrayList;
import java.util.Scanner;

public class TableroBarcos {
    Scanner teclado = new Scanner(System.in);
    private ArrayList<Barco> barcos;
    private String[][] tablero_barcos;
    private String[] colores = {
            "\u001B[31m", // Rojo
            "\u001B[32m", // Verde
            "\u001B[33m", // Amarillo
            "\u001B[34m", // Azul
            "\u001B[35m", // Magenta
            "\u001B[36m", // Cyan
            "\u001B[91m", // Rojo claro
            "\u001B[92m", // Verde claro
            "\u001B[93m", // Amarillo claro
            "\u001B[94m"  // Azul claro
    };
    private String reset = "\u001B[0m";


    public TableroBarcos() {
        this.barcos = new ArrayList<>();
        this.tablero_barcos = new String[9][9];

        //Inicializar Tablero
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (i==0){
                    tablero_barcos[i][j] = String.valueOf(j);
                    tablero_barcos[i][0] = " ";
                }else{
                    tablero_barcos[i][j] = "~";
                }
                if(j==0){
                    tablero_barcos[i][j] = String.valueOf(i);
                }
            }
        }

        //Inicializar Barcos
        Barco b1 = new Barco(1);
        barcos.add(b1);
        for (int i=1; i<5; i++) {
            Barco b2_i = new Barco(2);
            barcos.add(b2_i);
        }
        for (int i=1; i<4; i++) {
            Barco b3_i = new Barco(3);
            barcos.add(b3_i);
        }
        for (int i=1; i<3; i++) {
            Barco b5_i = new Barco(5);
            barcos.add(b5_i);
        }
    }

    public void getTablero_barcos() {
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(tablero_barcos[i][j]+"  ");
            }
            System.out.println("");
        }
    }

    public boolean colocarBarco() {

        int fila=0;
        int columna=0;
        int tamaño=0;
        String orientacion;
        System.out.println("Colocando Barcos");

        for(Barco barco: barcos) {
            int colorIndex = barcos.indexOf(barco) % colores.length;
            String color = colores[colorIndex];

            tamaño=barco.getTamaño();

            System.out.println("Barco: "+barco.getTamaño()+" casillas");
            int[] filas = new int[tamaño];
            int[] columnas = new int[tamaño];

            //Orientacion
            do {
                System.out.print("Indique la orientacion: ");
                orientacion = teclado.nextLine();

                if (!orientacion.equalsIgnoreCase("V") && !orientacion.equalsIgnoreCase("Vertical") && !orientacion.equalsIgnoreCase("H") && !orientacion.equalsIgnoreCase("Horizontal")) {
                    System.out.println("Orientacion incorrecta");
                    System.out.println("Orientaciones diponibles: Vertical V, Horizontal H");
                }
                if(orientacion.equalsIgnoreCase("V") || orientacion.equalsIgnoreCase("Vertical")){
                    barco.setOrientacion("V");
                }else if(orientacion.equalsIgnoreCase("H") || orientacion.equalsIgnoreCase("Horizontal")){
                    barco.setOrientacion("H");
                }
            } while (!orientacion.equalsIgnoreCase("V") && !orientacion.equalsIgnoreCase("Vertical") && !orientacion.equalsIgnoreCase("H") && !orientacion.equalsIgnoreCase("Horizontal"));


            boolean ocupado = false;
            int contadorFaltantes = 0;
            do {
                ocupado = false;

                System.out.println("Indique fila y columna: ");
                //Fila
                do {
                    System.out.print("Fila: ");
                    fila = teclado.nextInt();
                    if (fila < 1) {
                        System.out.println("No puedes poner una fila menor que 1");
                    } else if (fila > 8) {
                        System.out.println("No puedes poner una fila mayor que 8");
                    }
                } while (fila < 1 || fila > 8);
                teclado.nextLine();
                //Columna
                do {
                    System.out.print("Columna: ");
                    columna = teclado.nextInt();
                    if (columna < 1) {
                        System.out.println("No puedes poner una columna menor que 1");
                    } else if (columna > 8) {
                        System.out.println("No puedes poner una columna mayor que 8");
                    }
                } while (columna < 1 || columna > 8);
                teclado.nextLine();



                for (Barco b : barcos) {
                    for(int i=0;i<b.getTamaño();i++){
                        if (b.getFila()[i]==fila){
                            ocupado=true;
                        }
                    }
                    for(int i=0;i<b.getColumna().length;i++){
                        if (b.getColumna()[i]==fila){
                            ocupado=true;
                        }
                    }
                }

                //Comprobar ocupacion
//                contadorFaltantes = 0;
//                if (barco.getOrientacion().equals("H")) {
//                    for (int i = 1; i <= tamaño; i++) {
//                        if (columna + i > 8) {
//                            contadorFaltantes++;
//                            if (tablero_barcos[fila][columna - contadorFaltantes].startsWith("/")) {
//                                System.out.println("Posicion ocupada");
//                                ocupado = true;
//                            }
//                        } else if (tablero_barcos[fila][columna + i].startsWith("/")) {
//                            System.out.println("Posicion ocupada");
//                            ocupado = true;
//                        }
//                    }
//                } else if (barco.getOrientacion().equals("V")) {
//                    for (int i = 1; i <= tamaño; i++) {
//                        if (fila + i > 8) {
//                            contadorFaltantes++;
//                            if (tablero_barcos[fila - contadorFaltantes][columna].startsWith("/")) {
//                                System.out.println("Posicion ocupada");
//                                ocupado = true;
//                            }
//                        } else if (tablero_barcos[fila + i][columna].startsWith("/")) {
//                            System.out.println("Posicion ocupada");
//                            ocupado = true;
//                        }
//                    }
//                }
                if(ocupado==true){
                    getTablero_barcos();
                }
            }while(ocupado == true);

            //Colocacion
            contadorFaltantes = 0;
            if (barco.getOrientacion().equals("H")) {
                for (int i = 1; i <= tamaño; i++) {
                    if (columna + i - 1 > 8) {
                        contadorFaltantes++;
                        tablero_barcos[fila][columna - contadorFaltantes] = color + "0" + reset;
                        filas[i - 1] = fila;
                        columnas[i - 1] = columna - contadorFaltantes;
                    } else {
                        tablero_barcos[fila][columna + i - 1] = color + "0" + reset;
                        filas[i - 1] = fila;
                        columnas[i - 1] = columna + i - 1;
                    }
                }
                System.out.println("Barco colocado");
            } else if (barco.getOrientacion().equals("V")) {
                for (int i = 1; i <= tamaño; i++) {
                    if (fila + i - 1 > 8) {
                        contadorFaltantes++;
                        tablero_barcos[fila - contadorFaltantes][columna] = color + "0" + reset;
                        filas[i - 1] = fila - contadorFaltantes;
                        columnas[i - 1] = columna;
                    } else {
                        tablero_barcos[fila + i - 1][columna] = color + "0" + reset;
                        filas[i - 1] = fila + i - 1;
                        columnas[i - 1] = columna;
                    }
                }
            }
            barco.setFila(filas);
            barco.setColumna(columnas);
            System.out.println("Barco colocado");
            getTablero_barcos();
        }
        return true;
    }
}
