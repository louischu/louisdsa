package algomons;

import java.util.HashMap;
import java.util.Map;

//https://algo.monster/liteproblems/1
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = find(new int[]{1, 4, 8, 9, 3}, 17);
        System.out.println(ints[0] + "," + ints[1]);
    }

    static int[] find(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int currVal = arr[i];
            int compl = target - currVal;
            if (map.containsKey(compl)) {
                return new int[]{map.get(compl), i};
            }
            map.put(currVal, i);
        }
        return new int[]{0, 0};
    }
}
