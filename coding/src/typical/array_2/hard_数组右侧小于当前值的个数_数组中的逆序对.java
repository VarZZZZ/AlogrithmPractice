package typical.array_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/7/29 23:05
 * @Version 1.0
 */
public class hard_数组右侧小于当前值的个数_数组中的逆序对 {
    /**
     * 输入：[5,2,6,1]
     * 输出：[2,1,1,0]
     * 解释：
     * 5 的右侧有 2 个更小的元素 (2 和 1)
     * 2 的右侧仅有 1 个更小的元素 (1)
     * 6 的右侧有 1 个更小的元素 (1)
     * 1 的右侧有 0 个更小的元素
     *
     */
    class Pair{
        int idx;
        int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }
    // 细想
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller,0);  // -- 必须添加这个初始化为0 不同于int[]数组
        Pair[] pairs = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pairs[i]=new Pair(i,nums[i]);
        }
        mergeSort(pairs,smaller);
        res.addAll(Arrays.asList(smaller));
        return res;
    }
    private Pair[] mergeSort(Pair[] arr,Integer[] smaller){
        if(arr.length<=1) return arr;
        int mid = arr.length/2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr,0,mid),smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length),smaller);
        for(int i=0,j=0;i<left.length||j<right.length;){
            if(j==right.length||i<left.length&&left[i].val<=right[j].val){ // -此处必须是<= 否则会计算相等的情况
                arr[i+j]=left[i];
                // 相当于将 两个有序的数组归并排序。  当A；B  ；左侧A中的cur数小于右侧B中的cur时。即将A[cur]放入到原数组中。
                // 同时，考虑右侧在cur放入原数组之前，遍历到了哪里，即右侧有多少个数字小于当前A[cur]值，右侧在原数组中是位于a[cur]右侧的
                smaller[left[i].idx] +=j;  // right 已经遍历了j个在 当前left[i] 之前。
                i++;
            }else{
                arr[i+j]=right[j];
                j++;
            }
        }
        return arr;

    }
}
