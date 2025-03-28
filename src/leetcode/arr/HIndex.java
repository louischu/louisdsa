package leetcode.arr;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println("----------");
        System.out.println(hIndex(new int[]{2, 0, 6, 1, 1}));
        System.out.println("----------");
        System.out.println(hIndex(new int[]{1, 3, 1}));
        System.out.println("----------");
        System.out.println(hIndex(new int[]{1}));
    }

    public static int hIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        int n = citations.length;
        //System.out.println(": " + Arrays.toString(citations));
        int count = 1;
        for (int i = citations.length - 1; i >= 0; i--) {
            System.out.println("N=" + n + ", I=" + i + ", N-i: " + (n - i) + ", Cit[i]=" + citations[i] + ", Count: " + count);
            if (citations[i] != 0 && citations[i] >= (n - i)) {
                hIndex = count;
                System.out.println("Equals");
                //break;
            }
            count++;
        }
        return hIndex;
    }

    //sorting
    public static int hIndexEditor1(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }
}
