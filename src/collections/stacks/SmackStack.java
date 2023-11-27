package collections.stacks;

import collections.exceptions.EmptyStackException;

public class SmackStack<T> extends ArrayStack<T> implements SmackStackADT<T> {
    /**
     * Creates an empty stack using the default capacity.
     */
    public SmackStack() {
        super();
    }

    /**
     * Creates an empty stack using the specified capacity.
     */
    public SmackStack(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Removes and returns the last element from this stack (Smack behavior).
     * This method removes and retrieves the last element from the stack,
     * keeping the original order of elements intact.
     *
     * @return T the last element removed from the stack
     */
    @Override
    public T smack()  {
        // If the stack is empty, throw an exception
        if (super.isEmpty()) throw new EmptyStackException();

        // Create a new auxiliary stack to reorganize elements from the original stack
        ArrayStack<T> innerStack = new ArrayStack<>();

        /* Transfer all elements from the original stack to the auxiliary stack (innerStack),
        reversing the order of elements */
        while (!super.isEmpty()) {
            innerStack.push(super.pop());
        }
        /* Remove the top element from the auxiliary stack (innerStack),
        which corresponds to the last element from the original stack */
        T removed = innerStack.pop();

        /* Transfer back all elements from the auxiliary stack (innerStack)
        to the original stack, restoring the original order of elements */
        while (!innerStack.isEmpty()) {
            super.push(innerStack.pop());
        }

        /* Return the initially removed element from the original stack,
        which is the last element of the stack before the procedure */
        return removed;
    }
}
