package typical.array;

import java.util.Arrays;

public class Find_K_th_Smallest_Pair_Distance {
    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int n = nums.length;
        int r = nums[n-1]-nums[0]; // 搜索空间为[0,r],为值的二分搜索;
        // 因为返回值 也是值

        for(int cnt=0;l<r;cnt=0){
            int m = (l+r)/2;

            for(int i=0,j=0;i<n;i++){
                while(j<n&&nums[j]<=nums[i]+m) j++; //固定i，j往后移动
                cnt +=j-i-1;
            }
            if(cnt<k){    // 利用中值 去拟合 l 和 m
                l = m+1;
            }else{
                r = m;  // 找出m 使得count(m)>=k;
            }
        }
        return l;
    }
}
