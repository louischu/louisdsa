package algomons.twopointers;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplications {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(0, 0, 1, 1, 1, 2, 2);
        System.out.println("Remove Duplicateds: " + removeDuplicates(integers));
    }

    //Input: [0, 0, 1, 1, 1, 2, 2].
    //Output: 3.
    public static int removeDuplicates(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        int slow = 0;
        for (int fast = 0; fast < arr.size(); fast++) {
            if (arr.get(fast) != arr.get(slow)) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        System.out.println("REMOVE DUPS: " + arr);
        return slow + 1;
    }
}
