package leetcode.twopointers;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is Palin: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s != null && s.length() == 1) {
            return true;
        } else {
            boolean ret = true;
            int left = 0;
            char[] chars = s.toLowerCase().toCharArray();
            int right = s.length() - 1;
            while (left < right) {
                if (!Character.isLetterOrDigit(chars[left])) {
                    left++;
                } else if (!Character.isLetterOrDigit(chars[right])) {
                    right--;
                } else if (chars[left] == chars[right]) {
                    left++;
                    right--;
                } else {
                    ret = false;
                    break;
                }
            }

            return ret;
        }
    }
}
