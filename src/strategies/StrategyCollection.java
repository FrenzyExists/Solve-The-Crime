package strategies;

import interfases.FSet;
import interfases.IntersectionFinder;

import java.util.ArrayList;
import java.util.Map;


/**
 * @param <T>
 *
 * An object of this type will contain the results of random experiments
 * to estimate the average execution time per size of a particular strategy.
 * It also stores the partial sum of the times that the particular strategy
 * has taken during the experimental trials.
 *
 * An object of this type will embed a particular strategy. When that particular
 * strategy is executed from an ExperimentController object, this object will
 * contain the computed average execution times for each input size that it
 * has experimented with.
 *
 * Notice that this is implemented as a subclass of
 * IndexList<Map.Entry<Integer, Float>>
 *
 */
public class StrategyCollection<T> extends ArrayList<Map.Entry<Integer, Float>> {
    private float sum;
    private IntersectionFinder<T> strategy;

    public StrategyCollection(IntersectionFinder<T> strategy) {
        this.strategy = strategy;
    }

    /**
     *
     * @param data
     */
    public void runTrial(FSet<T>[] data) throws CloneNotSupportedException {
        strategy.intersectSets(data);
    }

    /**
     *
     */
    public void resetSum() {
        sum = 0.0f;
    }

    /**
     *
     * @param estimatedTime
     */
    public void incSum(float estimatedTime) {
        sum += estimatedTime;
    }



    /**
     *
     * @return
     */
    public float getSum() {
        return sum;
    }

    /**
     *
     * @return
     */
    public String getStrategyName() {
        return strategy.getName();
    }
}
