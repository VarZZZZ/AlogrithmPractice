import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.putIfAbsent(arr[i],new PriorityQueue<>());
            map.get(arr[i]).offer(i);
            if(map.get(arr[i]).size()>1){
                if(!pq.contains(arr[i])) pq.offer(arr[i]);
            }
        }
        boolean[] flag = new boolean[n];
        while(!pq.isEmpty()){
            int val = pq.peek();
            PriorityQueue<Integer> tp = map.get(val);
            flag[tp.poll()]=true; // 标记删除
            arr[tp.peek()]=val*2;
            map.putIfAbsent(val*2,new PriorityQueue<>());
            map.get(val*2).offer(tp.poll());
            if(tp.size()<2) pq.poll();
            if(map.get(val*2).size()>1)
                pq.offer(val*2);
        }
        for (int i = 0; i < n; i++) {
            if(!flag[i]){
                System.out.print(arr[i]+" ");
            }
        }
    }

}


