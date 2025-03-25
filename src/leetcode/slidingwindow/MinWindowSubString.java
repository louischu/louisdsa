package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        //System.out.println("MIN: " + minWindow(s, t));
        String s1 = "ab", t1 = "b";
        //System.out.println("MIN: " + minWindow(s1, t1));
        //System.out.println("ab".substring(1, 2));
        //System.out.println("MIN: " + minWindow("abc", "ac"));
        //System.out.println("MIN: " + minWindow("a", "b"));
        //System.out.println("MIN: " + minWindow("bbaa", "aba"));
        //System.out.println("MIN: " + minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));

        //System.out.println("XX: " + found("bba", "aba"));
        System.out.println("XX: " + found("abbbbbcdd", "abcdd"));
    }

    //My Version
    public static String minWindow(String s, String t) {
        String ret = "";
        if (s.length() < t.length()) {
            return ret;
        } else if (s.equals(t)) {
            return s;
        } else {
            int start = 0;
            int end = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < s.length() - t.length() + 1; i++) {
                int movement = i + t.length();
                int length = Integer.MAX_VALUE;
                while (movement <= s.length()) {
                    String findMe = s.substring(i, movement);
                    System.out.println("I = " + i + ", FindMe: " + findMe + ", Movement: " + movement + ", MIN: " + min);
                    if (found(findMe, t)) {
                        System.out.println("FOUND");
                        length = findMe.length();
                        break;
                    }
                    movement++;
                }
                if ((length) < min) {
                    min = length;
                    start = i;
                    end = movement;
                }

            }
            System.out.println("MIN: " + min + ", Start: " + start + ", End: " + end);
            //System.out.println("Sub: " + s.substring(start, end));
            ret = s.substring(start, end);

        }
        return ret;
    }

    /**
     * No done:
     * //            int left = 0;
     * //            int right = left;
     * //            char[] chars = t.toCharArray();
     * //
     * //            Map<Character, Integer> map = new HashMap<>();
     * //            for (char c : chars) {
     * //                map.put(c, map.getOrDefault(c, 0) + 1);
     * //            }
     * //            System.out.println("MapT: " + map);
     * //            int start = 0;
     * //            int end = 0;
     * //            int min = s.length();
     * //            //for (left = 0; left < s.length() - tLength; left++) {
     * //            Map<Character, Integer> countMap = new HashMap<>(map);
     * //            while (right < s.length()) {
     * //                if (countMap.containsKey(s.charAt(right))) {
     * //                    //System.out.println("Contains: " + s.charAt(right));
     * //                    countMap.put(s.charAt(right), countMap.get(s.charAt(right)) - 1);
     * //                    if (countMap.getOrDefault(s.charAt(right), 0) == 0) {
     * //                        System.out.println("=0: " + s.charAt(right));
     * //                        countMap.remove(s.charAt(right));
     * //                    }
     * //                }
     * //                System.out.println("IS EMPTY: " + countMap.isEmpty() + ", left = " + left + ", right: " + right);
     * //                if (countMap.isEmpty()) {
     * //                    if ((right - left + 1) < min) {
     * //                        start = left;
     * //                        end = right + 1;
     * //                        min = right - left + 1;
     * //                        System.out.println("Start: " + start + ", End: " + end + ", MIN: " + min);
     * //                        System.out.println(s.substring(start, end));
     * //                    }
     * //                    left = right;
     * //                    countMap.putAll(map);
     * //                }
     * //                right++;
     * //            }
     * //            //}
     */

    ////Finding
    public static boolean found(String s, String toFind) {

        char[] toFindChars = toFind.toCharArray();
        boolean ret = false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> toFindMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < toFind.length(); i++) {
            toFindMap.put(toFind.charAt(i), toFindMap.getOrDefault(toFind.charAt(i), 0) + 1);
        }
        int c = 0;
        for (Map.Entry<Character, Integer> entry : toFindMap.entrySet()) {
            int countToFind = entry.getValue();
            int countS = mapS.getOrDefault(entry.getKey(), 0);

            if (countS >= countToFind) {
                c++;
            }
        }

        if (c == toFindMap.size()) ret = true;
        return ret;
    }
}
