package collections.lists;

public class DoubleNode<E> {
    private DoubleNode<E> next;
    private E element;
    private DoubleNode<E> previous;

    public DoubleNode() {
        this.next = null;
        this.element = null;
        this.previous = null;
    }

    public DoubleNode(E element) {
        this.next = null;
        this.element = element;
        this.previous = null;
    }

    public DoubleNode<E> getNext() {
        return next;
    }

    public void setNext(DoubleNode<E> dnode) {
        this.next = dnode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<E> dnode) {
        this.previous = dnode;
    }
}
