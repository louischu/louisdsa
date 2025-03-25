package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * <p>
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * <p>
 * Output: [0,9]
 * <p>
 * Explanation:
 * <p>
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 */
public class SubStringWithConcatWords {
    public static void main(String[] args) {
//        System.out.println("FIND: " + findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println("FIND: " + findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
//        System.out.println("FIND: " + findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println("FIND: " + findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        //System.out.println("FIND: " + findSubstring("ababaab", new String[]{"ab", "ba", "ba"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int n = 0;

        for (String word : words) {
            n += word.length();
        }
        Arrays.sort(words);
        //System.out.println("N: " + n + ", S length: " + s.length());
        for (int i = 0; i < s.length(); i++) {
            int j = i + n;

            if (j <= s.length()) {
                String sub = s.substring(i, j);

                String[] subArr = new String[words.length];
                for (int z = 0; z < subArr.length; z++) {
                    subArr[z] = sub.substring(z * words[0].length(), z * words[0].length() + words[0].length());
                }
                //System.out.println("SUB: " + sub + ", Array: " + Arrays.toString(subArr));
                Arrays.sort(subArr);
                if (Arrays.equals(words, subArr)) {
                    ret.add(i);
                }
            }

        }
        return ret;
    }
}
