package setImplementations;

import interfases.FSet;

import java.lang.reflect.Array;
import java.util.Iterator;

public abstract class AbstractSet<E> implements FSet<E> {
    public boolean isEmpty() {
        return size() == 0;
    }

        // generates a string of the form “{e1, e2, ..., en}”
        public String toString() {
        StringBuilder s = new StringBuilder();              // where e1, e2, ..., en are the elements in the set
        boolean first = true;
        for (E e : this) {
            if (first) {
                s = new StringBuilder("{" + e);
                first = false;
            }
            else
                s.append(", ").append(e);
        }
        return s + "}";
    }

    public <T> T[] toArray(T[] arr) {
        if (arr.length < this.size()) {
            // if arr.length < this.size, allocate a new array of the same
            // type as arr (components of the new array are set to be of equal
            // runtime type as components of the original array arr)
            // and big enough to hold all the elements in this set. For
            // this, we need to use the Array class....
            arr = (T[]) Array.newInstance(arr.getClass().getComponentType(), this.size());
        } else if (arr.length > this.size())
            // Set to null all those positions of arr that won't be used.
            for (int j=this.size(); j< arr.length; j++)
                arr[j] = null;

        int i = 0;
        for (E e: this) {
            arr[i] = (T) e;   // It is assumed E can be casted to T
            i++;
        }
        return arr;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int i = 0;
        for (E e: this) {
            array[i] = e;
            i++;
        }
        return array;

    }

    /**
     * for j = 0 -> m:
     *     * create T_j
     *     for i = 0 ->
     *         * add unique elements to T_j
     *      * Add T_j to the array of sets
     */
    public static FSet[] union(Object[][][] rawData) {
        int m = rawData[0].length;
        int counter = 0;

        FSet[] t = new Set1[m];

        for (int j=0 ; j<m ; j++) {
            FSet ti = new Set1<>();
            for (Object[][] rawDatum : rawData) {
                for (Object k : rawDatum[j]) {
                    ti.add( k);
                }
            }
            t[counter] = ti;
            counter++;
        }
        return t;
    }

    public abstract Iterator<E> iterator();
    public abstract Object clone()  throws CloneNotSupportedException;
}




