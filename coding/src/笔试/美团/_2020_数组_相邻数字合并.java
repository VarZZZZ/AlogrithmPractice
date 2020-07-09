package 笔试.美团;

import java.util.Scanner;
// 这种问题都需要列公式，否则很难想出
//有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。
// 每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。
// 经过N-1次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
    //假设dp[i][j]表示arr[i..j]的最小合并成本；
    //他表示有一个k，从i...k..j中花开，即dp[i][j] = dp[i][k]+dp[k+1][j]+curSum...
public class _2020_数组_相邻数字合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
            sum[i] = sum[i-1]+arr[i];
        }
        int[][] dp =new int[n+1][n+1]; // 一维是做不出来的
        for(int len=2;len<=n;len++){
            for(int i=1;i<=n-len+1;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                int curSum = sum[j]-sum[i-1];
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+curSum);
                }
            }
        }
        System.out.println(dp[1][n]);

    }
}

//给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
//1. 如果x==y，碰撞结果为两个石头消失
//2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
//
//最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
// dp 0-1背包法 dp[j]代表是否能将石头分成其中一堆为j，另一堆为(sum-j)，其中一堆的最小值肯定不超过总和的一半，最后最接近的两堆即为最小值
