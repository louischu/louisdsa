package algomons.twopointers.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: abccabcabcc
 * <p>
 * Output: 3
 * <p>
 * Explanation: The longest substrings are abc and cab, both of length 3.
 * <p>
 * Input: aaaabaaa
 * <p>
 * Output: 2
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println("Start: " + longestSubstringWithoutRepeatingCharacters("abccabcabcc"));
        System.out.println("Start: " + longestSubstringWithoutRepeatingCharacters("aba"));
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        int left = 0;
        int max = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); ++right) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            System.out.println("A");
            while (window.get(s.charAt(right)) > 1) {
                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                left++;
                System.out.println("X");
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
