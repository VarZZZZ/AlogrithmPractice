package typical.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 天际线问题 {
    //https://leetcode.com/problems/the-skyline-problem/
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heightMap = new ArrayList<>();
        for(int[] b:buildings){
            heightMap.add(new int[]{b[0],-b[2]});
            heightMap.add(new int[]{b[1],b[2]});
        }
        Collections.sort(heightMap,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->(b-a));
        int preMax = 0;
        int curMax = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        pq.offer(0);
        for(int[] h:heightMap){
            if(h[1]<0)
                pq.offer(-h[1]);
            else
                pq.remove(h[1]);
            curMax = pq.peek();
            if(curMax!=preMax){
                tmp.clear();
                tmp.add(h[0]);
                tmp.add(curMax);
                res.add(new ArrayList<>(tmp));
                preMax = curMax;
            }
        }
        return res;
    }

}
