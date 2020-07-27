package typical.graph;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2020/7/22 22:48
 * @Version 1.0
 */
public class 矩阵中有障碍物_是否能放下物品 {
    /**
     * 小易有一个体积巨大的货物，具体来说，是个在二维平面上占地的货物。
     * 小易有一个的广场，想把货物放在这个广场上。
     * 不幸的是，广场上已经有了一些障碍物，障碍物所在的格子不能放置你的货物。
     * 小易现在想知道能否成功地放置货物。
     */

    /**
     * 3 3 1 - 广场大小3*3,1个障碍物；
     * 1 1 -- 障碍物坐标
     * 2 2--物品大小-  YES-能放下
     */
    /**
     * 难点 如何快速判断障碍物是否在物品的范围内
     * 利用求和的方法，将障碍物周围设为1，则如果物品的与障碍物重合了，其sum必不为0；
     * **********************
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n+1][m+1];

            int k = sc.nextInt();
            for(int i=0;i<k;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                grid[x][y]=1;
            }
            // 建立子矩阵模块
            // 此时建立起了对应的障碍物数量，如果grid[row][col]=x，表示grid[0..row][0..col]中共有x个障碍物
            for(int row=1;row<n;row++){
                for(int col=1;col<m;col++){
                    grid[row][col] += grid[row-1][col]+grid[row][col-1] - grid[row-1][col-1];
                }
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            for(int row=1;row<n-c+1;row++){
                for(int col=1;col<n-d+1;col++){
                    //计算以grid[row][col]为物品的左上角的时候，其范围内有多少个障碍物
                    int ok = grid[row+c-1][col+d-1]-grid[row+c-1][col-1]-grid[row-1][col+d-1]+grid[row-1][col-1];
                    if(ok==0){
                        System.out.println("YES"); // 能够放下！！！
                        break;
                    }
                }

            }

        }
    }

}
