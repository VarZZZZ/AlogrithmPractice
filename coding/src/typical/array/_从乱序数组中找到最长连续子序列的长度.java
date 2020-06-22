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
}
