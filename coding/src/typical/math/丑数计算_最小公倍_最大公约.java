package typical.math;

/**
 * @Author: ly
 * @Date: 2020/7/7 23:00
 * @Version 1.0
 */

/**
 * 丑数
 * 只包含2、3、5因子的数被称为丑数，如1,2,3,4,5,6,8；14不是，它包含7；
 */
class 丑数计算_最小公倍_最大公约 {
    //求第idx个丑数
    public int GetUglyNumber(int idx){
        if(idx<7) return idx;
        int[] ugly = new int[idx];
        ugly[0] = 1;
        int min = 1;
        int m2 = 0;
        int m3=0;
        int m5=0;
        for(int i=1;i<idx;i++){ // 每一个丑数，都得经过*2，*3，*5各一次。
            ugly[i] = Math.min(ugly[m2] * 2,Math.min(ugly[m3] * 3,ugly[m5] * 5));
            if(ugly[i] == ugly[m2]*2){
                m2++;
            }
            if(ugly[i] == ugly[m3]*3){
                m3++;
            }
            if(ugly[i] == ugly[m5]*5){
                m5++;
            }
        }
        return ugly[idx-1];
    }

    public int nthUglyNumber(int n) {
        int t1=0,t2=0,t3=0;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(dp[t1]*2,Math.min(dp[t2]*3,dp[t3]*5));
            if(dp[i]==dp[t1]*2) t1++;
            if(dp[i]==dp[t2]*3) t2++;
            if(dp[i]==dp[t3]*5) t3++;
        }
        return dp[n-1];
    }
    // primes 表示 2 7 13 19 ... 不再固定是3个
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] cur = new int[primes.length];

        for(int i=1;i<n;i++){
            res[i]=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(primes[j]*res[cur[j]]==res[i-1])
                    cur[j]++;
                res[i]=Math.min(res[i],primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }

    /**
     * 二分法
     * 那么对于一个丑数X，我们能够确定它是第几个丑数吗？
     * 你帮忙设计一个程序，用来找出第 n 个丑数。
     *
     * 1.该数只能被a整除 (该数一定是a 的整数倍)
     *
     * 2.该数只能被b整除 (该数一定是b 的整数倍)
     *
     * 3.该数只能被c整除 (该数一定是c 的整数倍)
     *
     * 4.该数只能被a和b同时整除 (该数一定是a、b最小公倍数的整数倍)
     *
     * 5.该数只能被a和c同时整除 (该数一定是a、c最小公倍数的整数倍)
     *
     * 6.该数只能被b和c同时整除 (该数一定是b、c最小公倍数的整数倍)
     *
     * 7.该数只能被a和b和c同时整除（该数一定是a、b、c的最小公倍数的整数倍）
     *
     * 所以，我们只需要分别计算以上七项就能得到结果了！让我们分别来看（用MCM+下标表示最小公倍数）：
     *
     * 情况1 = X/a - 情况4 - 情况5 - 情况7
     * 情况2 = X/b - 情况4 - 情况6 - 情况7
     * 情况3 = X/c - 情况5 - 情况6 - 情况7
     * 情况4 = X/MCM_a_b - 情况7
     * 情况5 = X/MCM_a_c - 情况7
     * 情况6 = X/MCM_b_c - 情况7
     * 情况7 = X/MCM_a_b_c
     *
     * 让我们整理上述方程后也就得到：
     *
     * sum(情况) = X/a + X/b + X/c - X/MCM_a_b - X/MCM_a_c - X/MCM_b_c + X/MCM_a_b_c
     */
    private int nthUgly(int n,int a,int b,int c){
        int low =Math.min(c,Math.min(a,b));
        int high = low*n;

        int res = binarySear(low,high,a,b,c,n);
        int la = res%a;
        int lb = res%b;
        int lc = res%c;
        return res-Math.min(Math.min(la,lb),lc);

    }
    /**
     * 在得到了计算任意数中包含了多少个丑数因子的方法后，我们实际上只需要通过二分法，不断缩小边界范围，直到某个位置所对应的数恰好包含了n个丑数因子为止。
     *
     * 注意，通过二分法计算的答案并非是最终答案，因为可以有很多数同时包含有n个丑数因子！
     *
     * 比如第n个丑数是X，那么[X,X + min(a,b,c))这个半开区间内的所有数都同时包含n个丑数因子，我们通过二分法得到的答案也随机分布于这个区间中。
     * 而实际上我们只需要得到该区间的左端即可。
     * 处理方法很简单：假设我们得到的临时答案是K(K∈[X,X + min(a,b,c))),那么K - min(K%a,K%b,K%c) = X.也就是只需要把临时答案减去其与a、b、c三者中取余的最小值即可！
     */
    private int binarySear(int low,int high,int a,int b,int c,int n){
        if(low>=high) return low;
        int mid = (low+high)>>1;
        int mcm_a_b = mcm(a,b);
        int mcm_a_c = mcm(a,c);
        int mcm_b_c = mcm(b,c);
        int mcm_a_b_c = mcm(mcm_a_b,c);
        //独立的丑数个数为，当前数分别除以a、b、c的和，
        // 减去当前数除以a、b、c两两间最小公倍数的和，
        // 再加上当前数除以 a、b、c三者的最小公倍数
        int cnt_n = mid/a+mid/b+mid/c - mid/mcm_a_b-mid/mcm_a_c-mid/mcm_b_c + mid/mcm_a_b_c;
        if(cnt_n==n) return mid;
        if(cnt_n < n) return binarySear(mid+1,high,a,b,c,n);
        return binarySear(low,mid-1,a,b,c,n);
    }

    // 最小公倍数
    private int mcm(int a,int b){
        return a*b/gcd(a,b);
    }
    // 最大公约数
    private int gcd(int a,int b){
        int le = a%b;
        while(le!=0){
            a=b;
            b=le;
            le = a%b;
        }
        return b;
    }


}

