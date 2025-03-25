package leetcode.arr;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("MaxProfit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        System.out.println("MaxProfit: " + maxProfit(new int[]{2, 8, 3, 5, 6, 4}));
        System.out.println("MaxProfit: " + maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println("MaxProfit: " + maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
        System.out.println("MaxProfit: " + maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

    public static int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minProfit) {
                minProfit = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minProfit);
            }
        }
        return maxProfit;
    }

    
}
