package typical.array;

// 经典答案，解析 股票机制问题
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T[i][k][0|1] ：T[i][k][0]表示 结束了第i天，最多k次交易，且手上没有股票时的收益
 * T[i][k][1]表示                                     ，手上有股票时的收益
 * T[-1][k][0]=0,T[-1][k][1]=-Infinity
 * T[i][0][0]=0,T[i][0][1]=-Infinity
 * <p>
 * 注意：优化空间维度时-  T[i] = T[i-1]   ,这两个可以用同一个符号表示 t = Math.max(t,t_1+price)
 * T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i]) // 第二个表示第i-1天是有股票的，第i天卖出去了；其中交易是以买入开始算的，所以卖出不算一次交易
 * T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0]-prices[i]) // 第二个表示第i-1天结束是没有股票的，已经卖出去了，然后第i天买入;如果有冷却期，就是T[i-2]...
 * <p>
 * k=无限大时， T[i][k][1] =max(T[i-1][k][1], T[i-1][k-1][0] - prices[i]) = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
 */
public class __股票问题 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {

        return 0;
    }

    public int findRotateSteps(String ring, String key) {
        // dp[i][j] 表示 拼写出key的第i个字符
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        List<List<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            pos.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            pos.get(ring.charAt(i) - 'a').add(i);
        }
        for (int i : pos.get(key.charAt(0) - 'a')) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j : pos.get(key.charAt(i) - 'a')) {
                for (int k : pos.get(key.charAt(i - 1) - 'a')) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)));
                }
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
