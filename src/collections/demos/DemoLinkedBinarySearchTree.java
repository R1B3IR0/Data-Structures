package collections.demos;

import collections.trees.LinkedBinarySearchTree;

import java.util.Iterator;

public class DemoLinkedBinarySearchTree {
    public static void main(String[] args) {
        // Create a new LinkedBinarySearchTree object
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

        // Add some elements to the tree
        tree.addElement(55);
        tree.addElement(33);
        tree.addElement(75);
        tree.addElement(22);
        tree.addElement(41);
        tree.addElement(41);

        /**
         * The tree should look like this:
         *
         *              55
         *            /    \
         *          33      75
         *         /  \
         *       22    41
         *               \
         *                41
         */

        /** If you directly use System.out.println(tree), the output will be something like
         * collections.trees.LinkedBinarySearchTree@1d81eb93.
         * This is the standard representation of an object in Java, which consists of the class name followed by
         * the object's hexadecimal hash code.
         * */
        System.out.println(tree);

        /**
         * The approach is generally to iterate over the elements using the iterator and print each element individually.
         */
        // Print the tree in order
        System.out.print("Tree in order: ");
        Iterator<Integer> iterator = tree.iteratorInOrder();
        while (iterator.hasNext()) {
            // .next() returns the next element in the iteration
            System.out.print(iterator.next() + " ");
        }


        // Removes the minimum element from the tree
        tree.removeMin();
        System.out.print("\nTree in order after removing min:");
        Iterator<Integer> it1 = tree.iteratorInOrder();
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }

        /** The tree should look like this after removing the minimum element:
         *
         *              55
         *            /    \
         *          33      75
         *            \
         *             41
         *               \
         *                41
         *  We have a duplicate value in the tree.
         *  The check is only based on the comparison of values, and if a new element is considered equal to an existing
         *  one, it will be added to the right of the corresponding node, according to the logic of the binary search tree.
         */

        // Removes all occurrences of the specified element from the tree
        tree.removeAllOccurrences(41);
        System.out.print("\nTree in order after removing all occurrences of targetElement: ");
        Iterator<Integer> it2 = tree.iteratorInOrder();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

        /** The tree should look like this after removing all occurrences of 41:
         *
         *              55
         *            /    \
         *          33      75
         */
    }
}
