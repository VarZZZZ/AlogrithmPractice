package test;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/9/12 15:23
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int time = sc.nextInt();
            map.putIfAbsent(u, new HashMap<>());
            map.putIfAbsent(v, new HashMap<>());
            map.get(u).put(v, time);
            map.get(v).put(u, time);
        }
        int s = sc.nextInt();
        int e = sc.nextInt();
        String start = sc.next();
        System.out.println(start);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0, s});
        Set<Integer> visit = new HashSet<>();
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visit.contains(curNode)) continue;
            visit.add(curNode);
            res = curDist;
            if (curNode == e) {
                break;
            }
            if (map.containsKey(curNode)) {
                for (int k : map.get(curNode).keySet()) {
                    if(visit.contains(k)) continue;
                    pq.offer(new int[]{res+map.get(curNode).get(k),k});
                }
            }
        }
        System.out.println(res);
    }
}
