package typical.HashTable;

import java.util.*;

public class _区间叠加 {
    //https://leetcode.com/problems/my-calendar-iii/
    TreeMap<Integer,Integer> map = new TreeMap<>();
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int k=0,ongoing=0;
        for(int v:map.values()){
            k = Math.max(k,ongoing+=v);
        }
        return k;
    }
}
