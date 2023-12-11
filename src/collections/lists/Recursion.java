package collections.lists;

public class Recursion {

    /**
     * Method to print the list recursively for the LinkedList
     * @param list  The list to be printed
     */
    public static <T> void printRecursiveList(LinkedList<T> list) {
        printRecursiveHelper(list.head);
    }

    /**
     * Helper method to print the list recursively
     * @param node
     */
    private static <T> void printRecursiveHelper(LinearNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " ");
            printRecursiveHelper(node.getNext());
        }
    }

    /* ------------------------------------------------------------------- */

    /**
     * Recursive method to reverse the order of elements in linked list
     */
    public static <T> void reverse(LinkedList<T> list) {
        list.head = reverseRecursive(list.head, null);
    }

    /**
     * Recursive helper method to reverse the list
     * @param current The current head in the recursion
     * @param previous The previous node in the recursion
     * return The new head of the list
     */
    private static <T> LinearNode<T> reverseRecursive(LinearNode<T> current, LinearNode<T> previous) {
        if (current == null) {
            return previous;
        }

        LinearNode<T> next = current.getNext();
        current.setNext(previous);

        return reverseRecursive(next, current);
    }

    /* ------------------------------------------------------------------- */

    /**
     * Method to print elements from front to back (from first to last element) for the DoubleLinkedList
     *
     */
    public static <T> void printForward(DoubleLinkedList<T> doubleLinkedList) {
        printForwardRecursive(doubleLinkedList.front);
    }

    /**
     * Helper method to print the list recursively
     * @param node
     */
    private static <T> void printForwardRecursive(DoubleNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " "); // Prints the element followed by a space
            printForwardRecursive(node.getNext());
        }
    }

    /**
     * Method to print elements from back to front (from last to first element) for the DoubleLinkedList
     */
    public static <T> void printBackward(DoubleLinkedList<T> doubleLinkedList) {
        printBackwardRecursive(doubleLinkedList.rear);
    }

    /**
     * Helper method to print the list recursively
     * @param node
     */
    private static <T> void printBackwardRecursive(DoubleNode<T> node) {
        if (node != null) {
            System.out.print(node.getElement() + " "); // Prints the element followed by a space
            printBackwardRecursive(node.getPrevious());
        }
    }

    /* ------------------------------------------------------------------- */

    /**
     * Reverses the order of the elements in the list.
     */
    public static <T> void reverse(DoubleLinkedList<T> doubleLinkedList) {
        if (doubleLinkedList.front == null) {
            return; // Se a lista estiver vazia, não há nada para inverter
        }

        doubleLinkedList.front = reverseRecursively(doubleLinkedList.front);
    }

    /**
     * Recursive helper method to reverse the order of elements in the list.
     * @param current the current node being processed during recursion
     * @return the new front node of the reversed list
     */
    private static <T> DoubleNode<T> reverseRecursively(DoubleNode<T> current) {
        // Caso base: Se o nó atual for o último, retorna esse nó como o novo front
        if (current.getNext() == null) {
            return current;
        }

        // Chama recursivamente para o próximo nó
        DoubleNode<T> newFront = reverseRecursively(current.getNext());

        // Inverte os ponteiros next e previous do nó atual e do próximo nó
        DoubleNode<T> nextNode = current.getNext();
        nextNode.setPrevious(nextNode.getNext());
        nextNode.setNext(current);
        current.setNext(null); // Define o próximo do nó atual como null (último nó)

        return newFront; // Retorna o novo front da lista invertida
    }

    /* ------------------------------------------------------------------- */

    /**
     * Replaces all occurrences of existingElement with newElement in the linked list.
     * @param list the linked list to be modified
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     */
    public static <T> void replace(LinkedList<T> list, T existingElement, T newElement) {
        list.head = replaceRecursively(list.head, existingElement, newElement);
    }

    /**
     * Recursive method to replace all occurrences of existingElement with newElement.
     * @param current the current node being processed during recursion
     * @param existingElement the element to be replaced
     * @param newElement the element to replace existingElement with
     * @return the modified node after replacements
     */
    private static <T> LinearNode<T> replaceRecursively(LinearNode<T> current, T existingElement, T newElement) {
        if (current == null) {
            return null;
        }

        if (current.getElement().equals(existingElement)) {
            current.setElement(newElement);
        }

        current.setNext(replaceRecursively(current.getNext(), existingElement, newElement));

        return current;
    }
}
