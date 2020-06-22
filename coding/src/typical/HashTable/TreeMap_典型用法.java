package typical.HashTable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//https://leetcode.com/problems/range-module/submissions/
public class TreeMap_典型用法 {
    TreeMap<Integer,Integer> map;

    public void addRange(int left, int right) {
        if(left>=right) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(start==null&&end==null){
            map.put(left,right);
        }else if(start!=null && map.get(start)>=left){
            map.put(start,Math.max(map.get(start),Math.max(right,map.get(end))));
        }else{
            map.put(left,Math.max(right,map.get(end)));
        }
        Map<Integer,Integer> sm = map.subMap(left,false,right,true);
        Set<Integer> st=  new HashSet<>(sm.keySet());
        sm.keySet().removeAll(st);
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if(start!=null && map.get(start)>=right)
            return true;
        return false;
    }

    public void removeRange(int left, int right) {
        if(left>=right) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(end!=null&&map.get(end)>right){
            map.put(right,map.get(end));
        }
        if(start!=null&&map.get(start)>left){
            map.put(start,left);
        }
        Map<Integer,Integer> sm = map.subMap(left,true,right,false);
        Set<Integer> st=  new HashSet<>(sm.keySet());
        sm.keySet().removeAll(st);
    }
}
