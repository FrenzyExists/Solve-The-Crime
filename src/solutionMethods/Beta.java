package solutionMethods;

import interfases.FSet;
import main.IntersectionFinder;
import setImplementations.Set1;
import setImplementations.Set2;

import java.util.Iterator;

/**
 * This is P2
 * Beta utilizes Set2, as part of the specifications given
 */
public class Beta extends IntersectionFinder {

    public Beta(String name) {
        super(name);
    }

    public Beta() {
        super("P2");
    }

    /**
     * Intersects a family of sets.
     *
     * @param famSet array containing the family of sets to be intersected.
     * @return the final intersection set (the result of intersecting all sets in t)
     */
    @Override
    public FSet intersectSets(FSet[] famSet) {

        Set2<Object> T = new Set2<>();

        int counter;
        Iterator<Object> iter = famSet[0].iterator();
        while(iter.hasNext()) {
            counter = 0;
            Object target = iter.next();
            for (FSet j : famSet) {
                if (j.contains(target)) {
                    counter++;
                }
            }
            if (counter == famSet.length) {
                T.add(target);
            }
        }
        System.out.println(T); // Some output test
        return T;
    }
}
