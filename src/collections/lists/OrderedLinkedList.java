package collections.lists;

import collections.exceptions.NonComparableElementException;

public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T> {
    /**
     * Creates an empty list using the default capacity.
     */
    public OrderedLinkedList() {
        super();
    }

    @Override
    public void add(T element) {
        Comparable temp;
        if (element instanceof Comparable) {
            temp = (Comparable) element;
        } else {
            throw new NonComparableElementException("linked ordered list");
        }

        LinearNode<T> traverse = head;
        LinearNode<T> newnode = new LinearNode<T>(element);
        boolean found = false;

        if (isEmpty()) {
            head = newnode;
            tail = newnode;
        } else if (temp.compareTo(tail.getElement()) >= 0) {
            tail.setNext(newnode);
            tail = newnode;
        } else if (temp.compareTo(head.getElement()) <= 0) {
            newnode.setNext(head);
            head = newnode;
        } else {
            while ((temp.compareTo(traverse.getElement()) > 0)) {
                traverse = traverse.getNext();
            }
            newnode.setNext(traverse);
            traverse.setNext(newnode);
        }
        count++;

        // Incrementar modCount quando um elemento é removido da lista
        modCount++;
    }

    /**
     * Method to print the list recursively
     */
    public void printRecursiveList() {
        printRecursiveHelper(head);
    }

    /**
     * Helper method to print the list recursively
     * @param node
     */
    private void printRecursiveHelper(LinearNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " ");
            printRecursiveHelper(node.getNext());
        }
    }

    /* ------------------------------------------------------------------- */

    /**
     * Reverses the order of elements in the linked list.
     */
    public void reverse() {
        head = reverseRecursively(head, null);
    }

    /**
     * Recursive method to reverse the order of elements in the linked list.
     * @param current the current node being processed during recursion
     * @param previous the previous node in the reversed list
     * @return the new head of the reversed list
     */
    private LinearNode<T> reverseRecursively(LinearNode<T> current, LinearNode<T> previous) {
        if (current == null) {
            return previous;
        }

        LinearNode<T> nextNode = current.getNext();
        current.setNext(previous);

        return reverseRecursively(nextNode, current);
    }

    /* ------------------------------------------------------------------- */

    /**
     * Replaces all occurrences of existingElement with newElement in the linked list.
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     */
    public void replace(T existingElement, T newElement) {
        head = replaceRecursively(head, existingElement, newElement);
    }

    /**
     * Recursive method to replace all occurrences of existingElement with newElement.
     * @param current the current node being processed during recursion
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     * @return the modified node after replacements
     */
    private LinearNode<T> replaceRecursively(LinearNode<T> current, T existingElement, T newElement) {
        if (current == null) {
            return null;
        }

        if (current.getElement().equals(existingElement)) {
            current.setElement(newElement);
        }

        current.setNext(replaceRecursively(current.getNext(), existingElement, newElement));

        return current;
    }
}
