package collections.trees;

import collections.exceptions.*;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will become the root of the new binary search tree
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its key value.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;
            while (!added) {
                // if the element is less than the current element, go left
                if (comparableElement.compareTo(current.element) < 0) {
                    // if the left child is null, insert the element
                    if (current.left == null) {
                        current.left = temp;
                        added = true;
                    // otherwise, kep going left
                    } else {
                        current = current.left;
                    }
                // if the element is greater than or equal to the current element, go right
                } else {
                    // if the right child is null, insert the element
                    if (current.right == null) {
                        current.right = temp;
                        added = true;
                    } else {
                        // otherwise, keep going right
                        current = current.right;
                    }
                }
            }
        }
        count++;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;

        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.element)) {
                result = root.element;
                root = replacement(root);
                count--;
            } else {
                BinaryTreeNode<T> current, parent = root;
                boolean found = false;

                if (((Comparable) targetElement).compareTo(root.element) < 0) {
                    current = root.left;
                } else {
                    current = root.right;
                }

                while (current != null && !found) {
                    if (targetElement.equals(current.element)) {
                        found = true;
                        count--;

                        result = current.element;

                        if (current == parent.left) {
                            parent.left = replacement(current);
                        } else {
                            parent.right = replacement(current);
                        }
                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.element) < 0) {
                            current = current.left;
                        } else {
                            current = current.right;
                        }
                    }
                } // end while

                if (!found) {
                    throw new ElementNotFoundException("binary search tree");
                }
            }
        } // end outer if

        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal.  In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removeed
     * @return a reference to the replacing node
     */
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

        if ((node.left == null) && (node.right == null)) {
            result = null;
        } else if ((node.left != null) && (node.right == null)) {
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while (current.left != null) {
                parent = current;
                current = current.left;
            }

            if (node.right == current) {
                current.left = node.left;
            } else {
                parent.left = current.right;
                current.right = node.right;
                current.left = node.left;
            }
            result = current;
        }

        return result;
    }

    /**
     * Removes elements that match the specified target element from
     * the binary search tree.
     * @param targetElement the element that the list will have all instances of it removed
     */
    @Override
    public void removeAllOccurrences(T targetElement) {
        try {
            while (contains(targetElement)) {
                removeElement(targetElement);
            }
        } catch (ElementNotFoundException e) {
            // do nothing
        }
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty.
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree is empty");
        } else {
            T result = null;
            if (root.left == null) {
                // Case 1: root has no left child
                result = root.element;
                root = root.right;
            } else {
                // Case 2: Traverse to the leftmost node
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;

                while (current.left != null) {
                    parent = current;
                    current = current.left;
                }

                result = current.element;

                // Case 3: Node to be removed is a leaf or has right child
                if(current == parent.left) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }

            count--;
            return result;
        }
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty.
     */
    @Override
    public T removeMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree");
        } else {
            if (root.right == null) {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;

                while (current.right != null) {
                    parent = current;
                    current = current.right;
                }

                result = current.element;
                parent.right = current.left;
            }

            count--;
        }

        return result;
    }

    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree.
     * Throws an EmptyCollectionException if the binary search tree is empty.
     */
    @Override
    public T findMin() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree");
        } else {
            BinaryTreeNode<T> current = root;

            while (current.left != null) {
                current = current.left;
            }

            result = current.element;
        }

        return result;
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if the binary
     * search tree is empty.
     */
    @Override
    public T findMax() throws EmptyCollectionException {
        T result = null;

        if (isEmpty()) {
            throw new EmptyCollectionException("binary search tree");
        } else {
            BinaryTreeNode<T> current = root;

            while (current.right != null) {
                current = current.right;
            }

            result = current.element;
        }

        return result;
    }

}
