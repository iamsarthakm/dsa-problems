/*

https://leetcode.com/problems/unique-paths/
 Using recursion and dp.

 Approach moving either down or right and need all the paths.

 Time complexity -> O(m*n)
 space complexity -> O(m*n)
 */

import java.util.*;
public class UniquePaths {
        public int uniquePaths(int m, int n) {
            
            int dp[][] = new int[m+1][n+1];
            for (int[] row: dp)
                Arrays.fill(row, -1);
            return findPaths(0,0,m,n,dp);
            
        }
        public int findPaths(int start,int end,int m,int n,int[][] dp){
            
            if(start == m || end == n)
                return 0;
            
            if(start == m-1 && end == n-1)
                return 1;
           
            if(dp[start][end]!=-1)
                return dp[start][end];
            
            return dp[start][end] = findPaths(start+1,end,m,n,dp) + findPaths(start,end+1,m,n,dp);
            
         
        }
}


/*

Optimal Approach 

time complexity O(M)

Approach -> Total number of steps to reach destination is m + n - 2.

In these steps we can choose n-1 in m+n-2 or m-1 in m+n-2

In m + n -2 blanks _ _ _ _ _ _ _ we have to choose m-1 or n-1 blanks and we will get the answer

Eg in m = 3 ,  n = 2  Blanks => _ _ _ . if we choose one Bottom 

These below combination gives us all the unique paths

B _ _
_ B _
_ _ B

 */


class Solution {
    public int uniquePaths(int m, int n) {
        
        int N  = m + n - 2;
        int r = m-1;
        double res = 1;
        
        for(int i=1;i<=r;i++){
            
            res = res * (N-r+i)/i;
            
        }
        return (int)res;
    }

}