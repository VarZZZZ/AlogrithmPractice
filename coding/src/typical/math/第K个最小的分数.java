package typical.math;

/**
 * @Author: ly
 * @Date: 2020/7/25 16:07
 * @Version 1.0
 */
public class 第K个最小的分数 {
    /**
     * 一个已排序好的表 A，其包含 1 和其他一些素数.  当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
     *
     * 那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q.
     *
     * 可以用under(x)用于求解小于x的分数数量，而这是一个关于x的单调增函数
     * 因而，可以使用二分查找
     *
     * under(x) 函数有两个目的：返回小于 x 的分数数量以及小于 x 的最大分数。
     * 在 under(x) 函数中使用滑动窗口的方法：对于每个 primes[j]，
     * 找出最大的 i 使得 primes[i] / primes[j] < x。随着 j （和 primes[j]）的增加， i 也会随之增加。
     *
     */
    public int[] kthSmallestPrimeFraction(int[] primes, int K) {
        double lo = 0,hi = 1;
        int[] ans = new int[]{0,1};

        while(hi-lo>1e-9){ // double 类型的比较等于
            double m = (lo+hi)/2.0;
            int[] res = under(m,primes);
            if(res[0]<K){
                lo = m;// 这个也没法-1，因为是double类型的值，且不是下标
            }else if(res[0]>K){
                hi = m;
            }else{
                ans[0] = res[1];
                ans[1] = res[2];
                break;
            }
        }
        return ans;
    }

    private int[] under(double m, int[] primes) {
        // numer 返回的最大分数的分子，demon为分母
        int numer=0,demon = 1,cnt=0,i=-1;
        for(int j=1;j<primes.length;j++){

            while(primes[i+1] < primes[j]*m) i++; // 利用乘法代替除法

            cnt += i+1;

            //找到当前最大的分数a/b    赋值给numer/demon   ;
            // if a/b>num/demon => aa*demon>num*b
            if(i>=0&&numer*primes[j]<demon*primes[i]){
                numer = primes[i];
                demon = primes[j];
            }

        }
        return new int[]{cnt,numer,demon};
    }


}
