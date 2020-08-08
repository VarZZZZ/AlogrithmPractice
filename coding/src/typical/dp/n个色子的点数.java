package typical.dp;

/**
 * @Author: ly
 * @Date: 2020/8/7 15:51
 * @Version 1.0
 */
public class n个色子的点数 {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     *
     */
    public double[] twoSum(int n) {
        int[] dp = new int[n*6+1]; // dp[n][j] 表示投完n个色子，和为j的次数
        for(int i=1;i<=6;i++){
            dp[i]=1;
        }
        //多重背包问题
        for(int i=2;i<=n;i++){
            // 如果是dp[n][j],那么j是从小到大的；而这里是一维，如果j从小到大计算，会重复计算当前维度
            // 二维;dp[n][j] += dp[n-1][j-cur]..  dp[n][..j..]不依赖于当前dp[n]的任何一个值
            // 一维;dp[j] += dp[j-cur];   会依赖于当前dp[n]阶段的值，所以需要让他从大到小计算
            for(int j=i*6;j>=i;j--){
                dp[j]=0;
                for(int cur=1;cur<=6;cur++){
                    if(j-cur<i-1) break;
                    dp[j] += dp[j-cur];
                }
            }
        }
        double all = Math.pow(6,n);
        double[] res = new double[n*5+1];
        for(int i=n;i<=n*6;i++){
            res[i-n] = dp[i]*1.0/all;
        }
        return res;

    }

}
