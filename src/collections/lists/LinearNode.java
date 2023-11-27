package collections.lists;

public class LinearNode <T> {
    /** reference to next node in list */
    private LinearNode<T> next;
    /** element stored at this node */
    private T element;
    /**Creates an empty node.*/
    public LinearNode() {
        next = null;
        element = null;
    }
    /**
     * Creates a node storing the specified element.
     * @param element element to be stored */
    public LinearNode(T element) {
        next = null;
        this.element = element;
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> node) {
        this.next = node;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T elem) {
        this.element = elem;
    }

    @Override
    public String toString() {
        String str = "";

        str += str + element.toString();

        return str;
    }
}
