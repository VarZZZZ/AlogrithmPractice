package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/8/11 17:08
 * @Version 1.0
 */
public class 数组2n个选出n个使两组和差值最小__背包 {
    /**
     * 有一个没有排序，元素个数为2N的正整数数组。
     * 要求把它分割为元素个数为N的两个数组，并使两个子数组的和最接近。
     * 假设数组A[1..2N]所有元素的和是SUM。
     * 模仿动态规划解0-1背包问题的策略，令S(k, i)表示前k个元素中任意i个元素的和的集合。显然：
     * S(k, 1) = {A[i] | 1<= i <= k}
     * S(k, k) = {A[1]+A[2]+…+A[k]}
     * S(k, i) = S(k-1, i) U {A[k] + x | x属于S(k-1, i-1) }
     *
     * S(2N, N)中与SUM/2最接近的那个和，就是结果
     * 这个过程中只关注和不大于SUM/2的那个子数组的和。
     * 所以集合中重复的和以及大于SUM/2的和都是没有意义的。
     * 把这些没有意义的和剔除掉，剩下的有意义的和的个数最多就是SUM/2个。
     */
    private int sol(int[] arr){
        int sum=0;
        for(int a:arr){
            sum += a;
        }
        int n = arr.length/2;
        // flag[i][j]:任意i个整数之和为j，则flag[i][j]=true
        boolean[][] flag = new boolean[n+1][sum/2+1];
        flag[0][0] = true;
        for(int k = 1;k<=2*n;k++){ // s(k,i) ,k的选择
            for(int i = Math.min(k, n); i>=1; i--){ // s(k,i) , i的选择，最大不用超过n

                for(int j=0;j<=sum/2;j++){
                    if(j>=arr[k]&&flag[i-1][j-arr[k]])
                        flag[i][j]=true;
                }
            }
        }

        for(int i=sum/2;i>=0;i--){
            if(flag[n][i]){
                return Math.abs(2*i-sum);
            }
        }
        return 0;
    }


}
