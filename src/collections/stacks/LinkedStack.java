package collections.stacks;

import collections.exceptions.EmptyCollectionException;
import collections.exceptions.EmptyStackException;
import collections.lists.LinearNode;

public class LinkedStack<T> implements StackADT<T> {
    /**
     * reference to top of stack
     */
    private LinearNode<T> top;

    /**
     * number of elements in the stack
     */
    private int size; // number of elements in the stack

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Adds the specified element to the top of this stack,
     *
     * @param element
     */
    @Override
    public void push(T element) {
        if (top == null) isEmpty();

        LinearNode<T> tmp = new LinearNode<>(element);
        tmp.setNext(top);
        top = tmp;
        size++;
    }

    /**
     * Removes an element.
     *
     * @return T element removed from the top of the stack
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();

        T result = top.getElement();
        top = top.getNext();
        size--;

        return result;

    }

    /**
     * Returns without removing the top element of this stack.
     *
     * @return T element on top of the stack
     */
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();

        return top.getElement();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return boolean whether or not this stack is empty
     */
    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return int number of elements in this stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return String representation of this stack
     */
    @Override
    public String toString() {
        String str = "";
        LinearNode<T> current = top;
        while( current != null) {
            str = str + current.toString() + "\n";
            current = current.getNext();
        }
        return str;
    }
}
