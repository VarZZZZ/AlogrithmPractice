package typical.array_程序代码指南;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ly
 * @Date: 2020/7/5 16:39
 * @Version 1.0
 */
public class 最长的可整合子数组的长度_可整合表示排序后连续 {
    // 5 5 3 2 6  4 3 => [5,3,2,6,4]是最长可整合数组
    // 暴力方法，对每个长度的子数组排序后，验证是否可整合

    // 2.如果一个数组中没有重复元素，且最大减去最小==元素个数，即可整合

    private int getLIL(int[] arr){
        int len = 0;
        int min = 0;
        int max = 0;
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<arr.length;i++){ // 以每个arr[i]作为可整合数组的起点，进行验证
            max =Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for(int j=i;j<arr.length;j++){
                if(st.contains(arr[j])){
                    break;
                }
                max = Math.max(max,arr[j]);
                min = Math.min(min,arr[j]);
                st.add(arr[j]);
                if(max-min==j-i){
                    len = Math.max(len,j-i+1);
                }
            }
            st.clear();

        }
        return len;

    }
}
