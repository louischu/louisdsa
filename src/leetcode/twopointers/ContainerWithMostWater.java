package leetcode.twopointers;

/**
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + maxArea(arr1));
        System.out.println("Max Area: " + maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int lower = Math.min(height[i], height[j]);
            max = Math.max(max, lower * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

}
