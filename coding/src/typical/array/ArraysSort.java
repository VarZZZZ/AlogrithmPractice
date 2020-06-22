package typical.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {

    // 数组排序，重叠问题处理
    private int findMindArrowShots(int[][] points){
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int cnt = 1;
        int start=points[0][0];
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<end) continue;
            end = points[i][1];
            cnt++;
        }

        return cnt;
    }
}
