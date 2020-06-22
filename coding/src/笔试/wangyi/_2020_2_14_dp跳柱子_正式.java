package 笔试.wangyi;

import java.util.Scanner;

public class _2020_2_14_dp跳柱子_正式 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            boolean[][] dp = new boolean[n][2];
            dp[0][0] = true;
            for(int i=1;i<n;i++){
                boolean f=false;
                for(int j = Math.max((i - k), 0); j<i; j++){
                    if(dp[j][0]&&arr[i]<=arr[j]){
                        dp[i][0]=true;
                        break;
                    }else if(!dp[j][1]){ //高度不符合,前面无人使用超能力
                        dp[i][1] = true;
                    }else if(dp[j][1]&&arr[i]<=arr[j]){//高度符合，前面有人使用超能力
                        dp[i][1]=true;
                    }
                }
            }
            if(dp[n - 1][0] || dp[n - 1][1])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
