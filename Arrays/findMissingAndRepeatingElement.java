/*
 Optimal Approach 
 Time complexity O(N)

 Approach


 */
//EXPLAIN

class Solution{

    public int[] repeatedNumber(final int[] A) {

        long sum = (A.length*(A.length+1))/2;
        long sqSum = (long)((A.length)*(A.length+1)*(2*A.length+1))/6;

        for(int i=0;i<A.length;i++)
        sum = sum - (long)A[i];
        
        for(int i=0;i<A.length;i++)
            sqSum = sqSum - (long)A[i]*A[i];
            
        int m = 0;
        int r = 0;
        
        m = (int)(sqSum/sum + sum)/2;
        
        r = m - (int)sum;
        
        return new int[]{r,m};
    }
}


/*
 
XOR Approach
  
 */

class XorSolution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {

      int xor = A[0];
      int x=0,y=0;
      for(int i=1;i<A.length;i++)
       xor = xor^A[i];
       
       for(int i=1;i<=A.length;i++)
            xor = xor^i;
            
        int setBit = xor & ~(xor-1);
        
        for(int i=0;i<A.length;i++){
            
            if((setBit & A[i])!=0)
                x = x^A[i];
            else
             y = y^A[i];
            
        }
        
        for(int i=1;i<=A.length;i++){
            if((setBit & i)!=0)
                x = x^i;
            else
             y = y^i;
        }
        boolean x_repeating = false;
        
        for(int i=0;i<A.length;i++){
            if(A[i]==x)
                x_repeating =true;
        }
    return x_repeating? new int[]{x,y}:new int[]{y,x};
    }
}
