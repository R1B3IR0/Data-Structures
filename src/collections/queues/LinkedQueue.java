package collections.queues;

import collections.exceptions.EmptyCollectionException;
import collections.lists.LinearNode;

public class LinkedQueue <T> implements QueueADT<T> {
    /** Reference to front of queue *
     * Reference to rear of queue
     */
    private LinearNode<T> front, rear;

    /** Number of elements in Queue **/
    private int size;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        //New Node
        LinearNode<T> node = new LinearNode<T>(element);

        if(size == 0) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;

        size++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return  the element at the front of this queue
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()) throw new EmptyCollectionException("Empty Queue");

        T element = front.getElement(); //Igualar variável ao elemento que queremos remover e retornar no fim
        front = front.getNext();
        size--;

        if(isEmpty()) rear = null; // Caso Size seja igual a 1;

        return element;
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()) throw new EmptyCollectionException("Empty Queue");
        return front.getElement();
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty.
     */
    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return a string representation of this queue.
     */
    @Override
    public String toString() {
        String str = "";

        LinearNode<T> current = front;

        while (current != null) {
            str = str + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }
        return str;
    }
}
