package leetcode.twopointers;

import java.util.Arrays;

//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
public class TwoSumII {
    public static void main(String[] args) {
        System.out.println("TwoSum: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("TwoSum: " + Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println("TwoSum: " + Arrays.toString(twoSum(new int[]{-1, 0}, -1)));

        System.out.println("TwoSum2: " + Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int[] arr = {0, 0};
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            System.out.println("I = " + i + ", J=" + j + "," + (numbers[i] + "::" + numbers[j]));
            if (target == (numbers[i] + numbers[j])) {
                arr = new int[]{i + 1, j + 1};
                break;
            } else if (target < (numbers[i] + numbers[j])) {
                j--;
            } else {
                i++;
            }
        }
        return arr;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] arr = {0, 0};
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            while (j < numbers.length) {
                if (target == (numbers[i] + numbers[j])) {
                    arr = new int[]{i + 1, j + 1};
                    found = true;
                    break;
                }
                j++;
            }
            if (found) break;
        }
        return arr;
    }
}
