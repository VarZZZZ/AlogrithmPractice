package typical.array_2;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/8/8 16:44
 * @Version 1.0
 */
public class _经典回溯_平分背包价值 {
    /**
     * 从arr中选出恰好使两边价值一样的，且使扔掉背包中数值最小的情况
     */
    static class Main4 {
        static int min_val=Integer.MAX_VALUE;
        static  int sum=0;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                sum = 0;
                min_val=Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                    sum += arr[i];
                }
                dfs(arr,0,0,0,n);
                System.out.println(min_val);

            }
        }

        private static void dfs(int[] arr, int sum_a, int sum_b, int idx, int n) {
            if (idx == n) {
                if (sum_a == sum_b) {
                    min_val = Math.min(min_val,sum-sum_a*2);
                }
                return;
            }
            dfs(arr,sum_a,sum_b,idx+1,n); // dfs 的另一种方法，不用for循环
            dfs(arr,sum_a+arr[idx],sum_b,idx+1,n);
            dfs(arr,sum_a,sum_b+arr[idx],idx+1,n);

        }
    }
}
