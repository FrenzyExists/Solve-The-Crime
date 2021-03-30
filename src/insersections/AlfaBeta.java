package insersections;

import interfases.FSet;
import setImplementations.Set1;
import setImplementations.Set2;

/**
 * This is P1 and P2 in a single file
 */
public class AlfaBeta<T> extends IntersectionFinder<T>{
    public AlfaBeta(String name) {
        super(name);
    }


    /**
     * Intersects a family of sets.
     *
     * @param famSet array containing the family of sets to be intersected.
     * @return the final intersection set (the result of intersecting all sets in t)
     */
    @Override
    public FSet<T> intersectSets(FSet<T>[] famSet) {

        FSet<T> T;

        if (this.getName().equals("P2")) {
            T = new Set2<>();
        } else if (this.getName().equals("P1")) {
            T = new Set1<>();
        } else {
            System.out.println("You haven't input P1 nor P2, so, we will assume you meant P1 for the sake of simplicity");
            T = new Set1<>();
        }

        int counter;
        for (T t : famSet[0]) {
            counter = 0;
            for (FSet<T> j : famSet) {
                if (j.contains(t)) {
                    counter++;
                }
            }
            if (counter == famSet.length) {
                T.add(t);
            }
        }
        return T;
    }
}


