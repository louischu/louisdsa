package algomons.twopointers.prefixsum;

import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers and an integer target, find a subarray that sums to target and return the start and end indices of the subarray.
 * <p>
 * Input: arr: 1 -20 -3 30 5 4 target: 7
 * <p>
 * Output: 1 4
 * <p>
 * Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive).
 */
public class FirstPrefixSum {
    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // prefix_sum 0 happens when we have an empty array
        prefixSums.put(0, 0);
        int curSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                return List.of(prefixSums.get(complement), i + 1);
            }
            prefixSums.put(curSum, i + 1);
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
