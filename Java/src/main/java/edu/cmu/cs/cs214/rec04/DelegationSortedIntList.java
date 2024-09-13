package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private int totalAdded;

    private final SortedIntList delegate;

    public DelegationSortedIntList() {
        this.totalAdded = 0;
        this.delegate = new SortedIntList();
    }

    @Override
    public boolean add(int element) {
        totalAdded++;
        return delegate.add(element);
    }

    @Override
    public boolean addAll(IntegerList elements) {
        totalAdded += elements.size();
        return delegate.addAll(elements);
    }

    @Override
    public int get(int index) {
        return delegate.get(index);
    }

    @Override
    public boolean remove(int element) {
        return delegate.remove(element);
    }

    @Override
    public boolean removeAll(IntegerList elements) {
        return delegate.removeAll(elements);
    }

    @Override
    public int size() {
        return delegate.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    /*
     * Questions and answers for lab 03:
     * 01. Which is more dependent on the implementation details of the
     * SortedIntList, delegation or inheritance?
     * A1: Inheritance is more dependent on the implementation details of
     * SortedIntList.
     * This is because changes to the SortedIntList class can directly impact the
     * InheritanceSortedIntList class due to the inheritance relationship.
     * 
     * 02. If the add method in SortedIntList is significantly modified or its
     * behavior changes, which implementation is more likely to break?
     * A2. The inheritance-based implementation is more likely to break if add is
     * modified, as it directly overrides the add method of SortedIntList. The
     * delegation-based implementation would be less affected because it simply
     * delegates the method call.
     * 
     * 03. What issues does using delegation solve that might have been problematic
     * with inheritance?
     * A3. Delegation provides more flexibility and isolates the
     * DelegationSortedIntList
     * from internal changes in SortedIntList. Inheritance tightly couples the two
     * classes, whereas delegation allows you to change the implementation of the
     * delegated class without affecting the delegator.
     * 
     * 04. When would it be more appropriate to use inheritance and when to use
     * delegation?
     * Use inheritance when you want to leverage or extend the functionality of an
     * existing class and don't expect its implementation to change often. Use
     * delegation when you want more flexibility, or when you want to combine
     * functionality from different classes without tightly coupling them.
     */

}