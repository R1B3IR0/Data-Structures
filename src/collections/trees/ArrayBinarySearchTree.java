package collections.trees;

import collections.exceptions.ElementNotFoundException;
import collections.exceptions.EmptyCollectionException;
import collections.lists.arrayLists.ArrayUnorderedList;

import java.util.Iterator;


/**
 * ArrayBinarySearchTree implements a binary search tree
 * using an array.
 */
public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T>
        implements BinarySearchTreeADT<T> {
    protected int height;
    protected int maxIndex;

    /**
     * Creates binary search with the specified element as its root
     *
     * @param element the element that will become the root of the new tree
     */
    public ArrayBinarySearchTree(T element) {
        super(element);
        height = 1;
        maxIndex = 0;
    }

    /**
     * Creates an empty binary search tree.
     */
    public ArrayBinarySearchTree() {
        super();
        height = 0;
        maxIndex = -1;
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its key value.  Note that
     * equal elements are added to the right. Also note that the
     * index of the left child of the current index can be found by
     * doubling the current index and adding 1. Finding the index
     * of the right child can be calculated by doubling the current
     * index and adding 2.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElement(T element) {
        if(tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;

        if(isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while(!added) {
                // if element is less than current element, go left
                if(tempelement.compareTo((tree[currentIndex]) ) < 0) {
                    /** go left */
                    if(tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if(currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                    // if element is greater than or equal to current element, go right
                } else {
                    /** go right */
                    if(tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if(currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }
        }
        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        count++;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T removeElement(T targetElement) {
        T result = null;
        boolean found = false;

        if(isEmpty()) {
            return result;
        }

        for (int i = 0; (i <= maxIndex) && !found; i++) {
            if ((tree[i] != null) && targetElement.equals(tree[i])) {
                found = true;
                result = tree[i];
                replace(i);
                count--;
            }
        }

        if(!found) {
            throw new ElementNotFoundException("element not found in the binary tree");
        }

        int temp = maxIndex;
        maxIndex = -1;
        for (int i = 0; i <= temp; i++) {
            if(tree[i] != null) {
                maxIndex = i;
            }
        }

        height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;

        return result;
    }

    /**
     * Removes elements that match the specified target element from
     * the binary search tree. Throws a ElementNotFoundException if the sepcified target
     * element is not found in this tree.
     * @param targetElement the element that the list will have all instances of it removed
     */
    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            while(contains(targetElement)) {
                removeElement(targetElement);
            }
        } catch (ElementNotFoundException e) {
            // Do nothing
        }

    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.
     */
    @Override
    public T removeMin() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("binary tree empty");
        } else {
            int currentIndex = 1;
            int previousIndex = 0;
            while(tree[currentIndex] != null && currentIndex <= tree.length) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 1;
            } // While
            result = tree[previousIndex];
            replace(previousIndex);
        } // else

        count--;

        return result;
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.
     */
    @Override
    public T removeMax() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("binary tree empty");
        } else {
            int currentIndex = 2;
            int previousIndex = 0;
            while(tree[currentIndex] != null && currentIndex <= maxIndex) {
                previousIndex = currentIndex;
                currentIndex = currentIndex * 2 + 2;
            } // While
            result = tree[previousIndex];
            replace(previousIndex);
        } // else

        count--;
        return result;
    }

    /**
     * Returns the element with the least value int the binary search
     * tree. It does not remove the node from the binary search tree.
     * Throws an EmptyCollectionException if the binary search tree is empty.
     */
    @Override
    public T findMin() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("element not found in the binary tree");
        } else {
            int currentIndex = 0;
            while(tree[currentIndex*2+1] != null && (currentIndex*2+1 <= maxIndex)) {
                currentIndex = currentIndex * 2 + 1;
            } // While
            result = tree[currentIndex];
        } // else

        return result;
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if the
     * binary search tree is empty.
     */
    @Override
    public T findMax() {
        T result = null;

        if(isEmpty()) {
            throw new EmptyCollectionException("element not found in the binary tree");
        } else {
            int currentIndex = 0;
            while(tree[currentIndex*2+2] != null && (currentIndex*2+2 <= maxIndex)) {
                currentIndex = currentIndex * 2 + 2;
            } // While
            result = tree[currentIndex];
        } // else
        return result;
    }

    /**
     * Removes the node specified for removal and shifts the tree
     * array accordingly.
     */
    protected void replace(int targetIndex) {
        int currentIndex, parentIndex, temp, oldIndex, newIndex;
        ArrayUnorderedList<Integer> oldlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> newlist = new ArrayUnorderedList<Integer>();
        ArrayUnorderedList<Integer> templist = new ArrayUnorderedList<Integer>();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex*2+1 >= tree.length) || (targetIndex*2+2 >= tree.length))
            tree[targetIndex] = null;

            // if target node has no children
        else if ((tree[targetIndex*2+1] == null) && (tree[targetIndex*2+2] == null))
            tree[targetIndex] = null;

            // if target node only has a left child
        else if ((tree[targetIndex*2+1] != null) && (tree[targetIndex*2+2] == null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex*2+1;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(new Integer(currentIndex*2+1));
                    templist.addToRear(new Integer(currentIndex*2+2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(new Integer(currentIndex*2+1));
                    templist.addToRear(new Integer(currentIndex*2+2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // if target node only has a right child
        else if ((tree[targetIndex*2+1] == null) && (tree[targetIndex*2+2] != null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex*2+2;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(new Integer(currentIndex*2+1));
                    templist.addToRear(new Integer(currentIndex*2+2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer)templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                    templist.addToRear(new Integer(currentIndex*2+1));
                    templist.addToRear(new Integer(currentIndex*2+2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // target node has two children
        else
        {
            currentIndex = targetIndex*2+2;

            while (tree[currentIndex*2+1] != null) {
                currentIndex = currentIndex*2+1;
            }

            tree[targetIndex] = tree[currentIndex];

            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot*2+2] != null) {

                // fill newlist with indices of nodes that will replace
                // the corresponding indices in oldlist

                // fill newlist
                currentIndex = currentRoot*2+2;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer)templist.removeFirst()).intValue();
                    newlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                        templist.addToRear(new Integer(currentIndex*2+1));
                        templist.addToRear(new Integer(currentIndex*2+2));
                    }
                }

                // fill oldlist
                currentIndex = currentRoot;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer)templist.removeFirst()).intValue();
                    oldlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex*2+2) <= (Math.pow(2,height)-2)) {
                        templist.addToRear(new Integer(currentIndex*2+1));
                        templist.addToRear(new Integer(currentIndex*2+2));
                    }
                }

                // do replacement
                oldIt = oldlist.iterator();
                newIt = newlist.iterator();
                while (newIt.hasNext()) {
                    oldIndex = oldIt.next();
                    newIndex = newIt.next();
                    tree[oldIndex] = tree[newIndex];
                    tree[newIndex] = null;
                }
            }
            else
                tree[currentRoot] = null;
        }
    }

    /**
     * Mehtod to rotate the tree to the right
     * @param rootIndex
     */
    public void rotateRight(int rootIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        T temp = tree[leftChildIndex];
        tree[leftChildIndex] = tree[rootIndex];
        tree[rootIndex] = temp;
    }

    /**
     * Method to rotate the tree to the left
     * @param rootIndex
     */
    public void rotateLeft(int rootIndex) {
        int rightChildIndex = rootIndex * 2 + 2;
        T temp = tree[rightChildIndex];
        tree[rightChildIndex] = tree[rootIndex];
        tree[rootIndex] = temp;
    }

    /**
     * Method to rotate the tree to the right-left
     * @param rootIndex
     */
    public void rotateRightLeft(int rootIndex) {
        int rightChildIndex = rootIndex * 2 + 2;
        rotateRight(rightChildIndex);
        rotateLeft(rootIndex);
    }

    /**
     * Method to rotate the tree to the left-right
     * @param rootIndex
     */
    public void rotateLeftRight(int rootIndex) {
        int leftChildIndex = rootIndex * 2 + 1;
        rotateLeft(leftChildIndex);
        rotateRight(rootIndex);
    }
}
