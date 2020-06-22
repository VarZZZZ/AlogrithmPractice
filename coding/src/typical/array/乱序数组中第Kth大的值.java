package typical.array;

import java.util.Random;

public class 乱序数组中第Kth大的值 {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    public static void main(String[] args) {
        乱序数组中第Kth大的值 k = new 乱序数组中第Kth大的值();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(k.findKthLargest(nums,2));
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k;
        int lo=0;
        int hi = nums.length-1;
        while(lo<hi){
            int j = partition(nums,lo,hi);
            if(j<k){
                lo = j+1;
            }else if(j>k){
                hi = j-1;
            }else{
                break;
            }
        }
        return nums[k];
    }
    private int partition(int[] array,int lo,int hi){
        int pivot = (int)(lo+Math.random()*(hi-lo));
        int tt = array[pivot];
        array[pivot] = array[lo];
        array[lo]=tt;
        int i = lo,j = hi;
        while(i<j){
            while(i<j&&array[j]>=tt) j--;
            while(i<j&&array[i]<=tt) i++;
            if(i>=j) break;
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        array[lo] = array[i];
        array[i] = tt;
        return i;
    }
}
