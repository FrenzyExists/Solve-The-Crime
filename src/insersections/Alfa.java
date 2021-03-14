package insersections;

import interfases.FSet;
import setImplementations.Set1;

/**
 * This is P1
 * Alfa utilizes Set1, as part of the specifications given
 */

public class Alfa<T> extends IntersectionFinder {

    public Alfa(String name) {
        super(name);
    }

    public Alfa() {
        super("P1");
    }

    /**
     * Intersects a family of sets.
     * T <- T0
     * for j in 1, ..., m-1 do
     *      for (each x∃T) do
     *            if (x∄Ti)remove x from T
     * return T
     *
     *
     * @param famSet array containing the family of sets to be intersected.
     * @return the final intersection set (the result of intersecting all sets in t)
     */
    @Override
    public FSet<T> intersectSets(FSet[] famSet) throws CloneNotSupportedException {
        Set1<T> T = (Set1<T>) famSet[0];
        Set1<T> T0 = (Set1<T>) T.clone();

        for (FSet<T> j : famSet) {
            for (T x : T0) {
                if (!j.contains(x)) {
                    T.remove(x);
                }
            }
        }
        return T;
    }


}
