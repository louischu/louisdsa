package leetcode.twopointers;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println("ThreeSum: " + threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("ThreeSum: " + threeSum2(new int[]{-2, 0, 1, 1, 2}));
        System.out.println("ThreeSum: " + threeSumPrefixSum(new int[]{-2, 0, 1, 1, 2}));
    }

    public static List<List<Integer>> threeSumPrefixSum(int[] nums) {
        List<List<Integer>> retVal = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                twoSum(nums, i, retVal);
            }
        }
        return retVal;
    }

    //Using prefixSum:
    static void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) ++j;
            }
            seen.add(nums[j]);
        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> retVal = new ArrayList<>();
        Arrays.sort(nums);
        Map<String, Boolean> added = new HashMap<>();
        //System.out.println("Sorted: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = val + nums[j] + nums[k];
                if (sum == 0) {
                    int[] arr = {val, nums[j], nums[k]};

                    retVal.add(Arrays.asList(val, nums[j], nums[k]));
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
//                if (i == j) j++;
//                if (i == k) k--;
            }
            //System.out.println("Loop-I: " + i);
        }

        return retVal;
    }

    public static List<List<Integer>> threeSumSomeone(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> retVal = new ArrayList<>();
        Map<String, Boolean> added = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        int[] arr = {nums[i], nums[j], nums[k]};
                        Arrays.sort(arr);
                        String s = Arrays.toString(arr);
                        if (added.containsKey(Arrays.toString(arr))) {
                        } else {
                            retVal.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            added.put(s, true);
                        }
                    }
                }
            }
        }
        return retVal;
    }
}
