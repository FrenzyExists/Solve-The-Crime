package interfases;

/**
 * An object of this type is capable of finding the intersection of a family
 * of sets of elements of a particular data type.
 *
 * @param <T> the data type of elements in the sets. It is assumed that it
 * is always instantiated to an object data type that has overridden its
 * own version of the equals method from the Object class.
 */
public interface IntersectionFinder<T> {
    /**
     * Intersects a family of sets.
     * @param famSet array containing the family of sets to be intersected.
     * @return the final intersection set (the result of intersecting all sets in t)
     */
    FSet<T> intersectSets(FSet<T>[] famSet);
    String getName();
}