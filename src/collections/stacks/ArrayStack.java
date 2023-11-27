package collections.stacks;

import collections.exceptions.EmptyStackException;

public class ArrayStack<T> implements StackADT<T> {
    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;
    /**
     * int that represents both the number of elements and the next
     * available position in the array
     */
    private int top;
    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty stack using the specified capacity.
     */
    public ArrayStack(int initialCapacity) {
        this.top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Expands the capacity of the stack by doubling the size of the array.
     */
    private void expandCapacity(){
        T[] newStack = (T[]) new Object[DEFAULT_CAPACITY * 2];

        System.arraycopy(stack, 0, newStack, 0,stack.length);

        stack = newStack;
    }

    /**
     * Adds the specified element to the top of this stack,
     * expanding the capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) expandCapacity();
        stack[top] = element;
        top++;
    }

    /** Removes and returns the top element from this stack.
     * @return T element removed from the top of the stack
     * @throws EmptyStackException if a
     * pop is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        T result = stack[top-1];
        stack[top-1] = null;
        top--;
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.
     * Throws an EmptyCollectionException if the stack is empty.
     * @return T element on top of stack
     * @throws EmptyStackException if a
     * peek is attempted on empty stack
     */
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top-1];
    }

    /** Returns true if this stack contains no elements.
     * @return boolean whether or not this stack is empty
     */
    @Override
    public boolean isEmpty() {
        if(top == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of elements in this stack.
     * @return int number of elements in this stack
     */
    @Override
    public int size() {
        return top;
    }

    /** Returns a string representation of this stack.
     * @return String representation of this stack
     */
    @Override
    public String toString() {

        String str = "";
        for (int i = 0; i < top; i++) {
            str += stack[i] + " ";
        }
        return str;
    }
}
