package interfases;

import java.util.Iterator;

/**
 * Set interfase, kinda like the one form classes.
 * Sets are kinda like bags: order does not matter, but unlike bags
 * you can delete things n stuff
 */
public interface FSet<T> extends Iterable<T>, Cloneable {

    /**
     * @return Size of set
     */
    int size();

    boolean isEmpty();

    boolean contains(T element);

    void remove(T element);

    void add(T element);

    Iterator<T> iterator();

    Object clone() throws CloneNotSupportedException;


}
