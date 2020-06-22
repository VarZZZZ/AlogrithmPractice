package typical.HashTable;

import java.util.*;

public class TOP_K {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String w:words){
            int cnt = map.getOrDefault(w,0)+1;
            map.put(w,cnt);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>((a, b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());
        for(Map.Entry<String,Integer> m:map.entrySet()){
            queue.offer(m);
        }
        List<String> res = new ArrayList<>();
        while(k-->0){
            res.add(queue.poll().getKey());
        }

        return res;
    }
}
