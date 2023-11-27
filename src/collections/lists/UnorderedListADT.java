package collections.lists;

public interface UnorderedListADT<T> extends ListADT<T> {

    /**
     * Adds the specified element to this list at the proper location
     *
     * @param element the element to be added to this list
     */
    public void addToFront(T element);

    public void addToRear(T element);

    public void addAfter(T element, T target);
}
