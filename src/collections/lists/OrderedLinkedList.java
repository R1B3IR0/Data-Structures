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
}
