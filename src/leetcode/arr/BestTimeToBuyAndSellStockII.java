package leetcode.arr;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("MaxProfit: " + maxProfitBruteforce(new int[]{7, 1, 6, 3, 6, 10}));
        System.out.println("MaxProfit: " + maxProfitBruteforce(new int[]{1, 2, 3, 4, 5}));

        System.out.println("MaxProfit2: " + maxProfitGreedy(new int[]{7, 1, 6, 3, 6, 10}));
        System.out.println("MaxProfit2: " + maxProfitGreedy(new int[]{1, 2, 3, 4, 5}));

        System.out.println("MaxProfit3: " + maxProfitOneByOne(new int[]{7, 1, 6, 3, 6, 10}));
        System.out.println("MaxProfit3: " + maxProfitOneByOne(new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */

    public static int maxProfitBruteforce(int[] prices) {
        return calculate(prices, 0);
    }

    public static int calculate(int prices[], int index) {
        if (index >= prices.length) return 0;
        int max = 0;
        for (int i = index; i < prices.length; i++) {
            int currMax = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = calculate(prices, j) + prices[j] - prices[i];
                    if (currMax < profit) {
                        currMax = profit;
                    }
                }
            }
            if (max < currMax) max = currMax;
        }
        return max;
    }

    public static int maxProfitPeak(int prices[]) {
        int i = 0;
        int max = 0;
        while (i < prices.length) {

            i++;
        }
        return max;
    }

    public static int maxProfitGreedy(int prices[]) {
        int max = 0;
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > start) {
                //System.out.println("I=" + i + ", Val: " + prices[i]);
                max += prices[i] - start;
            }
            start = prices[i];
        }
        return max;
    }

    public static int maxProfitOneByOne(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit +=
                        prices[i] - prices[i - 1];
                System.out.println("I=" + i + ",ValI=" + prices[i] + ",ValI-1=" + prices[i - 1] + ", Minus: " + (prices[i] - prices[i - 1]));
            }
        }
        return maxprofit;
    }

}
