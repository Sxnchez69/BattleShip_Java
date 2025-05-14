import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import s3.Barco;
import s3.TableroBarcos;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class TableroBarcosTest extends TableroBarcos{
    private TableroBarcos tablero; // Asumimos que tu clase se llama así

    @BeforeEach
    void setUp() {
        tablero = new TableroBarcos(); // O el nombre real de tu clase

        // Inicializa el tablero de barcos
        tablero.tablero_barcos = new String[9][9]; // tamaño ejemplo
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                tablero.tablero_barcos[i][j] = "-"; // vacío

        // Simula un barco en posición [3][4]
        tablero.tablero_barcos[3][4] = "0";

        Barco barco = new Barco(2);
        barco.setFila(new int[]{3});
        barco.setColumna(new int[]{4});
        barco.setEstado_barco(new boolean[]{false});

        ArrayList<Barco> barcos = new ArrayList<>();
        barcos.add(barco);
        tablero.barcos = barcos;
    }

    @Test
    void testDisparoNormal() {
        boolean resultado = tablero.recibirDisparoNormal(3, 4);

        assertTrue(resultado); // El disparo da en el barco
//        assertEquals("X", tablero.tablero_barcos()[3][4]); // Debe marcarse como tocado
//        assertTrue(tablero.barcos.get(0).getEstado_barco()[0]); // El estado del barco debe cambiar
    }
}
