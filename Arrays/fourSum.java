/*
 https://leetcode.com/problems/4sum/

 Space complexity O(1)


 Time Complexity O(N3)
 
 Approach -> take i and j steady and use left and right pointers

 #revision
 */
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                
                long target2 = (long)target - (long)nums[i] - (long)nums[j];
                int left = j+1;
                int right = nums.length-1;
                
                while(left<right){
                    
                    long two_sum = (long)nums[left] + (long)nums[right];
                    
                    if(two_sum > target2)
                        right--;
                    else if(two_sum < target2)
                        left++;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        
                        while(left<right && list.get(2) == nums[left])
                            left++;
                        while(left<right && list.get(3) == nums[right])
                            right--;
                    }
                    
                }
                
                while(j+1<nums.length && nums[j]==nums[j+1])
                    j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1])
                    i++;
        }
        
        return res;
        
    }
}