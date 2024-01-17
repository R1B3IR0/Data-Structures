package collections.trees;

import collections.exceptions.ElementNotFoundException;
import collections.lists.arrayLists.ArrayUnorderedList;
import collections.queues.LinkedQueue;
import collections.queues.QueueADT;

import java.util.Iterator;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    /**
     * The number of elements in the tree
     */
    protected int count;
    /**
     * A reference to the root of this tree
     */
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary tree
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * Returns a reference to the element at the root
     * @return a reference to the specified target
     */
    @Override
    public T getRoot() {
        return root.element;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
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
     * Returns the integer size of this tree.
     *
     * @return the integer size of this tree
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     */
    @Override
    public boolean contains(T targetElement) {
        return findAgain(targetElement, root) != null; /*Searches for the target element in the tree source(raiz). If
        the 'findAgain' method return a null node the element isn´t found in tree and returns true otherwise false */
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a NoSuchElementException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if(current == null) {
            throw new ElementNotFoundException("binary tree");
        }

        return (current.element);
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @param next          the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);

        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }

        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root.
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preorder(node.left, tempList);
            preorder(node.right, tempList);
        }
    }

    /**
     * Performs a postorder traversal on this binary tree by calling an
     * overloaded, recursive postorder method that starts with the root.
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postorder(node.left, tempList);
            postorder(node.right, tempList);
            tempList.addToRear(node.element);
        }
    }

    /**
     * Performs a levelorder traversal on this binary tree, by calling an
     * overloaded, recursive levelorder method that starts with the root.
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        levelorder(root, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive levelorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void levelorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if(node == null) {
            return;
        }

        QueueADT<BinaryTreeNode<T>> queue = new LinkedQueue<>();
        queue.enqueue(node);

        while(!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            tempList.addToRear(current.element);

            if(current.left != null) {
                queue.enqueue(current.left);
            }

            if(current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }
}
