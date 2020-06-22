package 笔试.美团;

import java.util.Scanner;
//有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。
// 每次合并都会将相邻的两堆金币合并为一堆，成本为这两堆金币块数之和。
// 经过N-1次合并，最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
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
