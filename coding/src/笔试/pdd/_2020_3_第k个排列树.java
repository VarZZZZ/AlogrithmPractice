package 笔试.pdd;

import java.util.Scanner;

public class _2020_3_第k个排列树 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n+1][m+1]; // n 个a 和 m个b能组成的最多的序列
        k--;
        n--;// 首先计算在确定第一个为a的情况下，剩下的组合个数
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while(k>0&&(m>0||n>0)){
            // 在确定第一个字符的情况下，计算下面f[i][j]的组合个数
            int step = dfs(dp,n,m);
            if(step>k){ // k 在当前子树中;
                k--;   //注意规律------------------------  1 减去该子树的根节点
                if(n>0){ // 先往左子树靠，不符合条件再退栈
                    n--;
                    sb.append('a');
                }
            }else{// k不在当前子树中
                k -=step;       // 注意规律---------------  2
                n++;
                m--;
                sb.deleteCharAt(sb.length()-1);
                sb.append('b');
            }
        }
        System.out.println(sb.toString());
    }
    private static int dfs(int[][] dp,int n,int m){
        if(dp[n][m]>0) return dp[n][m];
        if(n==0){
            dp[n][m]=m;
            return m;
        }else if(m==0){
            dp[n][m]=n;
            return n;
        }
        dp[n][m] = dfs(dp,n-1,m)+dfs(dp,m,n-1)+2; // 从二叉数的角度考虑，加上两个左右根节点
        return dp[n][m];
    }

}
