package solutionMethods;

import interfases.FSet;
import main.IntersectionFinder;
import setImplementations.Set2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * This is P3
 * Delta utilizes Set2, as part of the specifications given
 */
public class Delta extends IntersectionFinder {
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
    public FSet intersectSets(FSet[] famSet) {
        ArrayList<Integer> allElements = toArrayList(famSet);
        allElements.sort(null);
        FSet<Object> T = new Set2<>();
        Integer meep = allElements.get(0);
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
        System.out.println(counter);
        if (counter == famSet.length) {
            T.add(meep);
        }
        System.out.println(T);
        return T;
    }

    public ArrayList<Integer> toArrayList(FSet[] famSet) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int index = 0 ; index < famSet.length ; index++) {
            Iterator<Object> iter = famSet[index].iterator();
            while (iter.hasNext()) {
                arr.add((Integer) iter.next());
            }
        }
        return arr;
    }

}
