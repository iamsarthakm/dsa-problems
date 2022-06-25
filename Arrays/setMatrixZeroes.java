// Ques Link -> https://leetcode.com/problems/set-matrix-zeroes/

// BRUTE FORCE
// time complextity = O(n^2)
// space complexity = O(m+n)

import java.util.*;
class BruteSolution {
    public void setZeroes(int[][] m) {
        
        // storing i and j in hashset and converting element to zero
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
                if(m[i][j]==0)
                {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++) {
                
                if(row.contains(i))
                    m[i][j]=0;
                if(column.contains(j))
                    m[i][j]=0;
            }  
        } 
    
    }
}

// OPTIMAL SOLUTION
// TIME COMPLEXITY O(M*N)
// SPACE COMPLEXITY O(N)

class OptimalSolution {
    public void setZeroes(int[][] m) {
 
        boolean rowZero = false;
        boolean colZero = false;
        
        for(int i=0;i<m.length;i++)
            if(m[i][0] == 0) 
                colZero = true;
        
        for(int j=0;j<m[0].length;j++)
            if(m[0][j]==0)
                rowZero=true;
         
        for(int i=1;i<m.length;i++){
            for(int j=1;j<m[i].length;j++){
                
                if(m[i][j]==0){
                    m[i][0] = 0;
                    m[0][j] = 0;
                }  
            }
        }
        
        for(int i=1;i<m.length;i++){
            if(m[i][0]==0){
                for(int j=0;j<m[i].length;j++)      
                    m[i][j]=0;
            }
        }
            
        for(int j=1;j<m[0].length;j++){
            if(m[0][j] == 0){
               for(int i=0;i<m.length;i++)
                   m[i][j]=0;
           }
        }
        
        if(rowZero){    
            for(int j=0;j<m[0].length;j++)
                m[0][j]=0;
        }
        
        if(colZero){
            for(int j=0;j<m.length;j++)
                m[j][0]=0;
        }
        
    
    }
}
