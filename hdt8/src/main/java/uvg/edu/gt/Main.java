package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación para manejar una cola de emergencias.
 * Esta aplicación lee un archivo de texto con información sobre pacientes,
 * los inserta en un montículo (heap) según su prioridad de emergencia y luego los atiende en orden.
 */
public class Main {
    /**
     * Método principal que ejecuta la aplicación.
     * 
     * Lee un archivo "pacientes.txt" ubicado en el directorio "hdt8" del proyecto. Cada línea del archivo
     * debe contener los datos de un paciente, separados por comas en el formato: nombre, síntoma, código de emergencia.
     * Los pacientes se insertan en una cola de prioridad implementada mediante un montículo (heap),
     * y se atienden en orden según su prioridad.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();

        try {
            File archivoPacientes = new File("hdt8/pacientes.txt");
            Scanner lectorArchivo = new Scanner(archivoPacientes);
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                // Asegúrate de que el split se hace correctamente
                String[] datosPaciente = linea.split(", ");
                if (datosPaciente.length == 3) {
                    Paciente paciente = new Paciente(datosPaciente[0], datosPaciente[1], datosPaciente[2].charAt(0));
                    colaEmergencias.insert(paciente);
                }
            }
            lectorArchivo.close();
        } catch (Exception e) {
            System.out.println("No se encontró el archivo pacientes.txt");
            e.printStackTrace();
            return;
        }
        System.out.println("Atendiendo a los pacientes en orden de prioridad:");
        while (!colaEmergencias.isEmpty()) {
            Paciente pacienteAtendido = colaEmergencias.remove();
            System.out.println("Atendido a: " + pacienteAtendido.getNombre() + " - " + pacienteAtendido.getSintoma() + " - Prioridad: " + pacienteAtendido.getCodigoEmergencia());
        }
    }
}
