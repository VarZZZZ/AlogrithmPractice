package typical.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        Set set = new HashSet<>();
        int i=0;
        int j=0;
        int maxLen=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLen=Math.max(maxLen,set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
}
