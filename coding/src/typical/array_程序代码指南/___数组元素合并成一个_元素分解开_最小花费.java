package typical.array_程序代码指南;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/7/8 21:46
 * @Version 1.0
 */
public class ___数组元素合并成一个_元素分解开_最小花费 {
    // 美团_2020_相邻数字合并
    // 快手_2020_石头相撞   ----利用背包-，因为是相邻数组

    // 分金条_哈夫曼，因为无关相邻，只是从中挑选

    /**
     * 输入：n = 9, cuts = [5,6,1,4,2]
     * 输出：22
     * 解释：如果按给定的顺序切割，则总成本为 25 。
     * 总成本 <= 25 的切割顺序很多，例如，[4，6，5，2，1] 的总成本 = 22，是所有可能方案中成本最小的。
     *
     * 与画匠问题相似，其解法与相邻数字合并类似；都是第一个for循环为len，长度，然后在确定左端和右端的点，再接一个for循环确定k
     * f[i][j] = Math.min(f[i][k]+f[k][j]+..)  // 都是类似
     */
    // n=7  curts=[1,3,4,5]
    private int minCost(int n, List<Integer> curts){
        curts.add(0);
        curts.add(n);
        Collections.sort(curts);
        int m = curts.size();
        int[][] f = new int[m][m];// f[i][j]表示从curts[i]到curts[j]之间的最小成本；
        for(int i=0;i+1<m;i++){
            f[i][i+1]=0; // 最后切下来的每一段,如1-3之间是不需要再消耗成本的。
        }
        for(int len=2;len<m;len++){
            for(int i=0;i+len<m;i++){
                int j = i+len;
                for(int k=i+1;k<j;k++){
                    f[i][j] = Math.min(f[i][j],f[i][k]+f[k][j]+curts.get(j)-curts.get(i));
                }
            }
        }
        return f[0][m-1];
    }
}
