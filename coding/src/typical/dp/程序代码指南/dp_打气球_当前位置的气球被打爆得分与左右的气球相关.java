package typical.dp.程序代码指南;

public class dp_打气球_当前位置的气球被打爆得分与左右的气球相关 {
    //给定一个数组arr，表示一排有分数的气球，每次打包一个气球，都能得分，假设打爆气球分数为x：
    //  1. 如果左边有没打爆的气球，分数为L，右边有没打爆的气球，分数为R,(最近的),则得分为L*X*R; 否则，为L*X，或X*R,或 x

    //首先暴力递归：
    // 考虑处理arr[L,,,R],并假设arr[L-1] arr[R+1]没有被打爆；
    // 如果arr[L]是最后被打爆的，那么可得arr[L-1]*arr[L]*arr[R+1]+process(L+1,R)
    // 如果arr[R]是最后
    // 如果arr[i]（L<i<R)最后被打爆，则process(L,i-1)+process(i+1,R)+arr[L-1]*arr[i]*arr[R+1];

    private int process(int[] arr,int L,int R){
        if(L==R)
            return arr[L-1]*arr[L]*arr[R+1];
        int max = Math.max(
                arr[L-1]*arr[L]*arr[R+1]+process(arr,L+1,R), //#
                arr[L-1]*arr[R]*arr[R+1]+process(arr,L,R-1)  //#
        );
        for(int i=L+1;i<R;i++){
            max = Math.max(max,arr[L-1]*arr[i]*arr[R+1]+process(arr,L,i-1)+
                    process(arr,i+1,R));  //#
        }
        return max;
    }

    // 假设要求dp[1][6], 那么在递归中，dp[1][6] 依赖于 　＃＃
    //从 二维表可以看出，dp[1][6],依赖于同一行及同一列的dp；且是dp[1][1],dp[1][2]...;d
    //dp[2][6],,dp[3][6],,,很明显，在表上是以同一行的左边及同一列的下边，所以从表的左下角位置开始处理。

    private int maxCoins(int[] arr){
        int N=arr.length;
        int[] help = new int[N+2];
        help[0]=1;
        help[N+1]=1;
        for(int i=0;i<N;i++){
            help[i+1]=arr[i];
        }
        int[][] dp =new int[N+2][N+2];
        for(int i=1;i<=N;i++){
            dp[i][i] = help[i-1]*help[i]*help[i+1];
        }
        for(int L=N;L>=1;L--){
            for(int R=L+1;R<=N;R++){
                int finalL = help[L-1]*help[L]*help[R+1] + dp[L+1][R];

                // 最后打爆help[R]
                int finalR = help[L-1]*help[R]*help[R+1]+dp[L][R-1];

                dp[L][R]= Math.max(finalL,finalR);
                // 寻找中间被打爆的每一种方案
            }
        }
        return dp[1][N];
    }
}
