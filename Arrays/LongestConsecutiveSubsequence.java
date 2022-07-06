/*
https://leetcode.com/problems/longest-consecutive-sequence/

Approach -> 

Store elements in a Hashset

Now iterate the array and check if the element has next element present in the hashset. if yes start a loop and check for the 
next element also.

Enter the loop only when the element you are checking from is min in the subsequence.
#revision

 */

import java.util.*;

class subsequence {
    public int longestConsecutive(int[] nums) {
    
        
    
        int max = 0;
        
        HashSet<Integer> set = new HashSet<>();
      
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++){
                
            if(!set.contains(nums[i]-1)){
             
                int currNum = nums[i];
                int c=1;
                while(set.contains(currNum+1)){
                    c++;
                    currNum++;
                }
                max = Integer.max(c,max);
                
            }
        }
        
        return max;
    }
}