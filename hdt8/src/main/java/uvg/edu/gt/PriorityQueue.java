package uvg.edu.gt;

public interface PriorityQueue<E extends Comparable<E>> {
    /**
     * Inserta un elemento en la cola con prioridad.
     * @param item El elemento a insertar.
     */
    void insert(E item);

    /**
     * Elimina y devuelve el elemento con mayor prioridad.
     * @return El elemento con mayor prioridad.
     */
    E remove();

    /**
     * Devuelve (sin eliminar) el elemento con mayor prioridad.
     * @return El elemento con mayor prioridad.
     */
    E peek();

    /**
     * Comprueba si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Devuelve el número de elementos en la cola.
     * @return El número de elementos en la cola.
     */
    int size();

    /**
     * Limpia la cola, eliminando todos los elementos.
     */
    void clear();
}
