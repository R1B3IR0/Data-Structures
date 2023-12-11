package collections.lists.arrayLists;


import collections.exceptions.*;
import collections.lists.ListADT;

import java.util.Iterator;

public abstract class ArrayList<T> implements ListADT<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;
    protected int modCount;

    private class BasicIterator implements Iterator<T> {
        private int current;
        private int expectedModcount;
        private boolean okToRemove;

        public BasicIterator(int modCount) {
            current = 0;
            expectedModcount = modCount;
            okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return current < rear;
        }

        @Override
        public T next() {
            if (expectedModcount != ArrayList.this.modCount) throw new ConcurrentModificationException();
            okToRemove = true;
            current++;
            return list[current - 1];
        }

        @Override
        public void remove() {
            if (expectedModcount != ArrayList.this.modCount) throw new ConcurrentModificationException();
            if (!okToRemove) throw new IllegalStateException();
            okToRemove = false;

            current--;

            ArrayList.this.remove(list[current - 1]);

            expectedModcount++;

        }
    }

    /**
     * Creates an empty list using the default capacity.
     *
     */
    public ArrayList() {
        rear = 0;
        list = (T[])(new Object[DEFAULT_CAPACITY]);
        modCount = 0;
    }

    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        rear = 0;
        list = (T[])(new Object[initialCapacity]);
        modCount = 0;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    public T removeFirst() {
        if (isEmpty())
            throw new EmptyCollectionException("list");

        T result = list[0];
        rear--;
        // shift the elements
        for (int i=0; i < rear; i++)
            list[i] = list[i+1];


        list[rear] = null;

        // Atualização do modCount após a remoção
        modCount++;

        return result;
    }

    /**
     *  Removes and returns the last element from this list.
     * @return
     */
    public T removeLast() {
        T result;

        if (isEmpty())
            throw new EmptyCollectionException ("list");

        rear--;
        result = list[rear];
        list[rear] = null;

        // Atualização do modCount após a remoção
        modCount++;

        return result;
    }

    /**
     * Removes and returns the specified element
     *
     * @param element the element to be removed from the list
     * @return
     */
    public T remove(T element) {
        T result;
        int index = find (element);

        if (index == NOT_FOUND) {
            throw new ElementNotFoundException("list");
        }
        result = list[index];
        rear--;
        // shift the appropriate elements
        for (int i=index; i < rear; i++) {
            list[i] = list[i + 1];
        }
        list[rear] = null;
        modCount++;

        return result;
    }

    /**
     * Returns a reference to the element at the front of the list.
     * The element is not removed from the list. Throws an
     * EmptyCollectionException if the list is empty.
     * @return
     * @throws EmptyCollectionException
     */
    public T first() throws EmptyCollectionException {
        if(isEmpty()) throw new EmptyCollectionException("list");

        return list[0];
    }

    /**
     * Returns a reference to the element at the rear of the list.
     * The element is not removed from the list. Throws an
     * EmptyCollectionException if the list is empty.
     * @return
     * @throws EmptyCollectionException
     */
    public T last() throws EmptyCollectionException {
        if(isEmpty()) throw  new EmptyCollectionException("list");

        return list[rear-1];
    }

    /**
     * Returns true if this list contains the specified target element.
     * @param target the target that is being sougth in the list
     * @return
     */
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    /**
     *  Returns the array index of the specified element, or the
     *  constant NOT_FOUND if it is not found.
     * @param target
     * @return
     */
    private int find (T target) {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;

        if (! isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }
        if (found) {
            result = scan;
        }
        return result;
    }

    /**
     * Return true if this list is empty and false otherwise.
     * @return
     */
    public boolean isEmpty() {
        return (rear == 0);
    }

    /**
     * Return the number of elements in this list.
     * @return
     */
    public int size() {
        return rear;
    }

    /**
     * Returns an iterator for the elements currently in this list.
     * @return
     */
    public Iterator<T> iterator() {
        return new BasicIterator(modCount);
    }

    /**
     * Creates a new array to store the contents of this list with
     * twice the capacity of the old one.
     */
    protected void expandCapacity() {
        T[] larger = (T[])(new Object[list.length*2]);

        for (int i=0; i < list.length; i++)
            larger[i] = list[i];

        list = larger;
    }

    /**
     * Return a string representation of this list.
     * @return
     */
    public String toString() {
        String result = "";

        for (int i=0; i < rear; i++)
            result = result + list[i].toString() + " ";

        return result;
    }
}
