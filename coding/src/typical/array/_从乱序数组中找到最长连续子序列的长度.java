package typical.array;

import java.util.*;

public class _从乱序数组中找到最长连续子序列的长度 {
    public int longestConsecutive(int[] nums) {
        // 重要的是边界的问题，区间内的值已被添加
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int n:nums){
            if(!map.containsKey(n)){
                int left = map.getOrDefault(n-1,0);
                int right = map.getOrDefault(n+1,0);
                int s = left+right+1;
                map.put(n,s);
                res  = Math.max(res,s);
                map.put(n-left,s);
                map.put(n+right,s);
            }
        }
        return res;
    }

    // 二分方法
    //1     10                  2                     3                  4
    //res=1 rs=2;dp[1]=10   rs=2;dp[1]=10          rs=3 dp[2]=3               rs=4
    //很明显，更新dp[l]的值，用小的值替换掉大的值 ； 类似于二分插入，即在 1  10  数组中 二分查找 值2 的位置，如果 2 在整个数组的最后面，则res++,否则，覆盖掉
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
