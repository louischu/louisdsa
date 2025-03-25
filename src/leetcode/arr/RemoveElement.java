package leetcode.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        int[] arr0 = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        System.out.println("RemoveDup: " + removeDuplicate1_1(arr0));
        System.out.println("-----");
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        System.out.println(removeDuplicates2_3(arr));

        arr = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates2_3(arr));
    }

    public static int removeElement(int[] nums, int val) {
//        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        return i;

    }

    public static int removeDuplicate1_1(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println("Arr: " + Arrays.toString(nums));
        return k;
    }

    //Input: nums = [0,0,1,1,1,1,2,3,3]
    //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    public static int removeDuplicates2_1(int[] nums) {
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1 || map.get(nums[i]) == 2) {
                k++;
                slow++;
            } else {
                System.out.println("X: " + ", K+1=" + (k + 1) + ", I = " + i + ", ValI: " + nums[i]);
                //nums[k + 1] = nums[i];
            }
        }
        System.out.println("Arr: " + Arrays.toString(nums));
        return k;

    }

    public static int removeDuplicates2_2(int[] nums) {
        System.out.println("ArrBefore:" + Arrays.toString(nums));
        // int ele= nums[0];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1 || nums[i - 2] != nums[i]) {
                //System.out.println("I=" + i + ", K=" + k + ", Nums[i]=" + nums[i]);
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println("ArrAfter: " + Arrays.toString(nums));
        return k;

    }

    public static int removeDuplicates2_3(int[] nums) {
        System.out.println("ArrBefore:" + Arrays.toString(nums));
        int count = 0, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count = 0;
                System.out.println("--#Value: " + nums[i] + "Count: " + count + ", i=" + i + ", current: " + current);
                nums[current++] = nums[i];
            } else {
                count++;
                System.out.println("++#Value: " + nums[i] + "Count: " + count + ", i=" + i + ", current: " + current);
                if (count <= 1) nums[current++] = nums[i];
            }
        }
        System.out.println("ArrAfter: " + Arrays.toString(nums));
        return current;

    }
}
