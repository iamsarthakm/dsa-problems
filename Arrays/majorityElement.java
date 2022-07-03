/*

https://leetcode.com/problems/majority-element/

#revision

Brute force-> Use hashmap and return the element wih freq greater than n/2

Optimal Approach -> Using Moore vote algorithm

we assume the first element as ans, if we encounter the element we increase the count else we decrease the count.
if the count becomes zero that means the ele and other ele are in equal number. and we need more than half.
So when count becomes zero we take the current ele as majority and check for the same.

Eg  7  7  5  2  || 5  5  6  5  7  2  || 7  7  5
        count 0     count 0               count 1

 */

//time complexity -> O(N)
 class majorityEl {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = nums[0];

        for(int i=0;i<nums.length;i++){
            
            if(count == 0){
              el = nums[i];  
            }
            
            if(el == nums[i])
                count++;
            else
                count--;
            
        }
        return el;
    }
}