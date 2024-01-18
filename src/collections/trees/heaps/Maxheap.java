package collections.trees.heaps;

import collections.exceptions.EmptyCollectionException;
import collections.trees.ArrayBinaryTree;

public class Maxheap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {
    /**
     * Creates an empty heap.
     */
    public Maxheap() {
        super();
    }

    /**
     * Adds the specified element to the heap in the appropriate
     * position according to its key value.
     * @param obj the element to added to this head
     */
    @Override
    public void addElement(T obj) {
        if (count == size()) {
            expandCapacity();
        }

        tree[count] = obj;
        count++;

        if (count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Reorders the heap to maintain the ordering property
     * after adding a node.
     */
    private void heapifyAdd() {
        T temp;

        int next = count - 1;
        while ((next != 0) && (((Comparable) tree[next]).compareTo(tree[(next - 1) / 2]) > 0)) {
            temp = tree[next];
            tree[next] = tree[(next - 1) / 2];
            tree[(next - 1) / 2] = temp;
            next = (next - 1) / 2;
        }
    }

    /**
     * Removes the element with the lowest value in this heap.
     * Throws an EmptyHeapException if the heap is empty.
     * @return the element with the lowest value in this heap
     */
    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap is empty");
        }

        T minElement = tree[0];
        tree[0] = tree[count - 1];
        heapifyRemove();
        count--;

        return minElement;
    }

    /**
     * Reorders this heap to maintain the ordering property.
     */
    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((tree[left] == null) && (tree[right] == null)) {
            next = count;
        } else if (tree[left] == null) {
            next = right;
        } else if (tree[right] == null) {
            next = left;
        } else if (((Comparable) tree[left]).compareTo(tree[right]) > 0) {
            next = left;
        } else {
            next = right;
            while ((next < count) && (((Comparable) tree[next]).compareTo(tree[node]) > 0)) {
                temp = tree[node];
                tree[node] = tree[next];
                tree[next] = temp;
                node = next;
                left = 2 * node + 1;
                right = 2 * (node + 1);
                if ((tree[left] == null) && (tree[right] == null)) {
                    next = count;
                } else if (tree[left] == null) {
                    next = right;
                } else if (tree[right] == null) {
                    next = left;
                } else if (((Comparable) tree[left]).compareTo(tree[right]) > 0) {
                    next = left;
                } else {
                    next = right;
                }
            }
        }
    }

    /**
     * Returns the element with the lowest value in this heap.
     * Throws an EmptyHeapException if the heap is empty.
     * @return the element with the highest value in this heap
     */
    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap is empty");
        }

        return tree[0];
    }
}
