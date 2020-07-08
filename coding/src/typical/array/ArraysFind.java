package typical.array;

public class ArraysFind {

    // 从数组中找到满足 。。。 1。。3。。。2   1<3>2 的情况； 也可以利用单调栈
    private boolean find132pattern(int[] nums){
        int n = nums.length,top = n,third = Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            if(nums[i]<third) return true;   //  nums[top]   ... 是递增的最大值
            while(top<n&&nums[i]>nums[top]) third = nums[top++];  // 第三个值 获取 (恰当)的最大值
            nums[--top] = nums[i];
        }
        return false;
    }
}
