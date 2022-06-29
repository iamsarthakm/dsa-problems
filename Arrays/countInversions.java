//EXPLAIN
// #Tough #revision
class Inversions {
    public int countInversions(int[] nums,int low,int high){
        int count = 0;
        if(high>low){
            int mid = low + (high-low)/2;
    
            count+= countInversions(nums,low,mid);
            count+= countInversions(nums,mid+1,high);
            count+= mergeFunction(nums,low,mid,high);
        }
    return count;
    }

    public int mergeFunction(int[] nums,int low,int mid,int high){
    
        int left[] = new int[mid-low+1];
        int right[] = new int[high-mid];
        int inv_count = 0;
        for(int i=low;i<left.length;i++){
            left[i] = nums[low+i];
        }
        
        for(int i=0;i<right.length;i++){
            right[i] = nums[mid+1+i];
        }
        int idx=0;
        int lptr = 0;
        int rptr = 0;
        while(lptr<left.length && rptr<right.length){
    
            if(left[lptr]>right[rptr])
                nums[idx++] = right[rptr++];
    
            else{
                nums[idx++] = left[lptr++];
                inv_count+= left.length-lptr;
            }
                
        }
    
        while(lptr<left.length)
            nums[idx++] = left[lptr++];
        
        while(rptr<right.length)
            nums[idx++] = right[rptr++];
    
    return inv_count;
    }
}
