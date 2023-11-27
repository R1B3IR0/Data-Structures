package collections.lists;

import collections.exceptions.ElementNotFoundException;
import collections.exceptions.EmptyCollectionException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class LinkedList<T> implements ListADT<T> {

    protected int count;
    protected LinearNode<T> head, tail;
    protected int modCount;

    private class BasicIterator implements Iterator<T>{
        private LinearNode<T> previous;
        private LinearNode<T> current;
        private int expectedModCount;
        private boolean okToRemove;

        public BasicIterator(int modCount) {
            this.previous = null;
            this.current = head;
            this.expectedModCount = modCount;
            this.okToRemove = false;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new ConcurrentModificationException();
            }
            okToRemove = true;
            T result = current.getElement();
            previous = current;
            current = current.getNext();
            return result;
        }

        @Override
        public void remove() {
            if(expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            LinkedList.this.remove(previous.getElement());
            expectedModCount++;
            okToRemove = false;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        count = 0;
        head = tail = null;
    }

    /**
     * Removes and returns the first element from this list.
     *
     */
    @Override
    public T removeFirst() {
        if(isEmpty()) throw new EmptyCollectionException("LinkedList");

        LinearNode<T> result = head;
        head = head.getNext();
        if(head == null){
            tail = null;
        }
        count--;

        modCount++;

        return result.getElement();
    }

    /**
     * Removes and returns the last element from this list.
     */
    @Override
    public T removeLast() {
        if(isEmpty()) throw new EmptyCollectionException("LinkedList");

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while(current.getNext() != null){
            previous = current;
            current = current.getNext();
        }

        LinearNode<T> result = tail;
        tail = previous;
        if(tail == null){
            head = null;
        }else{
            tail.setNext(null);
        }
        count--;

        modCount++;

        return result.getElement();
    }

    /**
     * Removes the first instance of the specified element from this list if it is
     * found in the list and returns a reference to it. Throws an EmptyListException
     * if the list is empty. Throws a NoSuchElementException if the specified element
     * is not found in the list.
     */
    @Override
    public T remove(T element) {
        if(isEmpty()) throw new EmptyCollectionException("LinkedList");

        boolean found = false;

        LinearNode<T> previous = null;
        LinearNode<T> current = head;

        while(current != null && !found){
            if(element.equals(current.getElement())){
                found = true;
            }else{
                previous = current;
                current = current.getNext();
            }
        }

        if(!found) throw new ElementNotFoundException("LinkedList");

        if(size() == 1){
            head = tail = null;
        }else if(current.equals(head)){
            head = current.getNext();
        }else if(current.equals(tail)){
            tail = previous;
            tail.setNext(null);
        }else{
            previous.setNext(current.getNext());
        }

        count--;

        modCount++;

        return current.getElement();
    }

    /**
     * Returns the first element of the list.
     */
    @Override
    public T first() {
        return head.getElement();
    }

    /**
     * Returns the last element of the list.
     */
    @Override
    public T last() {
        return tail.getElement();
    }

    /**
     * Returns true if this list contains the specified target element.
     * Returns false otherwise.
     */
    @Override
    public boolean contains(T target) {
        if(isEmpty()) throw new EmptyCollectionException("LinkedList");

        boolean found = false;
        Object result;

        LinearNode<T> current = head;

        while(current != null && !found){
            if(target.equals(current.getElement())){
                found = true;
            }else{
                current = current.getNext();
            }
        }

        return found;
    }

    /**
     * Returns true if this list is empty and false otherwise.
     *
     */
    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns an iterator for the elements in this list.
     */
    @Override
    public Iterator<T> iterator() {
        return new BasicIterator(modCount);
    }

    /**
     * Returns a string representation of this list.
     */
    @Override
    public String toString() {
        String result = "";
        LinearNode<T> current = head;
        while (current != null) {
            result += current.getElement() + "\n";
            current = current.getNext();
        }
        return result;
    }
}
