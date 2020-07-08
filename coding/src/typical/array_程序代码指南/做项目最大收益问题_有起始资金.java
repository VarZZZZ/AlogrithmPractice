package typical.array_程序代码指南;

import java.util.Arrays;

/**
 * @Author: ly
 * @Date: 2020/7/8 21:09
 * @Version 1.0
 */
public class 做项目最大收益问题_有起始资金 {
    //利用堆-优先队列
    // W,K   w 表示初始资金，K表示最多做K个项目，再给定两个长度为N的正整数组COST【】和 profits[],表示n个项目，
    // 不能并行，只能串行
    // 建立cost小根堆，profit大根堆
    // 首先将所有项目放入小根堆中，在从其顶部弹出小于M的项目，放入profit大根堆中,进入6
    //6.
    //  1.如果大根堆为空，则返回W，表示无项目可做
    //  2。否则，选择大根堆顶部的项目完成，W+=profit -cost,并重复步骤

    private int getMaxMoney(int w,int k,int[][] cost_profit){


        return 0;
    }

}
