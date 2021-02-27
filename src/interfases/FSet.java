package interfases;

import java.util.Iterator;

/**
 * Set interfase, kinda like the one form classes.
 * Sets are kinda like bags: order does not matter, but unlike bags
 * you can delete things n stuff
 */
public interface FSet<T> extends Iterable<T>, Cloneable {
    /** returns the current size of the set **/
    int size();

    /** returns true if the set is non-empty; otherwise, returns false. **/
    boolean isEmpty();

    /** To determine if a given object belongs to the set.
     @param e the object to test
     @return true if e is element in the set; false, otherwise.
     **/
    boolean contains(T e);

    /** To remove an element from the set. If the element to remove is not a
     member of the set, then this operation has not effect. Otherwise, the
     specified element is removed from the set.
     @param e the element to remove.
     **/
    void remove(T e);

    /** To add an element to the set. If the specified element is already
     an element in the set, then this operation has no effect. Otherwise,
     the element is added to the set.
     @param e the element to add.
     **/
    void add(T e);

    /** Returns an Iterator object through which all the elements of the
     set can be accessed, one by one, by properly invoking that iterator
     methods.
     **/
    Iterator<T> iterator();

    /**
     * To return a shallow copy of the current set.
     * @return a shallow copy of this set.
     * @throws CloneNotSupportedException
     */
    Object clone() throws CloneNotSupportedException;


}
