package 笔试.快手;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
//1. 如果x==y，碰撞结果为两个石头消失
//2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x；
    //分析 d-((a-b)-c) => d+c-(a-b) =>d+c+b-a =>相当于将数组分为 A-B；
//
//最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
public class _2020_石头相撞 {
    public static void main(String[] args) { // 无法过全部
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] g = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            g[i] = sc.nextInt();
            pq.offer(g[i]);
        }
        // 8-(7-2)=3  8-2 -7 = 8-7-2 绝对值=1
        int t=0;
        while(pq.size()>1){
            t = pq.poll()-pq.poll();
            pq.offer(t);
        }
        System.out.println(t);
    }
    // dp 0-1背包法 dp[j]代表是否能将石头分成其中一堆为j，另一堆为(sum-j)，其中一堆的最小值肯定不超过总和的一半，最后最接近的两堆即为最小值
    public static void dp(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] g = new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++){
            g[i] = sc.nextInt();
            sum +=g[i];
        }
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=sum/2;j>=g[i];j--){ // 这是0-1背包
                dp[j] |=dp[j-g[i]];
            }
        }
        int res = 0;
        for(int j=sum/2;j>=0;j--){
            if(dp[j]){
                res = Math.abs(j-sum+j);
                break;
            }
        }
        return;

    }
}
