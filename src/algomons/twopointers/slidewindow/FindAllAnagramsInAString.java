package algomons.twopointers.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: original = "abab", check = "ab"
 * <p>
 * Output: [0, 1, 2]
 * Input: original = "cbaebabacd", check = "abc"
 * <p>
 * Output: [0, 6]
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println("X: " + findAllAnagrams("cbaebabacd", "abc"));

    }

    public static List<Integer> findAllAnagrams(String original, String check) {
        // WRITE YOUR BRILLIANT CODE HERE
        int k = check.length();
        List<Integer> retVal = new ArrayList<>();
        char[] checkChars = check.toCharArray();
        Arrays.sort(checkChars);
        for (int right = k; right <= original.length(); ++right) {
            int left = right - k;
            String substring = original.substring(left, right);
            System.out.println("Sub: " + substring);
            char[] subChars = substring.toCharArray();
            Arrays.sort(subChars);
            if (Arrays.equals(checkChars, subChars)) {
                retVal.add(left);
            }
        }
        return retVal;
    }
}
