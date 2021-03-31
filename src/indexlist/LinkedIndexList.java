package indexlist;

import interfases.IndexList;

public class LinkedIndexList<T> implements IndexList<T> {

    private Node<T> head; // references first node, this is NOT a dummy header
    private int size;   // number of elements in the list

    public LinkedIndexList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * @param index
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T set(int index, T e) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * @param index
     * @param e
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T e) throws IndexOutOfBoundsException {

    }

    /**
     * @param e
     */
    @Override
    public void add(T e) {

    }

    /**
     * @param e
     * @return
     */
    @Override
    public int removeAll(T e) {
        return 0;
    }

    /**
     * inserts a newElement right after every current occurrence in the list, if any,
     * of targetElement.
     *
     * For example:
     * If the list is L = {3, 4, 2, 3, 5, 2, 1, 2, 3},
     * then (consider each of the following operations applied to this original list)
     *
     * L.insertAfter(2, 5); would leave the list as: {3, 4, 2, 5, 3, 5, 2, 5, 1, 2, 5, 3}
     * L.insertAfter(2, 2); would leave the list as: {3, 4, 2, 2, 3, 5, 2, 2, 3, 2, 2, 3}
     * L.insertAfter(7, 1); would leave the list as it is, because there is no occurrence of 7 in the list.
     *
     * @param targetElement
     * @param newElement
     */
    @Override
    public void insertAfter(T targetElement, T newElement) {
        for (int i=0; i<size(); i++) {
            if (get(i).equals(targetElement)) {
                add(i++, newElement);
            }
        }
    }
}

/**
 *
 * @param <T>
 */
class Node<T> {

    private T element;
    private Node<T> next;

    /**
     *
     * @param element
     * @param next
     */
    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    /**
     *
     * @param element
     */
    public Node(T element) { //Delegate to other constructor
        this(element, null);
    }

    /**
     *
     */
    public Node() { //Delegate to other constructor
        this(null, null);
    }

    /**
     *
     * @return
     */
    public T getElement() {
        return element;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     *
     * @return
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * This helps the GC whenever a node is to be discarded to avoid memory leaks.
     * @return
     */
    public T clear() {
        T etr = element;
        element = null;
        next = null;
        return etr;
    }
}
