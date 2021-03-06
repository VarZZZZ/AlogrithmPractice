package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/9 11:19
 * @Version 1.0
 */
public class 邮局选址问题_将邮局分布在居民点上使总距离最短 {
    /**
     * 一条直线上有居民点，邮局只能在居民点上，给定一个arr,每个值表示居民点的坐标，再给一个num，表示邮局数量，将这些邮局分配，
     * 使所有居民点到这些邮局的总距离最短
     */

    /**
     * 方法1.动态规划
     * 思考：如果要在arr[i..j]上建一个，则应该是中点位置
     * 因此，生成矩阵N*N w,w[i][j]的值表示如果要在arr[i..j]上建一个邮局，这区间内的总距离为多少。因为i<=j，所以只求矩阵的一半
     *
     * 求w[i][j]时，如果已知w[i][j-1]，则w[i][j] = w[i][j-1]+arr[j]-arr[(i+j)/2].  arr[(i+j)/2]表示 arr[i..j]上的中点
     *  当在数组末尾添加一个值时，如果原数组是奇数位置，则中点位置不变，i...j-1是奇数，(i+j-1)/2 与  i+j)/2表示同一位置
     *  w[i][j] 比 原w[i][j-1]只是多出了arr[j]到中点的距离
     *
     * dp[a][b]表示arr[0..b]上建设a+1个邮局，总距离最少是多少,dp[0][b] = w[0][b]
     *
     * db[a][b] = min{db[a-1][k]+w[k+1][b] (0<=k<N)}
     *
     */
}
