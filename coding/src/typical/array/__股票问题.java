package typical.array;

// 经典答案，解析 股票机制问题
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

/**
 * T[i][k][0|1] ：T[i][k][0]表示 结束了第i天，最多k次交易，且手上没有股票时的收益
 * T[i][k][1]表示                                     ，手上有股票时的收益
 * T[-1][k][0]=0,T[-1][k][1]=-Infinity
 * T[i][0][0]=0,T[i][0][1]=-Infinity
 *
 * T[i][k][0] = max(T[i-1][k][0],T[i-1][k][1]+prices[i]) // 第二个表示第i-1天是有股票的，第i天卖出去了；其中交易是以买入开始算的，所以卖出不算一次交易
 * T[i][k][1] = max(T[i-1][k][1],T[i-1][k-1][0]-prices[i]) // 第二个表示第i-1天结束是没有股票的，已经卖出去了，然后第i天买入;如果有冷却期，就是T[i-2]...
 *
 * k=无限大时， T[i][k][1] =max(T[i-1][k][1], T[i-1][k-1][0] - prices[i]) = max(T[i-1][k][1], T[i-1][k][0] - prices[i])
 */
public class __股票问题 {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {

        return 0;
    }

}
