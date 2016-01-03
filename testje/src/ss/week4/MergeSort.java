package ss.week4;

import java.util.*;

/**
 * Class MergeSort.
 * @author Saul
 *
 */
public class MergeSort {
	
	/**
	 * Method mergesort.
	 * Splits the list up (recursively)
	 * @param list to be sorted
	 */
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
    	List<Elem> left = new ArrayList<Elem>();
        List<Elem> right = new ArrayList<Elem>();
        int center;
 
        if (list.size() != 1 && list.size() != 0) {
            center = list.size() / 2;
            for (int i = 0; i < center; i++) {
                left.add(list.get(i));
            }
            for (int i = center; i < list.size(); i++) {
                right.add(list.get(i));
            }
            mergesort(left);
            mergesort(right);
            
            merge(left,right,list);
        }
    }
    
    /**
     * Method merge.
     * Merges two halves together
     * @param left
     * @param right
     * @param whole
     */
    public static <Elem extends Comparable<Elem>> void merge(List<Elem> left, List<Elem> right, List<Elem> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
        
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex)))<0) {
                whole.set(wholeIndex,left.get(leftIndex));
                leftIndex++;
            }
            else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        List<Elem> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        }
        else {
            rest = left;
            restIndex = leftIndex;
        }
        
        for (int i = restIndex; i < rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
}
