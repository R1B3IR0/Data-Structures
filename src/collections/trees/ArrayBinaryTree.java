package collections.trees;

import collections.exceptions.ElementNotFoundException;
import collections.lists.arrayLists.ArrayUnorderedList;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {
    /* number of elements in the tree */
    protected int count;
    /*array of elements*/
    protected T[] tree;
    /* constant to represent the default capacity of the array */
    private final int DEFAULT_CAPACITY = 50;

    /**
     * Creates an empty binary tree.
     */
    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary tree
     */
    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[DEFAULT_CAPACITY];
        tree[0] = element;
    }

    /**
     * Expands the capacity of the binary tree
     */
    protected void expandCapacity() {
        T[] temp = (T[]) new Object[tree.length * 2];

        for (int ct = 0; ct < tree.length; ct++) {
            temp[ct] = tree[ct];
        }

        tree = temp;
    }

    /**
     * Returns a reference to the element at the root
     *
     * @return a reference to the specified target
     */
    @Override
    public T getRoot() {
        return tree[0];
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in this binary tree.
     *
     * @return the integer number of elements in this tree
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns true if the binary tree contains an element that
     * matches the specified target element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree false otherwise
     */
    @Override
    public boolean contains(T targetElement) {
        return find(targetElement) != null;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a NoSuchElementException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        T temp = null;
        boolean found = false;

        for (int ct = 0; ct < count && !found; ct++) {
            if (targetElement.equals(tree[ct])) {
                found = true;
                temp = tree[ct];
            }
        }

        if (!found) {
            throw new ElementNotFoundException("binary tree");
        }

        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by
     * calling an overloaded, recursive inorder method
     * that starts with the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node in the traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(int node, ArrayUnorderedList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inorder(node * 2 + 1, tempList);
                tempList.addToRear(tree[node]);
                inorder((node + 1) * 2, tempList);
            }
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by
     * calling an overloaded, recursive preorder method
     * that starts with the root.
     *
     * @return a preorder iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node     the node in the traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preorder(int node, ArrayUnorderedList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                tempList.addToRear(tree[node]);
                preorder(node * 2 + 1, tempList);
                preorder((node + 1) * 2, tempList);
            }
        }
    }

    /**
     * Performs an postorder traversal on this binary tree by
     * calling an overloaded, recursive postorder method
     * that starts with the root.
     *
     * @return a postorder iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node     the node in the traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postorder(int node, ArrayUnorderedList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                postorder(node * 2 + 1, tempList);
                postorder((node + 1) * 2, tempList);
                tempList.addToRear(tree[node]);
            }
        }
    }

    /**
     * Performs an levelorder traversal on this binary tree by
     * calling an overloaded, recursive levelorder method
     * that starts with the root.
     *
     * @return a levelorder iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        levelorder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive levelorder traversal.
     *
     * @param node     the node in the traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void levelorder(int node, ArrayUnorderedList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                tempList.addToRear(tree[node]);
                levelorder(node * 2 + 1, tempList);
                levelorder((node + 1) * 2, tempList);
            }
        }
    }
}
