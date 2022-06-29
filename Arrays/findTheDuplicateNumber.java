/* 
 https://leetcode.com/problems/find-the-duplicate-number/

 Time complexity O(N)

 Brute force -> freq HashMap or double for loop 
 Approach. Range of elements are within index 

 we can take element and mark arr[element] -ve. SO if there is a negative element the index value is going to be negative. 
*/

class Solution {
    public int findDuplicate(int[] nums) {
        
        
        for(int i=0;i<nums.length;i++){
            
            int ind = Math.abs(nums[i]);
            
            if(nums[ind]<0)
                return ind;
            else
                nums[ind] = nums[ind]*-1;
            
        }
        
        return -1;
    }
}