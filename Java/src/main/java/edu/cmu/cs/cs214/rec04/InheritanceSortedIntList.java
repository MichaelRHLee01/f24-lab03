package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    // Write your implementation below with API documentation

    private int totalAdded;

    public InheritanceSortedIntList() {
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int element) {
        totalAdded++;
        return super.add(element);
    }

    @Override
    public boolean addAll(IntegerList elements) {
        // totalAdded += elements.size();
        return super.addAll(elements);
        // boolean modified = false; // Track if any elements were actually added
        // for (int i = 0; i < elements.size(); i++) {
        // if (add(elements.get(i))) { // Call add for each element individually
        // modified = true;
        // }
        // }
        // return modified;

    }

    public int getTotalAdded() {
        return totalAdded;
    }

}