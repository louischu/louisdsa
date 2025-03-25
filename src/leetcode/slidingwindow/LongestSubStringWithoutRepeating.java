package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        System.out.println("X: " + lengthOfLongestSubstring4(s));
        System.out.println("X: " + lengthOfLongestSubstring4(s2));
//        System.out.println("X: " + lengthOfLongestSubstring1("  "));
//        System.out.println("X: " + lengthOfLongestSubstring1("aa"));
//        System.out.println("X: " + lengthOfLongestSubstring1("a"));
        System.out.println("X: " + lengthOfLongestSubstring4("au"));
    }

    //My Version from Editor version 2
    public static int lengthOfLongestSubstring4(String s) {
        int c = 0;
        int n = s.length();
        Map<Character, Integer> chars = new HashMap();
        int i = 0;
        int j = 0;
        while (j < n) {
            if (chars.containsKey(s.charAt(j))) {
                i = Math.max(i, chars.get(s.charAt(j)));
            }
            chars.put(s.charAt(j), j + 1);

            c = Math.max(c, j - i + 1);
            j++;
        }

        return c;
    }

    //Editor version 2
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> charToNextIndex = new HashMap<>(); // index after current character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (charToNextIndex.containsKey(s.charAt(j))) {
                i = Math.max(charToNextIndex.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            charToNextIndex.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //Editor version 1
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> chars = new HashMap();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r, 0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int ret = 0;
        if (s == null) return 0;
        else if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            j = i + 1;
            Map<Character, Boolean> map = new HashMap<>();
            map.put(chars[i], true);
            int count = 1;
            while (j < chars.length) {
                //System.out.println(" :: " + map.containsKey(chars[j]));
                if (!map.containsKey(chars[j])) {
                    map.put(chars[j], true);
                    count++;
                } else {
                    break;
                }
                j++;
            }
            ret = Math.max(ret, count);
        }
        return ret;
    }
}
