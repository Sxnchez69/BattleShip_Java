package s3;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Estadisticas {
    /**
     *
     * @param jugador Nombre del jugador de una partida
     * @param tipoPartida El tipo de partida puede ser contra otro jugador o contra la propia consola
     * @param victoria Indica si el jugador ha ganado o no
     * @param turnos Indica los turnos totales de la partida
     */
    public static void guardarEstadistica(String jugador, String tipoPartida, boolean victoria, int turnos) {
        try (FileWriter writer = new FileWriter("Estadisticas.txt", true)) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String fecha = ahora.format(formatter);

            writer.write("Ganador: " + jugador +
                    ", Rival: " + tipoPartida +
                    ", Turnos: " + turnos +
                    ", Fecha: " + fecha + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar estadísticas: " + e.getMessage());
        }
    }

    /**
     * Se muestra el historial de partidas
     */
    public static void mostrarEstadisticas() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Estadisticas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudieron leer las estadísticas.");
        }
    }
}

