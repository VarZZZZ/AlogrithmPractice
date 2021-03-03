package 笔试.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/8/15 16:16
 * @Version 1.0
 */
public class _2021_逆序对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> mapOut = new HashMap<>();
        Map<String, Integer> mapIn = new HashMap<>();
        Map<String, Integer> mapAll = new HashMap<>();
        while (n-- > 0) {
            String[] t = sc.nextLine().split(" ");
            if (!mapOut.containsKey(t[0])) {
                mapOut.put(t[0], 0);
            }
            mapOut.put(t[0], mapOut.get(t[0]) + 1);
            if (!mapIn.containsKey(t[1])) {
                mapIn.put(t[1], 0);
            }
            mapIn.put(t[1], mapIn.get(t[1]) + 1);
        }
        for (String key : mapOut.keySet()) {
            mapAll.put(key, mapOut.get(key) + mapIn.getOrDefault(key, 0));
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(mapAll.entrySet());
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> tmp = pq.poll();
            if (mapOut.get(tmp.getKey()).equals(mapIn.get(tmp.getKey()))) {
                System.out.println(mapOut.get(tmp.getKey()));
                break;
            }
        }
    }
}
