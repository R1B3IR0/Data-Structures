package collections.lists;

import collections.exceptions.*;

public class DoubleLinkedOrderedList <T> extends DoubleList<T> implements OrderedListADT<T> {
    /**
     * Creates an empty list using the default capacity.
     */
    public DoubleLinkedOrderedList() {
        super();
    }

    @Override
    public void add(T element) {
        Comparable temp;
        if (element instanceof Comparable) {
            temp = (Comparable) element;
        } else {
            throw new NonComparableElementException("double ordered list");
        }

        DoubleNode<T> traverse = front;
        DoubleNode<T> newnode  = new DoubleNode<T>(element);
        boolean found = false;

        if (isEmpty()) {
            front = newnode;
            rear = newnode;
        } else if (temp.compareTo(rear.getElement()) >= 0) {
            rear.setNext(newnode);
            newnode.setPrevious(rear);
            newnode.setNext(null);
            rear = newnode;
        } else if (temp.compareTo(front.getElement()) <= 0) {
            front.setPrevious(newnode);
            newnode.setNext(front);
            newnode.setPrevious(null);
            front = newnode;
        } else {
            while ((temp.compareTo(traverse.getElement()) > 0)) {
                traverse = traverse.getNext();
            }
            newnode.setNext(traverse);
            newnode.setPrevious(traverse.getPrevious());
            traverse.getPrevious().setNext(newnode);
            traverse.setPrevious(newnode);
        }
        count++;

        // Incrementar modCount quando um elemento é removido da lista
        modCount++;
    }
}
