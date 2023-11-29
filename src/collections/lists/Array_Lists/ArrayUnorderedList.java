package collections.lists.Array_Lists;

import collections.exceptions.ElementNotFoundException;
import collections.lists.DoubleNode;
import collections.lists.LinearNode;
import collections.lists.UnorderedListADT;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Creates an empty list using the specified capacity.
     * @param initialCapacity
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to the front of this list.
     * @param element
     */
    @Override
    public void addToFront(T element) {
        if(size() == list.length) {
            expandCapacity();
        }

        //Shift elements to make room
        for(int scan = rear; scan > 0; scan--) {
            list[scan] = list[scan-1];
        }

        list[0] = element;
        rear++;

        modCount++;
    }

    /**
     * Adds the specified element to the rear of this list.
     * @param element
     */
    @Override
    public void addToRear(T element) {
        if(size() == list.length) {
            expandCapacity();
        }

        list[rear] = element;
        rear++;

        modCount++;
    }

    /**
     * Adds the specified element after the specified target element.
     * Throws a ElementNotFoundException if the target is not found.
     * @param element
     * @param target
     */
    @Override
    public void addAfter(T element, T target) {
        if (size() == list.length) {
            expandCapacity();
        }

        int scan = 0;
        while (scan < rear && !target.equals(list[scan])) {
            scan++;
        }

        if (scan == rear)
            throw new ElementNotFoundException("list");


        scan++;
        for (int scan2 = rear; scan2 > scan; scan2--) {
            list[scan2] = list[scan2 - 1];
        }

        list[scan] = element;
        rear++;

        modCount++;
    }
}
