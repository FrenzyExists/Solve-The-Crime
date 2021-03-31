package interfases;

import java.util.Comparator;

/**
 * Object specialized in sorting an array of elements of type E.
 * The sorting shall be based on an order relation given by a
 * comparator object. Sorts the elements of the array in non-decreasing
 * order as per the associated comparator.
 *
 * @author pedroirivera-vega
 *
 * @param <E> Generic type of elements
 */
public interface Intersection<E> {
    void sort(E[] arr, Comparator<E> cmp);
    String getName();
}
