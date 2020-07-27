package typical.array_2;

import java.util.Arrays;

/**
 * @Author: ly
 * @Date: 2020/7/22 19:01
 * @Version 1.0
 */
public class 区间相交问题 {
    //用最少数量的箭引爆气球
    // 找到气球重叠的最多的点
    //[[10,16], [2,8], [1,6], [7,12]]
    private int findMinArrowShots(int[][] points){
        if(points.length==0) return 0;
        Arrays.sort(points,(a,b)->(a[1]-b[1]));
        int cnt = 1;
        int start = points[0][0];
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=end) continue; // 相交了，points[i]的左端小于上一个的右端;
            // 先找与第一个相交的所有区间

            end = points[i][1];
            cnt++;
        }
        return cnt;
    }
}
