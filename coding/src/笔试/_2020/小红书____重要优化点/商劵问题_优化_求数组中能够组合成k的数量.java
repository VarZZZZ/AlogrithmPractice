package 笔试._2020.小红书____重要优化点;

import java.util.Arrays;
import java.util.Scanner;

class 商劵问题 {
    //某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
    //输入薯券金额、商品分别价格
    //例如：10 [2,3,5]
    //10与[2,3,5]中间有空格
    //输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合

    // dfs 法，时间超过限制
    static int maxRes=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int amount = Integer.parseInt(sc.next());
        String str = sc.next();
        String[] strs = str.substring(1,str.length()-1).split(",");
        int[] prices = new int[strs.length];
        for(int i=0;i<prices.length;i++){
            prices[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(prices);
        dfs(prices,0,amount);
        System.out.println(maxRes);

    }
    private static void dfs(int[] prices,int idx,int resAnt){
        if(resAnt==0){
            maxRes++;
            return;
        }
        for(int i=idx;i<prices.length;i++){
            if(resAnt<prices[i]){
                return;
            }
            dfs(prices,i,resAnt-prices[i]);
        }
    }

    // 利用背包法-优化的背包法
    private int solution(int[] prices,int amount){
        int n = prices.length;;
        int[][] dp = new int[n+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){// 不能从prices[i]起步
                for(int k=0;j+k<=amount;k+=prices[i-1]){
                    if(dp[i-1][j]>0){
                        dp[i][j+k] += dp[i-1][j]; // 在dp[i-1][j]的基础上，剩下的全部用prices[i-1]补上
                    }
                }
            }
        }
        return dp[n][amount];
    }
}

//  薯队长写了n篇笔记，编号从1~n,每篇笔记都获得了不少点赞数。
//薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
// 1.不能出现连续编号的笔记。
//2.总点赞总数最多
//如果满足1，2条件有多种方案，挑选笔记总数最少的那种
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] likes = new int[n];
        for(int i=0;i<n;i++){
            likes[i] = sc.nextInt();
        }
        int[] dp = new int[n];  // 考虑前n个时的最大点赞数
        int[] cnt = new int[n];
        cnt[0]=1;
        cnt[1]=1;
        dp[0] = likes[0];
        dp[1] = likes[1];
        int maxDp=-1,maxCnt=-1;
        for(int i=2;i<n;i++){
            for(int j=0;j<i-1;j++){
                if(dp[i]<dp[j]+likes[i]){
                    cnt[i] = cnt[j]+1;
                    dp[i]=dp[j]+likes[i];
                    if(maxDp<dp[i]){      // 此处的dp[i]是选定当前i时的最大情况,
                        maxDp=dp[i];
                        maxCnt=cnt[i];
                    }else if(maxDp==dp[i]&&maxCnt>cnt[i]){
                        maxCnt=cnt[i];
                    }

                }
            }
        }
        System.out.println(maxDp+" "+maxCnt);
    }
}