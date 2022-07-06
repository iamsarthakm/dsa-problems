/*
 Brute Force 

 Time complexity -> O(N^2)
 Space complexity -> O(1)

 */
import java.util.*;
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        int max_len = 0;
        for(int i=0;i<n;i++){
            int sum =arr[i];
            for(int j=i+1;j<n;j++){
                
                sum = sum + arr[j];
                
                if(sum == 0){
                    max_len = Integer.max(max_len,j-i+1);
                }
                
            }
        }
        return max_len;
    }
}

/*
 Optimal Approach -> 

 write sum along with array

INDEX   0     1   2   3   4      5      6
        15   12  -5   6   7     -35    28  
SUM     15   27   22  28  35     0     28

Length = 3 -> 6 - 3 , (Current Index - index of existing sum)

Now we when the sum appears same on diff indexes that means the elements between them has zero sum. -> 7 -35 28
 */

class ZeroSum
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;    
        int max_len = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(sum == 0)
                max_len = Integer.max(max_len,i+1);
            else if(!map.containsKey(sum))
                map.put(sum,i);
            else{
                max_len = Integer.max(max_len,i-map.get(sum));
            }
        }
        
     
        
        return max_len;
    }
}