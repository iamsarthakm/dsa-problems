/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * track the min price to buy. we iterate through the array take max profit
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int min =prices[0];
        
        for(int i=0;i<prices.length;i++){
            int profit = prices[i] - min;
            max = Integer.max(max,profit);
            
            if(prices[i]<min)
                min = prices[i];
        }
        
       return max; 
    }
}