package collections.lists;

import collections.exceptions.EmptyCollectionException;

public class UnorderedLinkedList<T> extends LinkedList<T> implements UnorderedListADT<T> {

    /**
     * Creates an empty list using the default capacity.
     */
    public UnorderedLinkedList() {
        super();
    }

    @Override
    public void addToFront(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {
        if(isEmpty()){
            throw new EmptyCollectionException("list");
        }

        LinearNode<T> current = head;
        while(current != null && !current.getElement().equals(target)){
            current = current.getNext();
        }

        if(current == null){
            throw new EmptyCollectionException("target element not found");
        }

        LinearNode<T> newNode = new LinearNode<>(element);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        count++;
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
