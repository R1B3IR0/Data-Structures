package collections.trees.heaps;

import collections.exceptions.EmptyCollectionException;
import collections.trees.ArrayBinaryTree;

/**
 * Same class of minheap.java
 * @param <T>
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T> implements HeapADT<T> {

    /**
     * Creates an empty heap.
     */
    public ArrayHeap() {
        super();
    }

    /**
     * Adds the specified element to the heap in the appropriate
     * position according to its key value.  Note that equal elements
     * are added to the right.
     * @param obj the element to added to this head
     */
    @Override
    public void addElement(T obj) {
        if (count == tree.length) {
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

        temp = tree[next];

        while ((next != 0) && (((Comparable)temp).compareTo(tree[(next - 1) / 2]) < 0)) {
            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        tree[next] = temp;
    }

    /**
     * Removes the element with the lowest value in this heap and
     * returns a reference to it.  Throws an EmptyHeapException if
     * the heap is empty.
     * @return
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
        } else if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
            next = left;
        } else {
            next = right;
        }
        temp = tree[node];
        while ((next < count) && (((Comparable) tree[next]).compareTo(tree[node]) < 0)) {
            tree[node] = tree[next];
            node = next;
            left = 2*node+1;
            right = 2*(node+1);
            if ((tree[left] == null) && (tree[right] == null))
                next = count;
            else if (tree[left] == null)
                next = right;
            else if (tree[right] == null)
                next = left;
            else if (((Comparable)tree[left]).compareTo(tree[right]) < 0)
                next = left;
            else
                next = right;
        }
        tree[node] = temp;
    }


    /**
     * Returns the element with the lowest value in the heap.
     * Throws an EmptyHeapException if the heap is empty.
     */
    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap is empty");
        }

        return tree[0];
    }
}
