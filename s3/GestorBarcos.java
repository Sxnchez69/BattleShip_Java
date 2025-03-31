package s3;

import java.util.ArrayList;

public class GestorBarcos {
    private ArrayList<Barco> barcos;
    private ArrayList<Submarino> submarinos;
    private int[][] tablero_barcos;
    private int[][] tablero_submarino;

    public GestorBarcos() {
        this.barcos = new ArrayList<>();
        this.submarinos = new ArrayList<>();
        this.tablero_barcos = new int[8][8];
        this.tablero_submarino = new int[8][8];

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

    }
    public ArrayList<Submarino> getSubmarinos() {
        return submarinos;
    }
    public ArrayList<Barco> getBarcos() {
        return barcos;
    }
}
