package algomons.twopointers;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array representing heights of vertical lines, find the maximum area of water trapped between two lines.
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7].
 * <p>
 * Output: 49.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Square: " + containerWithMostWater(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)));
    }

    public static int containerWithMostWater(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left = 0;
        int right = arr.size() - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(arr.get(left), arr.get(right)) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (arr.get(left) < arr.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
