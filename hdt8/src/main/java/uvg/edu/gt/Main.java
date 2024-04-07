package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();

        try {
            File archivoPacientes = new File("pacientes.txt");
            Scanner lectorArchivo = new Scanner(archivoPacientes);
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                String[] datosPaciente = linea.split(",");
                if (datosPaciente.length == 3) {
                    Paciente paciente = new Paciente(datosPaciente[0], datosPaciente[1], datosPaciente[2].charAt(0));
                    colaEmergencias.insert(paciente);
                }
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo pacientes.txt");
            e.printStackTrace();
            return;
        }
        System.out.println("Atendiendo a los pacientes en orden de prioridad:");
        while (!colaEmergencias.isEmpty()) {
            Paciente pacienteAtendido = colaEmergencias.remove();
            System.out.println("Atendido a: " + pacienteAtendido.getNombre() + " _ " + pacienteAtendido.getSintoma() + " (Prioridad: " + pacienteAtendido.getCodigoEmergencia() + ")");
        }
    }
}
