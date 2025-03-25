package algomons.twopointers.slidewindow;

import java.util.List;

public class SubArraySum {
    private static int subarraySumFixed1(List<Integer> nums, Integer k) {
        int windowSum = 0;
        for (int i = 0; i < k; ++i) {
            windowSum += nums.get(i);
        }
        int largest = windowSum;
        for (int right = k; right < nums.size(); ++right) {
            int left = right - k;
            windowSum -= nums.get(left);
            windowSum += nums.get(right);
            largest = Math.max(largest, windowSum);
        }
        return largest;
    }

}
