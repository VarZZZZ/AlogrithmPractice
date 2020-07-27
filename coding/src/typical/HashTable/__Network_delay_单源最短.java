package typical.HashTable;

import java.util.*;

// dijistra
public class __Network_delay_单源最短 {
    //https://leetcode.com/problems/network-delay-time/discuss/210698/Java-Djikstrabfs-Concise-and-very-easy-to-understand
    // k起点
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,Map<Integer,Integer>> map =new HashMap<>();
        for(int[] time:times){
            map.putIfAbsent(time[0],new HashMap<>());
            map.get(time[0]).put(time[1],time[2]);
        }
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(a[0]-b[0])); //int[] a  a[0]表示a[1]距离k的最短路径
        pq.offer(new int[]{0,K});
        boolean[] visit = new boolean[N+1];
        int res=0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            if(visit[curNode]) continue;
            visit[curNode]=true;   // 找到了距离curNode最近的路径        -1
            N--;
            res = curDist;
            if(map.containsKey(curNode)){
                for(int k:map.get(curNode).keySet()){
                    if(visit[k]) continue;
                    pq.offer(new int[]{res+map.get(curNode).get(k),k}); // 此处只是把邻接边放入到pq中 在while循环里 -1 才是把距离最短的路径拿出来
                }
            }
        }
        return N==0?res:-1;
    }
}
