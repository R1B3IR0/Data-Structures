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
}
