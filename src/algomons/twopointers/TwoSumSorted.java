package algomons.twopointers;

import java.util.Arrays;
import java.util.List;

/**
 * Input:
 * <p>
 * arr: a sorted integer array
 * target: the target sum we want to reach
 * Sample Input: [2, 3, 4, 5, 8, 11, 18], 8
 * <p>
 * Sample Output: 1 3
 */
public class TwoSumSorted {
    public static void main(String[] args) {
        System.out.println("Two Sums: " + twoSumSorted(Arrays.asList(2, 3, 4, 5, 8, 11, 18), 8));
    }

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int l = 0;
        int r = arr.size() - 1;
        while (l < r) {
            int twoSum = arr.get(l) + arr.get(r);
            if (target == twoSum) {
                return List.of(l, r);
            } else if (twoSum > target) {
                r--;
            } else {
                l++;
            }
        }
        return List.of();
    }
}
