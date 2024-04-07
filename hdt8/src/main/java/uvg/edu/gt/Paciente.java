package uvg.edu.gt;

/**
 * Clase que representa a un paciente. Cada paciente tiene un nombre,
 * un síntoma y un código de emergencia que indica la prioridad del tratamiento.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Constructor para crear un nuevo paciente.
     *
     * @param nombre El nombre del paciente.
     * @param sintoma El síntoma principal del paciente.
     * @param codigoEmergencia El código de emergencia del paciente, indicando la prioridad.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el síntoma del paciente.
     *
     * @return El síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Obtiene el código de emergencia del paciente.
     *
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Compara este paciente con otro para determinar la prioridad de atención.
     * La comparación se basa en los códigos de emergencia de los pacientes.
     *
     * @param otro El otro paciente con el que comparar.
     * @return Un valor negativo si este paciente tiene mayor prioridad, cero si tienen la misma prioridad,
     *         y un valor positivo si el otro paciente tiene mayor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /**
     * Devuelve una representación en cadena de este paciente.
     *
     * @return Una cadena que representa a este paciente, incluyendo nombre, síntoma y código de emergencia.
     */
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", sintoma='" + sintoma + '\'' +
                ", codigoEmergencia=" + codigoEmergencia +
                '}';
    }
}
