package algomons.twopointers;

/**
 * Determine whether a string is a palindrome, ignoring non-alphanumeric characters and case. Examples:
 * <p>
 * Input: Do geese see God? Output: True
 * <p>
 * Input: Was it a car or a cat I saw? Output: True
 * <p>
 * Input: A brown fox jumping over Output: False
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Is Palindrome: " + isPalindrome("Do geese see God"));
    }

    public static boolean isPalindrome(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        String ns = s.toLowerCase();
        int left = 0;
        int right = ns.length() - 1;
        while (left < right) {
            while (left < right && ns.charAt(left) == ' ') {
                left++;
            }
            while (left < right && ns.charAt(right) == ' ') {
                right--;
            }
            if (ns.charAt(left) != ns.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
