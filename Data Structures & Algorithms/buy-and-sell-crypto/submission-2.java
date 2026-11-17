class Solution {
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int maxProfit = 0;

        for(int i : prices) {
            int profit = i - minCost;
            if(profit > maxProfit) {
                maxProfit = profit; 
            }
            if (i < minCost) {
                minCost = i;
            }
        }

        return maxProfit;
    }
}
