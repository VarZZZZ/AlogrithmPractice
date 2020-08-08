package typical.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class 乱序数组中第Kth大的值 {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/
    //https://blog.csdn.net/a3192048/article/details/82055183;
    //bfptr 中位数的中位数 作为Pivort


    /**
     * 前k个最小值也可以如此计算
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k;
        int lo=0;
        int hi = nums.length-1;
        while(lo<=hi){
            int j = partition(nums,lo,hi);
            if(j<k){
                lo = j+1;
            }else if(j>k){
                hi = j-1;
            }else{
                break;
            }
        }
        PriorityQueue<Integer> maxQue= new PriorityQueue<>();
        return nums[k];
    }
    private static int partition(int[] array,int lo,int hi){
        if(lo==hi) return lo;
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

    /**
     * 求arr中前k个最小值
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int l=0,r=arr.length-1;
        int[] res = new int[k];
        k--;
        while(l<=r){
            int idx = partition(arr,l,r);
            if(idx==k){
                return Arrays.copyOfRange(arr,0,idx+1);
            }else if(idx<k){
                l=idx+1;
            }else{
                r = idx-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] a=getLeastNumbers(arr,8);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
