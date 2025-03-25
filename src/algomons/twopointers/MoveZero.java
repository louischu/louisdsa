package algomons.twopointers;

import java.util.Arrays;
import java.util.List;

//Input:
//
//[1, 0, 2, 0, 0, 7]
//Output:
//
//[1, 2, 7, 0, 0, 0]
public class MoveZero {
    public static void moveZeros(List<Integer> nums) {
        // WRITE YOUR BRILLIANT CODE HERE
        int slow = 0;
        for (int fast = 0; fast < nums.size(); fast++) {
            if (nums.get(slow) == 0) {
                if (nums.get(fast) != 0) {
                    nums.set(slow, nums.get(fast));
                    nums.set(fast, 0);
                }
            } else {
                slow++;
            }
            /**
             * if (nums.get(fast) != 0) {
             *                 int slowNum = nums.get(slow);
             *                 nums.set(slow, nums.get(fast));
             *                 nums.set(fast, slowNum);
             *                 slow++;
             *             }
             */
        }
        System.out.println("Move Zeros: " + nums);
    }

    public static void main(String[] args) {
        moveZeros(Arrays.asList(1, 0, 2, 0, 0, 7));
    }
}
