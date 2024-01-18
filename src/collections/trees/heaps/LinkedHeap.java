package collections.trees.heaps;

import collections.exceptions.EmptyCollectionException;
import collections.trees.LinkedBinaryTree;

/**
 * Heap implements a heap.
 */
public class LinkedHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {
    private HeapNode<T> lastNode;

    /**
     * Creates an empty heap.
     */
    public LinkedHeap() {
        super();
    }

    /**
     * Adds the specified element to this heap in the appropriate
     * position according to its key value.
     * Note that equal elements are added to the right.
     * @param obj the element to added to this head
     */
    @Override
    public void addElement(T obj) {
        HeapNode<T> node = new HeapNode<T>(obj);

        if (root == null) {
            root = node;
        } else {
            HeapNode<T> next_parent = getNextParentAdd();
            if (next_parent.left == null) {
                next_parent.left = node;
            } else {
                next_parent.right = node;
            }
            node.parent = next_parent;
        }
        lastNode = node;
        count++;

        if (count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Returns the node that will be the parent of the new node.
     * @return the node that will be the parent of the new node
     */
    private HeapNode<T> getNextParentAdd() {
        HeapNode<T> result = lastNode;

        while ((result != root) && (result.parent.left != result)) {
            result = result.parent;
        }

        if (result != root) {
            if (result.parent.right == null) {
                result = result.parent;
            } else {
                result = (HeapNode<T>) result.parent.right;
                while (result.left != null) {
                    result = (HeapNode<T>) result.left;
                }
            }
        } else {
            while (result.left != null) {
                result = (HeapNode<T>) result.left;
            }
        }

        return result;
    }

    /**
     * Reorders this heap after adding a node.
     */
    private void heapifyAdd() {
        T temp;
        HeapNode<T> next = lastNode;

        temp = next.element;

        while ((next != root) && (((Comparable) temp).compareTo(next.parent.element) < 0)) {
            next.element = next.parent.element;
            next = next.parent;
        }

        next.element = temp;
    }

    /**
     * Removes element with the lowest value from this heap and returns a
     * reference to it. Throws an EmptyHeapException if the heap is empty.
     *
     * @return the element with the lowest value in this heap
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap is empty");
        }

        T minElement = root.element;

        if (count == 1) {
            root = null;
            lastNode = null;
        } else {
            HeapNode<T> next_last = getNewLastNode();
            if (lastNode.parent.left == lastNode) {
                lastNode.parent.left = null;
            } else {
                lastNode.parent.right = null;
            }

            root.element = lastNode.element;
            lastNode = next_last;
            heapifyRemove();
        }

        count--;

        return minElement;
    }

    /**
     * Returns the node that will be the new last node after a remove.
     *
     * @return the node that will be the new last node after a remove
     */
    private HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;

        while ((result != root) && (result.parent.left == result)) {
            result = result.parent;
        }

        if (result != root) {
            result = (HeapNode<T>) result.parent.left;
        }

        while (result.right != null) {
            result = (HeapNode<T>) result.right;
        }

        return result;
    }

    /**
     * Reorders this heap after removing the root element.
     */
    private void heapifyRemove() {
        T temp;
        HeapNode<T> node = (HeapNode<T>) root;
        HeapNode<T> left = (HeapNode<T>) node.left;
        HeapNode<T> right = (HeapNode<T>) node.right;
        HeapNode<T> next;

        if ((left == null) && (right == null)) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (((Comparable) left.element).compareTo(right.element) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.element;

        while ((next != null) && (((Comparable) next.element).compareTo(temp) < 0)) {
            node.element = next.element;
            node = next;
            left = (HeapNode<T>) node.left;
            right = (HeapNode<T>) node.right;

            if ((left == null) && (right == null)) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (((Comparable) left.element).compareTo(right.element) < 0) {
                next = left;
            } else {
                next = right;
            }
        }

        node.element = temp;
    }

    /**
     * Returns the element with the lowest value in this heap.
     * @return
     */
    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Heap is empty");
        }

        return root.element;
    }
}
