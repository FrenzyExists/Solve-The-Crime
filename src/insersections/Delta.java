package insersections;

import interfases.FSet;
import setImplementations.Set2;

import java.util.ArrayList;

/**
 * This is P3
 * Delta utilizes Set2, as part of the specifications given
 */
public class Delta<T> extends IntersectionFinder {
    public Delta(String name) {
        super(name);
    }

    public Delta() {
        super("P3");
    }

    /**
     * Intersects a family of sets.
     *
     * @param famSet array containing the family of sets to be intersected.
     * @return the final intersection set (the result of intersecting all sets in t)
     */
    @Override
    public FSet<T> intersectSets(FSet[] famSet) {
        ArrayList<T> allElements = toArrayList(famSet);
        allElements.sort(null);
        FSet<T> T = new Set2<>();
        T meep = allElements.get(0);
        int counter = 1;

        for (int i=1 ; i < allElements.size() ; i++) {

            if (allElements.get(i).equals(meep)) {
                counter++;
            } else {
                if (counter == famSet.length) {
                    T.add(meep);
                }
                meep = allElements.get(i);
                counter = 1;
            }
        }
        if (counter == famSet.length) {
            T.add(meep);
        }
        return T;
    }

    public ArrayList<T> toArrayList(FSet[] famSet) {
        ArrayList<T> arr = new ArrayList<>();
        for (FSet<T> fSet : famSet) {
            for (T t : fSet) {
                arr.add(t);
            }
        }
        return arr;
    }

}
