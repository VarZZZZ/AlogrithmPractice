package typical.dp;

import java.util.Arrays;

public class 背包问题 {
    //https://www.jianshu.com/p/50af9094a2ac
    //01背包
//    问题描述：有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大 。
//    特点:这是最简单的背包问题，特点是每个物品只有一件供你选择放还是不放。
//            ① 二维解法
//    设f[i][j]表示前 i 件物品 总重量不超过 j 的最大价值 可得出状态转移方程
//    for(int i=1;i<=n;i++)
//            for(int j=m;j>0;j--){
//        if(a[i]<=j)
//            f[i][j]=max(f[i-1][j],f[i-1][j-a[i]]+b[i]);
//        else f[i][j]=f[i-1][j];
//    }
    //一维解法
//     for(int i=1;i<=n;i++){
//        for(int j=m;j>=a[i];j--)        // 如果是二维解法，那么从小到大是可以的，f[n][j] = f[n-1][j],可是如果一维解法也是这样，那么会出现重复计算-适合于完全背包
//            f[j]=max(f[j], f[j-a[i]]+b[i]);
//    }
        //完全背包
//    问题描述：有n件物品和容量为m的背包 给出i件物品的重量以及价值 求解让装入背包的物品重量不超过背包容量 且价值最大 。
//    特点：题干看似与01一样 但它的特点是每个物品可以无限选用。
//
//    设f[j]表示重量不超过j公斤的最大价值 可得出状态转移方程
//    f[j] = maxj{f[j], f[j−a[i]]+b[i]}
//    代码：
//            for(int i=1;i<=n;i++)
//              for(int  j = a[i];j <= m;j++){           //与0-1背包的区别！！！！！
//                    f[j] = max(f[j], f[j-a[i]]+b[i]);
//              }

    //给定一定数量的纸币，给定找零数量，求有多少种方法：
    //完全背包;
    // dp[i][j] = dp[i-1][j]+dp[i][j-arr[i]];
    //-》dp[i][j] +=dp[i][j-arr[i]] -> dp[j] +=dp[j-arr[i]]
//
    // 多重背包
//    问题描述：有n件物品和容量为m的背包 给出i件物品的重量以及价值 还有数量 求解让装入背包的物品重量不超过背包容量 且价值最大 。
//    特点 ：它与完全背包有类似点 特点是每个物品都有了一定的数量。
//
//    状态转移方程为：
//    f[j] = max{f[j], f[j−k∗a[i]]+k∗b[i]}
//    for(int i=1;i<=n;i++)
//       for(int j=m;j>=a[i];j--)
//          for(int k=0;k<=c[i];k++){
//              if(j-k*a[i]<0)break;
//              f[j] = max(f[j], f[j-k*a[i]]+k*b[i]);
//          }

    //现有总金额T，n件商品的价格分别为p1,p2,…,pn，问有多少种购买方法正好花完T。
    private static int waysCostAll(int T,int[] p){
        int[] dp = new int[T+1];
        dp[0] = 1;
        int n = p.length;
        Arrays.sort(p);
        for(int i=0;i<n;i++){
            for(int j=p[i];j<=T;j++){
                // dp[i][j] = dp[i-1][j]+dp[i][j-p[i]]
                dp[j] = dp[j-p[i]]+dp[j];
            }
        }
        return dp[T];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(waysCostAll(4,arr));
    }








}
