package collections.demos;

import collections.trees.*;

import java.util.Iterator;

public class DemoArrayBinarySearchTree {
    public static void main(String[] args) {
        // Create a new ArrayBinarySearchTree object
        ArrayBinarySearchTree<Integer> tree = new ArrayBinarySearchTree<>();
        // Add some elements to the tree
        tree.addElement(50);
        tree.addElement(30);
        tree.addElement(70);
        tree.addElement(20);
        tree.addElement(40);
        tree.addElement(60);
        tree.addElement(80);


        /** If you directly use System.out.println(tree), the output will be something like
         * collections.trees.LinkedBinarySearchTree@1d81eb93.
         * This is the standard representation of an object in Java, which consists of the class name followed by
         * the object's hexadecimal hash code.
         * */
        System.out.println(tree);

        /**
         * The approach is generally to iterate over the elements using the iterator and print each element individually.
         */
        System.out.println("Tree in order: ");
        printTree(tree);

        tree.removeElement(30);
        tree.removeElement(80);

        System.out.println("Tree in order after removing: ");
        printTree(tree);

        tree.removeAllOccurrences(50);
        System.out.println("Tree in order after removing all occurrences of targetElement: ");
        printTree(tree);


        System.out.println("\nTree after rotating right: ");
        /** In this implementation, the index 0 represents the root of the tree, and
         * the index 1 represents the left child of the root, and subsequent indices are calculated based on the
         * formula currentIndex * 2 + 1 for the left child and currentIndex * 2 + 2 for the right child.
         * */
        tree.rotateRight(0);
        printTree(tree);

        System.out.println("\nTree after rotating left: ");
        tree.rotateLeft(0);
        printTree(tree);


        System.out.println("\nTree after rotating left right: ");
        tree.rotateLeftRight(1);
        printTree(tree);

        System.out.println("\nTree after rotating right left: ");
        tree.rotateRightLeft(1);
        printTree(tree);

        /**
         * This is a basic application example. In more complex scenarios or to guarantee an always balanced tree,
         * it may be necessary to implement more advanced balancing logic, such as AVL-specific rotations or Red-Black
         * Trees.
         */

    }

    private static void printTree(ArrayBinaryTree<Integer> tree) {
        Iterator<Integer> iterator = tree.iteratorInOrder();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}