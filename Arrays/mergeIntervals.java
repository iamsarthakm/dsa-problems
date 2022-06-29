/*

https://leetcode.com/problems/merge-intervals/

Time complexity O(nlogn)
Space complexity O(2*n)
 * 
 */

/*
#Tough #revision
Approach

 First we sort the intervals array
  
 if the output array is empty or interals are not overlapping
  ->  (1  2)   ,  (3    4) = 2 is smaller than 3 so intervals not overlapping
    then add the values in output array add(1,2) add(3,4)

    Else 
    (1, 5)  (3,6)
    check for the greater value between 5 and 6 and since 1 and 5 is already added replace 5 by 6
 */

import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
 
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            
            if(list.isEmpty() || list.get(list.size()-1).get(1) < intervals[i][0]){
                ArrayList<Integer> l = new ArrayList<>();
                l.add(intervals[i][0]);
                l.add(intervals[i][1]);
                list.add(l);
            }
            else{
                list.get(list.size()-1).set(1, Math.max( list.get(list.size()-1).get(1) , intervals[i][1] ));
            }
            
        }
        int[][] out = new int[list.size()][2];
        
        for(int i=0;i<out.length;i++){
            out[i][0] = list.get(i).get(0);
            out[i][1] = list.get(i).get(1);
        }
        return out;
    }
}