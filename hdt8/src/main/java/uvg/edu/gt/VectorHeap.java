package uvg.edu.gt;

import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> heap;

    public VectorHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void percolateUp(int i) {
        E item = heap.get(i);
        while (i > 0 && item.compareTo(heap.get(parent(i))) < 0) {
            heap.set(i, heap.get(parent(i)));
            i = parent(i);
        }
        heap.set(i, item);
    }

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

    @Override
    public void insert(E item) {
        heap.add(item);
        percolateUp(heap.size() - 1);
    }

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

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void clear() {
        heap.clear();
    }
}
