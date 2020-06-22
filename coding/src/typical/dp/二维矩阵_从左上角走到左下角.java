package typical.dp;

import java.util.*;

public class 二维矩阵_从左上角走到左下角 {
    //https://leetcode.com/problems/cherry-pickup/
    int[][][] dp; // dp[r1][c1][r2] 唯一标识两个人的所处位置，且步数相同时
    int[][] gd;
    int N;
    public int cherryPickup(int[][] grid){
        gd=grid;
        N=grid.length;
        dp =new int[N][N][N];
        for(int[][] dd:dp){
            for(int[] d:dd){
                Arrays.fill(d,Integer.MIN_VALUE);
            }
        }
        return Math.max(0,dfs(0,0,0));
    }
    // 本质上还是从右下到左上; dfs 先遍历到最底部
    private int dfs(int r1,int c1,int c2){
        int r2 = r1+c1-c2;
        if(r1==N||r2==N||c1==N||c2==N||gd[r1][c1]==-1||gd[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==N-1&&c1==N-1){
            return gd[r1][c1];
        }
        if(dp[r1][c1][c2]!=Integer.MIN_VALUE){
            return dp[r1][c1][c2];
        }
        int ans = gd[r1][c1];
        if(r1!=r2) ans +=gd[r2][c2];
        ans +=Math.max(Math.max(dfs(r1+1,c1,c2),dfs(r1,c1+1,c2)),
                Math.max(dfs(r1,c1+1,c2+1),dfs(r1+1,c1,c2+1)));
        dp[r1][c1][c2]=ans;
        return ans;
    }
}
