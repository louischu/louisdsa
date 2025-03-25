package leetcode.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * ////
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement1(int[] nums) {
        int m = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            if (element.getValue() > nums.length / 2) {
                m = element.getKey();
                break;
            }
        }
        return m;
    }

    public static int majorityElement2(int[] nums) {
        int m = 0;
        int count = 0;
        int major = 0;
        for (int x : nums) {
            if (count == 0) {
                major = x;
                count = 1;
            }
            if (major == x) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
