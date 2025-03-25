package algomons.twopointers.slidewindow;

import java.util.Arrays;
import java.util.List;

/**
 * This time given a positive integer array nums,
 * we want to find the length of the shortest subarray such that the subarray sum is at least target.
 * Recall the same example with input nums = [1, 4, 1, 7, 3, 0, 2, 5] and target = 10,
 * then the smallest window with the sum >= 10 is [7, 3] with length 2. So the output is 2.
 */
public class FlexibleSizeWindowSmallest {
    private static int subarraySumShortest(List<Integer> nums, Integer target) {
        int windowSum = 0;
        int length = nums.size() + 1;
        int left = 0;
        for (int right = 0; right < nums.size(); ++right) {
            windowSum += nums.get(right);
            while (windowSum >= target) {
                length = Math.min(length, right - left + 1);
                windowSum -= nums.get(left);
                ++left;
            }
        }
        if (length > nums.size()) {
            return 0;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("X: " + subarraySumShortest(Arrays.asList(1, 4, 1, 7, 3, 0, 2, 5), 10));
    }
}
