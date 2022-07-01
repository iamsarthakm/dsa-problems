/*
 
Edge case-> minimun value of n when * -1 exceeds max integer value so has to be stored in long

 */

 //Brute force
class Pow{
    
    public double myPow(double x, int n) {
        double ans = 1;
     
        if(x==1.00000)
            return x;
        
        long pow = n;
        if(n<0){
            pow = pow*-1;
            x = 1/x;
        }
        
        while(pow>0){
          ans = ans*x;
            pow--;
        }
            
    return ans;
    }

}

// optimal solution 
/*
  Time complexity O(log n) base2

  Approach -> every time we encounter even power we shorten the problem

  Eg-> EVEN CASE : 2 ^ 20 -> 4 ^ 10 -> 16 ^ 5 
       ODD CASE : multiple ans by x and reduce powwer by 1 ans = 16 pow = 4 
 
 Also inverting x for negative cases do it in the end
       */

class OptimalSolution {
    public double myPow(double x, int n) {
        double ans = 1;

        long pow = n;
        
        if(pow<0){
            pow = -1*pow;
        }
            
        
        while(pow>0){
            
            if(pow%2==0){
                x = x*x;
                pow  = pow/2;
            }
            else{
                ans = ans*x;
                pow = pow-1;
            }  
        }
    
            
    return n<0? (double)(1)/(double)(ans):ans;
    }
}