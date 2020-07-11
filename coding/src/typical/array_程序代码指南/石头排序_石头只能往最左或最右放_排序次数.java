package typical.array_程序代码指南;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/7/11 16:41
 * @Version 1.0
 */
public class 石头排序_石头只能往最左或最右放_排序次数 {
    // n个石头，半径大小为1<=ri<=n,每个石头都不同；相当于对1-n乱序数组排序
    // 4 1  2 5 3;  => 2
    // 相当于求最长递增序列，且相差为1；
    private static int sort(int[] arr) {
        int n = arr.length;
        int[] preNum = new int[n + 1];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            preNum[cur] = preNum[cur - 1] + 1;
            max = Math.max(preNum[cur], max);
        }
        return n - max;
    }
}
