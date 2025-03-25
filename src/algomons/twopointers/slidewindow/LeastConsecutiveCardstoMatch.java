package algomons.twopointers.slidewindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * For example, given cards = [3, 4, 2, 3, 4, 7],
 * then picking up [3, 4, 2, 3] makes a pair of 3s and picking up [4, 2, 3, 4] matches two 4s.
 * We need 4 consecutive cards to match a pair of 3s and 4 consecutive cards to match 4s,
 * so you need to pick up at least 4 cards to make a match.
 */
public class LeastConsecutiveCardstoMatch {
    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();
        int left = 0;
        int shortest = cards.size() + 1;
        for (int right = 0; right < cards.size(); ++right) {
            window.put(cards.get(right), window.getOrDefault(cards.get(right), 0) + 1);
            while (window.get(cards.get(right)) == 2) {
                shortest = Math.min(shortest, right - left + 1);
                window.put(cards.get(left), window.get(cards.get(left)) - 1);
                ++left;
            }
        }
        return shortest != cards.size() + 1 ? shortest : -1;
    }

    public static void main(String[] args) {
        System.out.println(leastConsecutiveCardsToMatch(Arrays.asList(3, 4, 2, 3, 4, 7)));
    }
}
