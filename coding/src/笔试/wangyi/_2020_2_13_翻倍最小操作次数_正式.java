package 笔试.wangyi;
import java.util.*;
public class _2020_2_13_翻倍最小操作次数_正式 {
    // https://www.nowcoder.com/question/next?pid=20791044&qid=800566&tid=33912619
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            PriorityQueue<int[]> pq = new PriorityQueue<>((aa,bb)->(aa[1]-bb[1]));
            pq.offer(new int[]{a,0,p});
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(cur[0]>=b){
                    System.out.println(cur[1]);
                    break;
                }
                int curp = cur[2];
                pq.offer(new int[]{cur[0]+curp,cur[1]+1,curp});
                curp *=q;
                pq.offer(new int[]{cur[0],cur[1]+1,curp});
            }

        }
    }
}
