package collections.stacks;

import collections.exceptions.EmptyStackException;

public interface SmackStackADT<T> extends StackADT<T> {

    /**
     * Removes and returns the last element from this stack (Smack behavior).
     * This method removes and retrieves the last element from the stack,
     * keeping the original order of elements intact.
     *
     * @return T the last element removed from the stack
     */
    T smack();
}
