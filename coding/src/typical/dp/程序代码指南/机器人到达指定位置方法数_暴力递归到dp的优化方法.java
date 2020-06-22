package typical.dp.程序代码指南;

public class 机器人到达指定位置方法数_暴力递归到dp的优化方法 {
    // p 192;
    // 一行N个位置，机器人可以选择向左或向右，边界位置除外，必须走K步，到达P位置，有多少种方法？

    // 递归暴力
    private int walk(int n,int cur,int rest,int p){
        if(rest==0){
            return p==cur?1:0;
        }
        if(cur==1){
            return walk(n,2,rest-1,p);
        }
        if(cur==n){
            return walk(n,n-1,rest-1,p);
        }
        return walk(n,cur+1,rest-1,p)+walk(n,cur-1,rest-1,p);
    }

    // dp优化
    //taolu 大致如下
    // 1.找到什么可变参数，可以代表一个递归状态，一旦参数确定，返回值据确定了
    // 2.将可变参数的所有组合变成一张表，有1个可变参数就是一位表，2个就是2维；
    // 3.最终答案要的是表中的那个位置
    // 4.根据递归过程的base case,将这张表最简单，不需要依赖其他位置的位置填好值
    // 5.根据递归过程非base case，分析如何能计算好该位置的值。

    //该题中 可变参数是rest和cur
    private int ways2(int N,int M,int K,int P){
        // N表示行的长度，M表示当前位置，K表示所余步数，P表示终点
        if(N<2||K<1||M<1||M>N||P<1||P>N){
            return 0;
        }
        int[][] dp =new int[K+1][N+1];
        dp[0][P] = 1;
        for(int i=1;i<=K;i++){
            for(int j=1;j<=N;j++){
                if(j==1){
                    dp[i][j] = dp[i-1][2]; // 如果当前位于位置1，那么他只能玩2走，所以步数会少1
                }else if(j==N){
                    dp[i][j] = dp[i-1][N-1];
                }else{
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
                }

            }
        }
        return dp[K][M];
    }
}
