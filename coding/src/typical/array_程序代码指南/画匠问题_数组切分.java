package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/9 11:13
 * @Version 1.0
 */
public class 画匠问题_数组切分 {
    /**
     * arr=[1,1,1,4,3] num = 3 表示3个画工，共5副画，每个画工智能画连在一起的画作，arr每个值表示每幅画的所需时间，问最小划分后完成时间
     */

    /**
     * 可以dp，不管怎么说，最后一个画工总是画数组的最后一部分
     */

    /**
     * 方法1，dp[i][j] = min(max(dp[i-1][k]+sum(k+1...j)}
     *      dp[i][j]表示 画0...j上的画，共i个画工所需的最小时间。
     */


}
