package typical.array;

import java.util.Arrays;

public class 从长乱序数组中找到排序后相邻间隔最大的值 {
    //https://leetcode.com/problems/maximum-gap/submissions/
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;

        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        // the minimun possible max gap;
        int gap = (int)Math.ceil((double)(max-min)/(n-1));

        int[] bucketMin= new int[n-1];
        int[] bucketMax = new int[n-1];
        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,Integer.MIN_VALUE);
        for(int i:nums){
            if(i==min||i==max) continue;
            int idx = (i-min)/gap;                   // 重映射到一个区域，然后求这个区域的最大最小值；同一个区域内不可能存在间隔最大的相邻；
            bucketMin[idx] = Math.min(bucketMin[idx],i);
            bucketMax[idx] = Math.max(bucketMax[idx],i);
        }
        int pre=min;
        int maxgap = 0;
        for(int i= 0;i<n-1;i++){
            if(bucketMin[i]==Integer.MAX_VALUE||bucketMax[i]==Integer.MIN_VALUE)
                continue;
            int diff = bucketMin[i]-pre;  // 当前区域最小值-上一个区域最大值
            maxgap = Math.max(diff,maxgap);
            pre = bucketMax[i];
        }
        maxgap = Math.max(maxgap,max-pre);
        return maxgap;

    }
}
