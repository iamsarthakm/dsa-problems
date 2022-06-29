// Clockwise
//#revision
class Cloclkwise {
    public void rotate(int[][] matrix) {
    int n = matrix.length;
        int temp[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[j][n-i-1] = matrix[i][j];
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                  matrix[i][j] = temp[i][j];
    }
}

// Anti clockwise

class AntiClockWise {
    public void rotate(int[][] matrix) {
    int n = matrix.length;
        int temp[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[n-j-1][i] = matrix[i][j];
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                  matrix[i][j] = temp[i][j];
    }
}


/*
 Optimal Approach 
 */


class SolClockwise {
    public void rotate(int[][] matrix) {
    int n = matrix.length;
        // Transpose of a matrix , row to column or column to rows
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                swap(matrix,i,j);
            
            // reversing rows
        for(int i=0;i<n;i++){
            reverse(matrix,i);
        }

    }
    public void swap(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void reverse(int[][] matrix,int i){
        int start = 0;
        int end = matrix[i].length-1;
    
        while(start<end){
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
        }
    }
}