/*
 *
 Using Sliding window approach.
 
 IF element already present remove the first element
 else add the element and increase the length
 */
import java.util.*;
class SubstringRepeating {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int remove = 0;
        int curr = 0;
        while(remove<s.length() && curr<s.length()){
            
                
            if(!set.contains(s.charAt(curr))){
            
                set.add(s.charAt(curr));
                curr++;
                res = Integer.max(res,set.size());
            }
            else{
                set.remove(s.charAt(remove));
                remove++;
            }     
        }
       return res;
    }
}
