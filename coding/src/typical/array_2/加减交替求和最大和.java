package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/8/9 21:39
 * @Version 1.0
 */
public class 加减交替求和最大和 {
    // 子数组交替最大和
    // ai a(i+1)  a(i+2)  => 交替和ai-a(i+1)+a(i+2)
    public static int fun(int[] arr){
        int[][] dp = new int[arr.length + 1][2];     //长度为i的情况下的最多数量
        dp[0][0] = arr[0];       //正，包含最后一个
        //dp[0][1] = -arr[0];            //负，包含最后一个
        dp[0][1]=-100000; // 表示第一个数不能取减号。
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+arr[i],arr[i]);
            //dp[i][1] = Math.max(dp[i-1][0]-arr[i],-arr[i]); // 这是允许第一个数为减号
            dp[i][1] = dp[i-1][0]-arr[i]; // 当前为减号时，只能由前一个加号交替过来。
            if(dp[i][1]<0){
                dp[i][1]=-100000; // 如果减去当前值为负数，那么当-当前值为正数时，以当前数字结尾最大值应为当前值即可，；如果当前值为负数，
            }
            res = Math.min(res,Math.min(dp[i][0],dp[i][1]));
        }
        return res;
    }
}
