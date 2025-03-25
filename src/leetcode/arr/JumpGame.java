package leetcode.arr;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {3, 2, 1, 0, 4};
        int[] arr3 = {2, 0};
        int[] arr4 = {2, 3, 0, 1, 4};
        int[] arr5 = {2, 3, 1};
        System.out.println("Can Jump: " + canJumpMy(arr1));
        System.out.println("Can Jump: " + canJumpMy(arr2));
        System.out.println("Can Jump: " + canJump(arr4));

        System.out.println("How many jump: " + jump(arr1));
        System.out.println("How many jump: " + jump(arr4));
        System.out.println("How many jump: " + jump(arr5));
    }

    /**
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int c = 0;
        int currentPos = 0;
        int longestStep = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            longestStep = Math.max(longestStep, nums[i] + i);
            if (currentPos == i) {
                c++;
                currentPos = longestStep;
            }
        }
        return c;
    }

    public static boolean canJumpMy(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            //System.out.println("I=" + i + ", K=" + k + ", Num+I=" + (nums[i] + i));
            if (i > k) return false;
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }

    //Using Greedy
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                System.out.println("I: " + i + ", Val: " + nums[i]);
                lastPos = i;
            }
        }
        return lastPos == 0;
//        boolean returnValue = false;
//        if (nums.length == 1) returnValue = true;
//        else {
//            int i = 0;
//            int jumpStep = nums[0];
//            while (i < nums.length) {
//                i += jumpStep;
//                if (i < nums.length)
//                    jumpStep = nums[i];
//                if (jumpStep == 0) {
//                    break;
//                }
//                System.out.println("I " + i);
//                if (i == nums.length - 1) {
//                    returnValue = true;
//                }
//            }
//
//        }
//        return returnValue;
    }
}
