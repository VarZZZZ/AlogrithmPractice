package 笔试.字节;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/7/15 17:03
 * @Version 1.0
 * <p>
 * 给定一系列城市和每对城市之间的距离，求推销员从某个城市出发后经过所有城市，然后回到出发城市的最短路径。
 * TSP问题
 */
public class _2019_旅行商问题 {
    /**
     * 小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，
     * 且每个城市只去一次。由于经费有限，希望能够通过合理的路线安排尽可能的省一些路上的花销。
     * 给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。
     */

    // 回溯法；


    // dp

    /**
     * 例如大问题是从顶点0开始，经过顶点1，2，3然后回到顶点1的最短路程，那么我们可以分割为三个小问题找最优解：
     * <p>
     * 从顶点0出发到顶点1，再从顶点1出发，途径2，3城市（不保证访问顺序），然后回到0的最短路径
     * 从顶点0出发到顶点2，再从顶点2出发，途径1，3城市，然后回到0的最短路径
     * 从顶点0出发到顶点3，再从顶点3出发，途径1，2城市，然后回到0的最短路径
     * 我们定义 dp[n]{p1,p2,...,pm}dp[n]{p1​,p2​,...,pm​} 为从城市 nn 出发，途径城市 p1,p2,...,pm
     * <p>
     * dp[n]{p1,p2,...,pm}为从城市n出发，途径p1​,p2​,...,pm​（不保证访问城市的顺序）然后回到城市0的最短路径。按照上述划分问题的方法，我们可以推导出：
     * <p>
     * dp[n]{p1,p2,...,pm}=min(dp[p1]{p2,...,pm}+Dnp1,dp[p2]{p1,p3,...,pm}+Dnp2,......,dp[pm]{p1,p2,...pm−1}+Dnpm)
     * dp[n]{p1​,p2​,...,pm​}=min(dp[p1​]{p2​,...,pm​}+Dp1​n​,dp[p2​]{p1​,p3​,...,pm​}+Dp2​n​,......,dp[pm​]{p1​,p2​,...pm−1​}+Dpm​n​)
     * <p>
     * 最终解为dp[0](1,2,3)
     * <p>
     * 我们可以使用状态压缩的方法，用一个int数字的每一位来表达 dp[n]{p1,p2,...,pm}dp[n]{p1​,p2​,...,pm​} 中的
     * {p1,p2,...,pm}{p1​,p2​,...,pm​}，即pm是否存在等价于该int数字的第m位是否为1，
     * 所以一个int数字可以表达{p1,p2,...,p32}{p1​,p2​,...,p32​}，
     * 即32个城市。在刚才的字节跳动笔试题中，题目已经给出n≤20，所以使用一个int数字已经足够了。
     * 所以最后，dp数组的宽度为城市的数量 xx，长度为 2x−12x−1。
     * <p>
     * https://blog.csdn.net/abc123lzf/article/details/102667120
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][1 << (n - 1)]; // 利用每一位来表示每一个城市
        for (int i = 0; i < n; i++) {
            dp[i][0] = map[i][0]; // dp[i][0] 每个城市i到城市0的距离
        }
        // dp[i][p]表示从城市-i出发，经过城市集合p到达城市0的最短距离

        // p 表示集合
        for (int p = 1; p < 1 << (n - 1); p++) {  // 遍历所有城市的集合，如{1}(000001),{2},{1,2}(000011),..{1,,,n}(11111)
            for (int i = 0; i < n; i++) { // 选择一个起点城市
                dp[i][p] = Integer.MAX_VALUE >> 1; // 除以2 防越界
                if (visit(i, p)) continue; // 起点不能出现在p集合中

                for (int k = 1; k < n; k++) { // 依次枚举
                    if (visit(k, p)) {
                        int op = unmark(p,k);
                        dp[i][p] = Math.min(dp[i][p],dp[k][op]+map[i][k]);
                    }
                }
            }
        }
        System.out.print( dp[0][(1 << (n - 1)) - 1]);
    }

    private static boolean visit(int city, int p) { // 如果city=n,最高位表示city-n,如果city=1,1表示city-1
        return (p & (1 << (city - 1))) != 0;
    }

    private static int unmark(int p, int k) { // 将k从p中移除
        return (p & (~(1 << (k - 1)))); // p&上一个除了城市-k为0，其余都为1的数
    }


}
