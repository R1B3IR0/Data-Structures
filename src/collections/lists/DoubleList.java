package collections.lists;

import collections.exceptions.*; // ElementNotFoundException, EmptyCollectionException

import java.util.*; // Iterator, NoSuchElementException, ConcurrentModificationException

public abstract class DoubleList<T> implements ListADT<T> {
    /**
     * The front of the list
     * The rear of the list
     */
    protected DoubleNode<T> front, rear;
    /**
     * Counter of number of elements in the list
     */
    protected int count; // Counter of number of elements in the list
    /**
     * Counter of number of modifications to the list
     */
    protected int modCount; // Counter of number of modifications to the list

    /**
     * Iterator for the list
     */
    private class DoubleIterator implements Iterator<T> {
        private DoubleNode<T> current;
        private DoubleNode<T> previous;
        private int expectedModCount;
        private boolean okToRemove;

        public DoubleIterator(int modCount) {
            this.current = front;
            this.previous = null;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            okToRemove = true;
            T result = current.getElement();
            previous = current;
            current = current.getNext();
            return result;
        }

        @Override
        public void remove() {
            if (expectedModCount != DoubleList.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            DoubleList.this.remove(previous.getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }

    /**
     * Creates an empty list.
     */
    public DoubleList() {
        front = null;
        rear = null;
        count = 0;
        modCount = 0;
    }

    /**
     * Removes and returns the first element in this list.
     * @return the first element in the list
     */
    @Override
    public T removeFirst() {
        if (isEmpty())
            throw new EmptyCollectionException("list");

        T result = front.getElement();
        front = front.getNext();

        if (front==null) {
            rear = null;
        } else {
            front.setPrevious(null);
        }
        count--;

        // Incrementar modCount quando um elemento é removido da lista
        modCount++;

        return result;
    }

    /**
     * Removes and returns the last element in this list.
     * @return the last element in the list
     */
    @Override
    public T removeLast() {
        T result;

        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        result = rear.getElement();
        rear = rear.getPrevious();

        if (rear==null) {
            front = null;
        } else {
            rear.setNext(null);
        }
        count--;

        // Incrementar modCount quando um elemento é removido da lista
        modCount++;

        return result;
    }

    /**
     * Removes and returns the specified element.
     * @param element
     * @return
     */
    @Override
    public T remove(T element) {
        T result;
        DoubleNode<T> nodeptr = find (element);


        if (nodeptr == null) {
            throw new ElementNotFoundException("list");
        }
        result = nodeptr.getElement();

        // check to see if front or rear
        if (nodeptr == front) {
            result = this.removeFirst();
        } else if (nodeptr == rear) {
            result = this.removeLast();
        } else {
            nodeptr.getNext().setPrevious(nodeptr.getPrevious());
            nodeptr.getPrevious().setNext(nodeptr.getNext());
            count--;
        }

        // Incrementar modCount quando um elemento é removido da lista
        modCount++;

        return result;
    }

    /**
     * Returns a reference to the element at the front of the list.
     * The element is not removed from the list.  Throws an
     * EmptyCollectionException if the list is empty.
     */
    @Override
    public T first() {
        if (isEmpty())
            throw new EmptyCollectionException ("list");

        return front.getElement();
    }

    /**
     * Returns a reference to the element at the rear of the list.
     * The element is not removed from the list. Throws an
     * EmptyCollectionException if the list is empty.
     * @return
     */
    @Override
    public T last() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("list");

        return rear.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target
     * @return
     */
    @Override
    public boolean contains(T target) {
        return (find(target) != null);
    }

    /**
     * Returns a reference to the specified element, or null if it is not found.
     */
    private DoubleNode<T> find (T target) {
        boolean found = false;
        DoubleNode<T> traverse = front;
        DoubleNode<T> result = null;

        if (! isEmpty()) {
            while (!found && traverse != null) {
                if (target.equals(traverse.getElement())) {
                    found = true;
                } else {
                    traverse = traverse.getNext();
                }
            }
        }
        if (found) {
            result = traverse;
        }
        return result;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements currently in this list.
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns an iterator for the elements currently in this list.
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleIterator(modCount);
    }

    /**
     * Returns a string representation of this list.
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        DoubleNode<T> traverse = front;

        while (traverse != null) {
            result = result + (traverse.getElement()).toString() + " ";
            traverse = traverse.getNext();
        }
        return result;
    }
}
