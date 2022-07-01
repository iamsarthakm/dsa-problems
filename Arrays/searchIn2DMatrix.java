/*

Time Complexity  =  log(m+n)
https://leetcode.com/problems/search-a-2d-matrix/

Approach -> searching in a sorted 2D matrix. Applied normal binary search and converted index to i and j

 */

public class searchIn2DMatrix {
 
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,0,matrix.length*matrix[0].length-1,target);
     }
     public boolean search(int[][] matrix,int start,int end,int target){
     
         if(start<=end){
           
             int mid = end + (start-end)/2;
             //core logic here
             int i = mid/matrix[0].length;
             int j = mid%matrix[0].length;
             
             if(matrix[i][j]==target)
                 return true;
             else if(matrix[i][j] > target)
                 return search(matrix,0,mid-1,target);
             else
                 return search(matrix,mid+1,end,target);
             
             
         }
     return false;
     }
    
}
