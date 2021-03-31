package indexlist;

import interfases.IndexList;

import java.util.Iterator;

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
        return size;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index for GET operation, index = " + index);

        // if here, then the index is valid.
        Node<T> targetNode = findNode(index);
        return targetNode.getElement();
    }

    /**
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index for REMOVE operation, index = " + index);

        // if here, then the index is valid.
        Node<T> ntr;                                         // node to remove
        if (index == 0) {                                   // need to remove the first node and return its element.
            ntr = head;
            head = head.getNext();
        } else {
            Node<T> prev = findNode(index-1);     // node preceding the one to remove, why index - 1?
            ntr = prev.getNext();                      // node to remove, notice that we find the predecessor node to the one we want to remove
            prev.setNext(ntr.getNext());              // disconnect the node to remove from the List by deviating the predecessor node's next to the node to remove's next node
        }
        size--;                                     // Decrement size
        return ntr.clear();                        // Help the GC and return element in the node (see clear() in Node)
    }

    /**
     * @param index
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T set(int index, T e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index for SET operation, index = " + index);

        // if here, then the index is valid.
        Node<T> targetNode = findNode(index);   // node whose element is to be replaced
        T etr = targetNode.getElement();        // element to be replaced
        targetNode.setElement(e);               // replace current element by e
        return etr;                             // return the replaced element
    }

    /**
     * @param index
     * @param e
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void add(int index, T e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index for ADD operation, index = " + index);

        // if here, then the index is valid.
        Node<T> newNode = new Node<>(e);      // the new node to be linked to the LL
        if (index == 0) {              // if true, then the new node shall become the new first
            newNode.setNext(head);  // Notice that the previous condition is also true if size==0. Why?
            head = newNode;
        } else {
            // index > 0
            Node<T> prev = findNode(index-1);    // find node preceding location for insertion of new node
            newNode.setNext(prev.getNext());   // properly inserting the new node between prev and its next
            prev.setNext(newNode);             // properly inserting the new node between prev and its next
        }
        size++;
    }

    /**
     * Just add at the end of the list.
     * @param e
     */
    @Override
    public void add(T e) {
        add(size, e);
    }

    /**
     * @param e
     * @return
     */
    @Override
    public int removeAll(T e) {
        int countRM = 0;          // to count the number of removals
        Node<T> ntr;

        //If list is empty, return 0
        if (head == null)
            return 0;

        //Traverse list and check if the element we're traversing at the moment is the one we are looking for
        while (head != null && head.getElement().equals(e)) {
            ntr = head;
            head = head.getNext();
            countRM++;
            ntr.clear();
        }

        if (head != null) {
            Node<T> current = head;
            while (current.getNext() != null) {
                if (current.getNext().getElement().equals(e)) { //Find predecessor node to the one we want to remove
                    //Found it!
                    ntr = current.getNext();
                    current.setNext(ntr.getNext()); //Deviate predecessor's reference to the node to remove's next
                    countRM++;
                    ntr.clear(); //Avoid memory leaks, clear node
                } else {
                    current = current.getNext();
                }
            }
        }

        size = size - countRM;

        return countRM;
    }

    /**
     * inserts a newElement right after every current occurrence in the list, if any,
     * of targetElement.
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

    /**
     * Auxiliary method to find a specific node using a valid index
     * @param index
     * @return
     */
    private Node<T> findNode(int index) {
        // pre: index is valid; that is: index >= 0 and index < size.
        Node<T> target = head;
        for (int i=0; i<index; i++)
            target = target.getNext();

        return target;    // node representing position index in the list
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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
