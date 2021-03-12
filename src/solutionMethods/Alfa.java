package solutionMethods;

import interfases.FSet;
import main.IntersectionFinder;
import setImplementations.Set1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is P1
 * Alfa utilizes Set1, as part of the specifications given
 */

public class Alfa extends IntersectionFinder {

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
    public FSet intersectSets(FSet[] famSet) throws CloneNotSupportedException {
        Set1<Object> T = (Set1<Object>) famSet[0];
        Set1<Object> T0 = (Set1<Object>) T.clone();
        System.out.println(T);

        for (FSet j : famSet) {
            for (Object x : T0) {
                if (!j.contains(x)) {
                    T.remove(x);
                }
            }
        }

        return T;
    }


}
