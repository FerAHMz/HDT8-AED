package uvg.edu.gt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    void insertAndRemove() {
        heap.insert(4);
        heap.insert(2);
        heap.insert(5);
        heap.insert(1);
        heap.insert(3);

        assertEquals(1, heap.remove(), "El elemento removido debe ser el de menor valor (mayor prioridad).");
        assertEquals(2, heap.remove(), "El siguiente elemento removido debe ser el segundo de menor valor.");
        assertFalse(heap.isEmpty(), "El heap no debe estar vacío después de remover algunos elementos.");
    }

    @Test
    void maintainHeapIntegrity() {
        heap.insert(7);
        heap.insert(6);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        heap.insert(4);

        assertEquals(2, heap.remove(), "El heap debe mantener su integridad después de cada operación.");
        heap.insert(1);
        assertEquals(1, heap.remove(), "Inserción después de remoción debe mantener el heap correcto.");
        assertEquals(3, heap.remove(), "La integridad del heap se debe mantener tras varias operaciones.");
    }

    @Test
    void isEmptyAndSize() {
        assertTrue(heap.isEmpty(), "El heap debe estar inicialmente vacío.");
        heap.insert(10);
        assertFalse(heap.isEmpty(), "El heap no debe estar vacío después de insertar un elemento.");
        assertEquals(1, heap.size(), "El tamaño del heap debe reflejar el número de elementos insertados.");

        heap.remove();
        assertTrue(heap.isEmpty(), "El heap debe estar vacío después de remover todos los elementos.");
        assertEquals(0, heap.size(), "El tamaño del heap debe ser cero cuando está vacío.");
    }

    @Test
    void clear() {
        heap.insert(20);
        heap.insert(15);
        assertFalse(heap.isEmpty(), "El heap no debe estar vacío después de inserciones.");
        heap.clear();
        assertTrue(heap.isEmpty(), "El heap debe estar vacío después de llamar a clear.");
        assertEquals(0, heap.size(), "El tamaño del heap debe ser cero después de llamar a clear.");
    }
}


