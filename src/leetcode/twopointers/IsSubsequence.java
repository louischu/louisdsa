package leetcode.twopointers;

/**
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println("Is Sub: " + isSubsequence("abc", "ahbgdc"));
        System.out.println("Is Sub: " + isSubsequence("axc", "ahbgdc"));
        System.out.println("Is Sub: " + isSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        boolean ret = true;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int j = 0;
        for (int i = 0; i < sChars.length; i++) {
            boolean found = false;
            while (j < tChars.length) {
                if (sChars[i] == tChars[j]) {
                    found = true;
                    j++;
                    break;
                }
                j++;
            }
            if (!found) {
                ret = false;
                break;
            }
        }
        return ret;
    }

}
