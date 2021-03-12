package solutionMethods;

import interfases.FSet;
import main.IntersectionFinder;
import setImplementations.Set2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is P4
 * Yakama utilizes Set2, as part of the specifications given
 */
public class Yakama extends Delta {
    public Yakama(String name) {
        super(name);
    }

    public Yakama() {
        super("P4");
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

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer e : allElements) {
            Integer c = map.getOrDefault(e, 0);
            map.put(e, c+1);
        }
        FSet<Integer> T = new Set2<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == famSet.length)
                T.add(entry.getKey());

        System.out.println(T);
        return T;
    }
}

/*
HashMap<Integer, Integer> map = new HashMap<>();
for (Integer e : allElements) {
     Integer c = map.getOrDefault(e, 0);
     map.put(e, c+1);
}
MySet2<Integer> t = new Set2<>();
for (Map.Entry<Integer, Integer> entry : map.entrySet())
     if (entry.getValue() == m)
        t.add(entry.getKey());
 */