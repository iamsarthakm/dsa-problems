//BRUTE FORCE -> Generate all permutations and and store in list order and return back the next one to th egiven question
// Time Complexity O(n!)
// Space Complexity O(n)


// Optimal Solution

/* Steps To Follow
 * 1. Traverse from right and find the element which is greater than the next element.
 * 2. Store the index and if index is empty return reverse array
 * 3. Else 
 *      1. swap the smaller element(ind-1) to the next closest element in the right(ind+1,end), 
 *          condition the element should be greater than ind-1 and smaller than prev(ind) 
 *      2. reverse the array from ind to end
 * 
 * #Tough #revision
*/

class Solution {
    public void nextPermutation(int[] nums) {
        
        int ind = -1;
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                ind = i;
                break;
            }
        }
        
        if(ind == -1){
            reverse(nums,0,nums.length-1);
        }
        else{
            int prev = ind;
            
            for(int i=ind+1;i<nums.length;i++){
                
                if(nums[i]>nums[ind-1] && nums[i]<=nums[prev])
                    prev = i;
                
            }
            swap(nums,ind-1,prev);
            reverse(nums,ind,nums.length-1);
            
        }
    }
public void reverse(int[] nums, int start,int end){
    
    while(start<end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
    
}
public void swap(int []nums,int x,int y){
    
    int temp = nums[x];
    nums[x] = nums[y];
    nums[y] = temp;
    
}
    
}

/* 
 * Time Complexity O(N)
 * Space Complexity O(1)
*/