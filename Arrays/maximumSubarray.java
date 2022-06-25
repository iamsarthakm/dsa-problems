/* 
  https://leetcode.com/problems/maximum-subarray/
 
 * Time complexity O(n)
 * 
 * Kadane's algorithm. add sum if becomes less than 0 reset it
*/

class Solution {
    public int maxSubArray(int[] nums) {
    
        int sum = 0;
        int max = nums[0];
        
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            max = Integer.max(sum,max);
            if(sum<0)
                sum=0;
        }
        return max;
    }
}