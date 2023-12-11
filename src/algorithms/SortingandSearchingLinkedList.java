package algorithms;

import collections.lists.*;

/*****************************************
 *              ATENTION                 |
 *                                       |
 *The above code is not working,
 * only partially                        |
 ****************************************/
public class SortingandSearchingLinkedList {
    /**
     * Sorts the specified Linked List of objects using the quick sort algorithm.
     * @param data the Linked List to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void quickSort(LinkedList<T> data, int min, int max) {
        int indexOfPartition;

        if (max - min > 0) {
            /* Create partitions */
            indexOfPartition = findPartition(data, min, max);

            /* Sort the left side */
            quickSort(data, min, indexOfPartition - 1);

            /* Sort the right side */
            quickSort(data, indexOfPartition + 1, max);
        }
    }

    /**
     * Used by the quick sort algorithm to find the partition.
     *
     * @param data the Linked List to be sorted
     * @param min  the integer representation of the minimum value
     * @param max  the integer representation of the maximum value
     */
    private static <T extends Comparable<? super T>> int findPartition(LinkedList<T> data, int min, int max) {
        int left, right;
        T temp, partitionElement;
        int middle = (min + max) / 2;

        /* use the middle element as partition */
        partitionElement = getElementAt(data, middle);

        left = min;
        right = max;

        while (left < right) {
            /* search for an element that is > the partitionElement */
            while (getElementAt(data, left).compareTo(partitionElement) < 0)
                left++;

            /* search for an element that is < the partition element */
            while (getElementAt(data, right).compareTo(partitionElement) > 0)
                right--;

            /* swap the elements */
            if (left < right) {
                temp = getElementAt(data, left);
                setElementAt(data, left, getElementAt(data, right));
                setElementAt(data, right, temp);
            }
        }
        return right;
    }

    /**
     * This method returns the element of linked list in a specific index(position)
     * @param list the Linked List
     * @param index the index of the element to be returned
     * @return the element at the specified index in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private static <T> T getElementAt(LinkedList<T> list, int index) {
        LinearNode<T> current = list.head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds.");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return current.getElement();
    }

    /**
     * This method sets the element of linked list in a specific index(position)
     * @param list the Linked List
     * @param index the index of the element to be set
     * @param element the element to be set
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private static <T> void setElementAt(LinkedList<T> list, int index, T element) {
        LinearNode<T> current = list.head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds.");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        current.setElement(element);
    }

    /**
     * Sorts the specified Linked List of objects using the merge sort algorithm.
     *
     * @param data the LinkedList to be sorted
     * @param min  the integer representation of the minimum value
     * @param max  the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void mergeSort(LinkedList<T> data, int min, int max) {
        T[] temp;
        int index1, left, right;

        /* return on list of length one */
        if (min == max) {
            return;
        }

        /* find the length and the midpoint of the list */
        int size = max - min + 1;
        int pivot = (min + max) / 2;
        temp = (T[]) (new Comparable[size]);

        mergeSort(data, min, pivot); // sort left half of list
        mergeSort(data, pivot + 1, max); // sort right half of list

        /* copy sorted data into workspace */
        for (index1 = 0; index1 < size; index1++)
            temp[index1] = getElementAt(data, min + index1);

        /* merge the two sorted lists */
        left = 0;
        right = pivot - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min)
                if (left <= pivot - min)
                    if (temp[left].compareTo(temp[right]) > 0)
                        setElementAt(data, index1 + min, temp[right++]);
                    else
                        setElementAt(data, index1 + min, temp[left++]);
                else
                    setElementAt(data, index1 + min, temp[right++]);
            else
                setElementAt(data, index1 + min, temp[left++]);
        }
    }

    /**
     * Sorts the specified Linked List of objects using a bubble sort algorithm.
     * @param data the LinkedList to be sorted
     */
    public static <T extends Comparable<? super T>> void bubbleSort(LinkedList<T> data) {
        int position, scan;
        T temp;

        for (position = data.size() - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (getElementAt(data, scan).compareTo(getElementAt(data, scan + 1)) > 0) {
                    temp = getElementAt(data, scan);
                    setElementAt(data, scan, getElementAt(data, scan + 1));
                    setElementAt(data, scan + 1, temp);
                }
            }
        }
    }

    /**
     * Searches the specified Linked List of objects using a linear search algorithm.
     * @param data the LinkedList to be searched
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean linearSearch(LinkedList<T> data, int min, int max, T target) {
        int index = min;
        boolean found = false;

        while (!found && index <= max) {
            if (getElementAt(data, index).compareTo(target) == 0) {
                found = true;
            }
            index++;
        }
        return found;
    }

    /**
     * Searches the specified Linked List of objects using a binary search algorithm.
     *
     * @param data the LinkedList to be searched
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean binarySearch(LinkedList<T> data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2;

        if (getElementAt(data, midpoint).equals(target)) {
            found = true;
        } else if (getElementAt(data, midpoint).compareTo(target) > 0) {
            if (min <= midpoint - 1) {
                found = binarySearch(data, min, midpoint - 1, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }
        return found;
    }

    /**
     * Sorts the specified Linked List of objects using a selection sort algorithm.
     *
     * @param data the LinkedList to be sorted
     */
    public static <T extends Comparable<? super T>> void selectionSort(LinkedList<T> data) {
        int min;
        T temp;

        for (int index = 0; index < data.size() - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.size(); scan++) {
                if (getElementAt(data, scan).compareTo(getElementAt(data, min)) < 0) {
                    min = scan;
                }
            }
            temp = getElementAt(data, min);
            setElementAt(data, min, getElementAt(data, index));
            setElementAt(data, index, temp);
        }
    }

    /**
     * Sorts the specified Linked List of objects using an insertion sort algorithm.
     *
     * @param data the LinkedList to be sorted
     */
    public static <T extends Comparable<? super T>> void insertionSort(LinkedList<T> data) {
        for (int index = 1; index < data.size(); index++) {
            T key = getElementAt(data, index);
            int position = index;

            /* shift larger values to the right */
            while (position > 0 && getElementAt(data, position - 1).compareTo(key) > 0) {
                setElementAt(data, position, getElementAt(data, position - 1));
                position--;
            }

            setElementAt(data, position, key);
        }
    }
}
