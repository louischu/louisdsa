package algomons.twopointers.slidewindow;

import java.util.Arrays;
import java.util.List;

/**
 * Given input nums = [1, 6, 3, 1, 2, 4, 5] and target = 10,
 * then the longest subarray that does not exceed 10 is [3, 1, 2, 4],
 * so the output is 4 (length of [3, 1, 2, 4]).
 */
public class FlexibleSizeSlidingWindowLongest {
    public static void main(String[] args) {
        System.out.println(" XX: " + subarraySumLongest(Arrays.asList(1, 6, 3, 1, 2, 4, 5), 10));
    }

    public static int subarraySumLongest(List<Integer> nums, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        int sum = 0;
        int left = 0;
        int right = 0;
        int longest = 0;
        while (left <= right && right < nums.size()) {
            //System.out.println("LEFT : " + left + ", RIGHT: " + right + ", SUM: " + sum);
            if (sum == target) {
                longest = Math.max(longest, right - left);
                sum -= nums.get(left);
                sum += nums.get(right);
                left++;
                right++;
            } else if (sum > target) {
                sum -= nums.get(left);
                left++;
            } else {
                sum += nums.get(right);
                right++;
            }
        }
        return longest;
    }

    private static int subarraySumLongestProviedSolution(List<Integer> nums, Integer target) {
        int windowSum = 0;
        int length = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); ++right) {
            windowSum += nums.get(right);
            while (windowSum > target) {
                windowSum -= nums.get(left);
                ++left;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

}
