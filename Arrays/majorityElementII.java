/*
    #revision

    Time complexity -> O(N)

    Approach-> Using moore voting algo we find out two majority elements. 
    Then we iterate the majority elements and check their count is greater than n/3. 

    The point here to note is there only can be two majority elements. SO we need to track count of only two.


 */

import java.util.*;

public class majorityElementII {
        public List<Integer> majorityElement(int[] nums) {
            
            List<Integer> list = new ArrayList<>();
            
            int maj1 = -1;
            int maj2  = -1;
            int c1=0,c2=0;
            
            for(int i=0;i<nums.length;i++){
                
                if(nums[i] == maj1)
                    c1++;
                else if(nums[i]==maj2)
                    c2++;
                else if(c1==0){
                    maj1=nums[i];
                    c1 = 1;
                }
                else if(c2==0){
                    maj2=nums[i];
                    c2=1;
                }
                else{
                    c1--;
                    c2--;
                }
                
            }
            c1=0;
            c2=0;
    
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == maj1)
          c1++;
        else if (nums[i] == maj2)
          c2++;
      }
            
            if(c1>nums.length/3)
                list.add(maj1);
            if(c2>nums.length/3)
                list.add(maj2);
            
            return list;
            
        }
    
}
