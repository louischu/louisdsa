package leetcode.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        //System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int c = 0;
        int sum = 0;
        int j = 0;
        int min = nums.length;
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("CURR SUM: " + sum + ", On I: " + i);

            while (sum >= target) {
                System.out.println("\tJ=" + j + ",Min: " + min + ", And I-J+1=" + (i - j + 1));
                min = Math.min(min, i - j + 1);
                sum -= nums[j];
                j++;
                found = true;
            }
        }

        return found ? min : 0;
    }
}
