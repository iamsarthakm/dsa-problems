import java.util.*;

//Ques link->  https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int n) {
 
        // Initializing the list with [1] element and for a new row simply add prev row's elements

        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        resList.add(firstRow);
        
        for(int i=2;i<=n;i++){
            List<Integer> prev_list = resList.get(i-2);
            List<Integer> row = new ArrayList<>();
            
            for(int j=1;j<=i;j++){
                
                if(j==1 || j==i){
                    row.add(1);
                }
                else{
                    row.add(prev_list.get(j-2)+prev_list.get(j-1));
                }         
            
            }
            
            resList.add(row);
        }
        
        return resList;
    }
}