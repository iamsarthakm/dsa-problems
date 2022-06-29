/* 

Time complexity O(N)

https://leetcode.com/problems/sort-colors/

*/
//#revision
class Solution {
    public void sortColors(int[] nums) {
    
        int low = 0;
        int ind = 0;
        int high = nums.length-1;
        
        while(ind<=high){
            
            if(nums[ind]==2){
                swap(nums,ind,high);
                high--;
            }
            else if(nums[ind]==0){
                swap(nums,ind,low);
                ind++;
                low++;
            }
            else
                ind++;
            
        }     
        
    }
public void swap(int[] nums,int x,int y){
    int temp = nums[x];
    nums[x] =nums[y];
    nums[y] = temp;
}
}