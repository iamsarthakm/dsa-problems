/*
 Brute force

 Edge case-> we need to calculate 2*element. so we need a long data type
 */
import java.util.*;

 class Pairs{

        public int reversePairs(int[] nums) {
         
            int c=0;
            
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    long i_e = nums[i];
                    long j_e = nums[j];
                    if(i_e>2*j_e)
                        c++;
                }
            }
            return c;
        }

}

/*
 
Approach -> we do the normal merge sort but before merging two sorted arrays we equate 

#revsion #tough

Explanation
Eg -

 left_array = 12  19  25  40   
 right_array = 2   6  9


for every value of left array we check if left[i] = 2*right[j]
but we do not initialize j every time. since if 12 is greater than j than 19 will be also be greater naturally

Time complexity - O(nLogn)
Space complexity - o(n)
 */

class ReverseSolution {
    public int reversePairs(int[] nums) {
    
        return countReversePairs(nums,0,nums.length-1);
    
    }

    public int countReversePairs(int[] nums,int low,int high){
       
        if(low>=high)
            return 0;
       
            int mid = low + (high-low)/2;
    
            int count = countReversePairs(nums,low,mid);
            count+= countReversePairs(nums,mid+1,high);
            count+= mergeFunction(nums,low,mid,high);
        
    return count;
    }

    public int mergeFunction(int[] nums,int low,int mid,int high){
    
        int count = 0;
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            while( j<=high && nums[i]>(2*(long)nums[j]) ){
              j++;  
            } 
            
            count += j-(mid+1); 
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int left = low, right = mid+1;
        
        while(left<=mid && right<=high){
            if(nums[left]>nums[right])
                list.add(nums[right++]);
                else
                list.add(nums[left++]);
            
        }
        while(left<=mid)
            list.add(nums[left++]);
        while(right<=high)
            list.add(nums[right++]);
        
        for(int i=low;i<=high;i++){
            nums[i] = list.get(i-low);
        }
    return count;
    }
}
