package typical.array.程序代码面试指南;

import java.util.Scanner;

public class 挖矿_将数组分成两半_绝对差最小 {
    // 小v最近在玩一款挖矿的游戏，该游戏介绍如下：
    //
    //    1、每次可以挖到多个矿石，每个矿石的重量都不一样，挖矿结束后需要通过一款平衡矿车运送下山；
    //    2、平衡矿车有左右2个车厢，中间只有1个车轮沿着导轨滑到山下，且矿车只有在2个车厢重量完全相等且矿石数量相差不超过1个的情况下才能成功运送矿石，否则在转弯时可能出现侧翻。
    //
    //假设小v挖到了n（n<100）个矿石，每个矿石重量不超过100，为了确保一次性将n个矿石都运送出去，一旦矿车的车厢重量不一样就需要购买配重砝码。请问小v每次最少需要购买多少重量的砝码呢? （假设车厢足够放下这些矿石和砝码，砝码重量任选）
    //https://www.nowcoder.com/test/question/done?tid=33994403&qid=637399
    private static int solution(int n,int weight[]){
        int sum = 0;
        for(int w:weight) sum+=w;
        int ss = sum>>1;
        int N = (n+1)>>1;
        int[][] dp = new int[N+1][ss+1];

        for(int i=0;i<=ss;i++) dp[0][i]=0;
        for(int i=0;i<n;i++){        // 因为是从n个里面选出N个出来，与原来的背包问题不一样； dp[n][N][ss] 表示考虑前n个数，只从中选N个数
            for(int k=1;k<=N;k++){
                for(int j=ss;j>=weight[i];j--){
                    dp[k][j] = Math.max(dp[k][j],dp[k-1][j-weight[i]]+weight[i]);
                }
            }
        }
        if(n%2==1)
            return sum-2*Math.max(dp[N][ss],dp[N-1][ss]);
        return sum-2*dp[N][ss];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        System.out.println(solution(n,weight));
    }
}
