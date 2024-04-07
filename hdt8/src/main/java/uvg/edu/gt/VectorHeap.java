package uvg.edu.gt;

import java.util.ArrayList;

/**
 * Implementación de un montículo (heap) mínimal basado en un vector para una cola de prioridad.
 * Esta estructura de datos organiza los elementos de manera que el más pequeño siempre sea el primero,
 * facilitando su acceso y extracción.
 *
 * @param <E> El tipo de elementos que la cola de prioridad va a manejar. Debe ser una clase que implementa Comparable.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> heap;

    /**
     * Constructor que inicializa el vector (ArrayList) que almacenará los elementos del montículo.
     */
    public VectorHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Calcula el índice del padre de un elemento dado su índice.
     *
     * @param i El índice del elemento.
     * @return El índice del padre del elemento.
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un elemento dado su índice.
     *
     * @param i El índice del elemento.
     * @return El índice del hijo izquierdo del elemento.
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un elemento dado su índice.
     *
     * @param i El índice del elemento.
     * @return El índice del hijo derecho del elemento.
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Realiza el proceso de subir en el montículo para mantener la propiedad de montículo mínimal.
     *
     * @param i El índice del elemento que se está subiendo.
     */
    private void percolateUp(int i) {
        E item = heap.get(i);
        while (i > 0 && item.compareTo(heap.get(parent(i))) < 0) {
            heap.set(i, heap.get(parent(i)));
            i = parent(i);
        }
        heap.set(i, item);
    }

    /**
     * Realiza el proceso de bajar en el montículo para mantener la propiedad de montículo mínimal.
     *
     * @param i El índice del elemento que se está bajando.
     */
    private void percolateDown(int i) {
        int child;
        E tmp = heap.get(i);
        for (; leftChild(i) < heap.size(); i = child) {
            int left = leftChild(i);
            int right = rightChild(i);

            if (right < heap.size() && heap.get(left).compareTo(heap.get(right)) > 0) {
                child = right;
            } else {
                child = left;
            }

            if (tmp.compareTo(heap.get(child)) > 0) {
                heap.set(i, heap.get(child));
            } else {
                break;
            }
        }
        heap.set(i, tmp);
    }

    /**
     * Inserta un nuevo elemento en el montículo y lo organiza para mantener la propiedad de montículo mínimal.
     *
     * @param item El elemento a insertar.
     */
    @Override
    public void insert(E item) {
        heap.add(item);
        percolateUp(heap.size() - 1);
    }

    /**
     * Elimina y devuelve el elemento más pequeño del montículo.
     *
     * @return El elemento más pequeño del montículo.
     * @throws IllegalStateException Si el montículo está vacío.
     */
    @Override
    public E remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        E minItem = heap.get(0);
        E lastItem = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, lastItem);
            percolateDown(0);
        }
        return minItem;
    }

    /**
     * Devuelve (sin eliminar) el elemento más pequeño del montículo.
     *
     * @return El elemento más pequeño del montículo.
     * @throws IllegalStateException Si el montículo está vacío.
     */
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    /**
     * Comprueba si el montículo está vacío.
     *
     * @return true si el montículo está vacío, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Devuelve el número de elementos en el montículo.
     *
     * @return El número de elementos en el montículo.
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Elimina todos los elementos del montículo.
     */
    @Override
    public void clear() {
        heap.clear();
    }
}
