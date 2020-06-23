package 笔试._2020.小红书____重要优化点;

import java.util.Arrays;
import java.util.Scanner;

public class 倒卖战利品_优化数组最长递增子序列问题 {
    //在游戏中，击败魔物后，薯队长获得了N件宝物，
    // 接下来得把这些宝物卖给宝物回收员来赚点小钱。这个回收员有个坏毛病，
    // 每次卖给他一件宝 物后，之后他就看不上比这件宝物差的宝物了。
    // 在这个世界中，衡量宝物的好坏有两个维度，稀有度X和实用度H，
    // 回收员在回收一个宝物A 后，下一个宝物的稀有度和实用度都不能低于宝物A。
    // 那么薯队长如何制定售卖顺序，才能卖给回收员宝物总个数最多。

    //挺有意思的
    // 首先按照一维排序，然后，对第二维度求最长递增子序列
    // 最长子序列问题可以用dp表示
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] treasure = new int[n][2];
        for(int i=0;i<n;i++){
            treasure[i][0]=sc.nextInt();
            treasure[i][1]=sc.nextInt();
        }
        Arrays.sort(treasure,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = treasure[i][1];
        }
        System.out.println(LIS(ans));
    }
    //1     10                  2                     3                  4
    //res=1 rs=2;dp[1]=10   rs=2;dp[1]=10          rs=3 dp[2]=3               rs=4
    //很明显，更新dp[l]的值，用小的值替换掉大的值
    //对dp问题进行优化-二分优化-- 此处的dp表示位置；
    private static int LIS(int[] arr){                      // 可以解决装最多信封的问题；
        int[] dp = new int[arr.length];
        int res = 0;  // 下标
        for(int a:arr){
            int l=0,r=res;
            while(l<r){            // dp[l]...dp[r]是有序的
                int m = (l+r)/2;
                if(dp[m]<a) l = m+1;
                else r = m;
            }
            dp[l]=a;
            if(l==res) res++;// 表明当前a是大于之前的任何值的
        }
        return res;
    }
}
