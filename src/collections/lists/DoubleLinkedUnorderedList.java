package collections.lists;

import collections.exceptions.EmptyCollectionException;

public class DoubleLinkedUnorderedList<T> extends DoubleList<T> implements UnorderedListADT<T> {
    /**
     * Creates an empty list using the default capacity.
     */
    public DoubleLinkedUnorderedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.setPrevious(rear);
            rear.setNext(newNode);
            rear = newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        DoubleNode<T> current = front;
        while (current != null && !current.getElement().equals(target)) {
            current = current.getNext();
        }

        if (current == null) {
            throw new EmptyCollectionException("target element not found");
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);
        newNode.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setPrevious(newNode);
        }
        current.setNext(newNode);
        newNode.setPrevious(current);

        if (current == rear) {
            rear = newNode;
        }

        count++;
        modCount++;

    }

    /* ------------------------------------------------------------------- */

    /**
     * Method to print elements from front to back (from first to last element)
     */
    public void printForward() {
        printForwardRecursive(front);
    }
    /**
     * Helper method to print the list recursively
     * @param node
     */
    private void printForwardRecursive(DoubleNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " "); // Prints the element followed by a space
            printForwardRecursive(node.getNext());
        }
    }

    /**
     * Method to print elements from back to front (from last to first element)
     */
    public void printBackward() {
        printBackwardRecursive(rear);
    }
    /**
     * Helper method to print the list recursively
     * @param node
     */
    private void printBackwardRecursive(DoubleNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " "); // Prints the element followed by a space
            printBackwardRecursive(node.getPrevious());
        }
    }

    /* ------------------------------------------------------------------- */

    /**
     * Reverses the order of the elements in the list.
     */
    public void reverse() {
        reverseRecursively(front);
    }

    /**
     * Recursive helper method to reverse the order of elements in the list.
     * @param current the current node being processed during recursion
     */
    private void reverseRecursively(DoubleNode<T> current) {
        if (current == null) {
            return;
        }

        // Swap the next and previous pointers of the current node
        DoubleNode<T> temp = current.getNext();
        current.setNext(current.getPrevious());
        current.setPrevious(temp);

        // Recursively call for the previous node in the list
        if (current.getPrevious() == null) {
            // Update the front (if we reached the original end of the list)
            front = current;
            return;
        }

        reverseRecursively(current.getPrevious());
    }

    /* ------------------------------------------------------------------- */

    /**
     * Replaces all occurrences of existingElement with newElement in the doubly linked list.
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     */
    public void replace(T existingElement, T newElement) {
        front = replaceRecursively(front, existingElement, newElement);
    }

    /**
     * Recursive method to replace all occurrences of existingElement with newElement.
     * @param current the current node being processed during recursion
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     * @return the modified node after replacements
     */
    private DoubleNode<T> replaceRecursively(DoubleNode<T> current, T existingElement, T newElement) {
        if (current == null) {
            return null;
        }

        if (current.getElement().equals(existingElement)) {
            current.setElement(newElement);
        }

        current.setNext(replaceRecursively(current.getNext(), existingElement, newElement));

        if (current.getNext() != null) {
            current.getNext().setPrevious(current);
        }

        return current;
    }
}
