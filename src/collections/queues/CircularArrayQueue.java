package collections.queues;

import collections.exceptions.EmptyCollectionException;

public class CircularArrayQueue<T> implements QueueADT<T> {
    /** Default capacity of the queue */
    private final int DEFAULT_CAPACITY = 100;
    /** Index of the front of the queue
     *  Index of the rear of the queue
     *  Number of elements in the queue
     * */
    private int front, rear, count;
    /** Array to store the elements of the queue */
    private T[] array;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty queue using the specified capacity.
     *
     * @param initialCapacity the initial size of the circular array queue
     */
    public CircularArrayQueue(int initialCapacity) {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.array = (T[]) new Object[initialCapacity];
    }

    /**
     * Expands the capacity of the queue.
     */
    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[DEFAULT_CAPACITY * 2];

        for (int i = 0; i < count; i++) {
            newQueue[i] = array[front];
            front = (front + 1) % array.length;
        }

        front = 0;
        rear = count;
        array = newQueue;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        if (size() == array.length) expandCapacity();
        array[rear] = element;
        rear = (rear + 1) % array.length;
        count++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return  the element at the front of this queue
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue");
        T result = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        count--;
        return result;
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("Queue");
        return array[front];
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        if (count == 0) return true;
        return false;
    }

    /**
     * Returns the number of elements currently in this queue.
     *
     * @return the size of the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of the queue
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += array[i] + " ";
        }
        return str;
    }
}
