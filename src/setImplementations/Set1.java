package setImplementations;


import java.util.ArrayList;
import java.util.Iterator;

public class Set1<E> extends AbstractSet<E> {
    private ArrayList<E> elements;

    public Set1() {
        elements = new ArrayList<>();
    }

    public int size() {
        return elements.size();
    }
    public boolean contains(E e) {
        int i = find(e);    // sequential search for e in list elements
        return i >= 0;
    }

    /**
     * Add the new element to the list, if not there already
     * @param e the element to add.
     */
    public void add(E e) {
        if (find(e) == -1)
            elements.add(e);
    }

    /**
     *
     * @param e the element to remove.
     */
    public void remove(E e) {
        int i = find(e);
        if (i == -1) return;
        int last = elements.size() - 1;
        if (i < last)
            elements.set(i, elements.get(last));
        elements.remove(last);
    }

    /**
     * @param e
     * @return
     */
    private int find(E e) {
        for (int i=0; i<elements.size(); i++)
            if (elements.get(i).equals(e))
                return i;     // e found at position i of list elements
        return -1;   // e is not found in the set
    }

    /** @return Returns an Iterator object through which all the elements of the
     set can be accessed, one by one, by properly invoking that iterator
     methods.
    */
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    /**
     * To return a shallow copy of the current set.
     * @return a shallow copy of this set.
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Set1<E> setClone = new Set1<>();
        setClone.elements = (ArrayList<E>) this.elements.clone();
        return setClone;
    }

}

