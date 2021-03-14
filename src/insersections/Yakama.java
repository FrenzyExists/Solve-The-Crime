package insersections;

import interfases.FSet;
import setImplementations.Set2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This is P4
 * Yakama utilizes Set2, as part of the specifications given
 */
public class Yakama<T> extends Delta<T> {
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
     public FSet<T> intersectSets(FSet[] famSet) {

        ArrayList<T> allElements = toArrayList(famSet);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (T e : allElements) {
            Integer c = map.getOrDefault(e, 0);
            map.put((Integer) e, c+1);
        }
        FSet<T> T = new Set2<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == famSet.length)
                T.add((T) entry.getKey());

        return T;
    }
}
