package leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDup {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3, 4, 5, 5, 6));
        System.out.println(removeDup1_1(arr));
    }

    public static int removeDup1_1(List<Integer> list) {
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                //list.set(k, list.get(i));
                list.remove(k);
                k++;
            }
        }
        System.out.println(list);
        return k;
    }
}
