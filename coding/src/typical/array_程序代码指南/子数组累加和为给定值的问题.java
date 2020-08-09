package typical.array_程序代码指南;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ly
 * @Date: 2020/7/5 16:46
 * @Version 1.0
 *
 * 直接利用map存储s[i],和i是解决一切子数组累加和为固定值的方法
 * s[i]为arr[0..i]的和
 * 但不是最优，利用Map<integer> 存储是最好的方法， if map.containsKey(curSum-target) ,表明存在使和为taget的子数组
 * 子数组累加和最大 利用遍历一遍，见 基本问题_面试题
 */
public class 子数组累加和为给定值的问题 {

    /**
     * 1. 不重复的打印排序数组中累加和为给定值的所有二元组和三元组
     * 二元组利用while(l<r) 向中间值逼近
     */
    private void printUniqueTriad(int[] arr, int k) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) { // 取三元组的第一个元素
                printRest(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    // 二元组
    private void printRest(int[] arr, int f, int l, int r, int res) {
        while (l < r) {
            if (arr[l] + arr[r] < res) {
                l++;
            } else if (arr[l] + arr[r] > res) {
                r--;
            } else {
                // arr[l]表示的是第二个元素，
                // arr[r]不需要判断，如果arr[r]==arr[r+1]，且符合重复情况，则必有arr[l-1]==arr[l]
                if (l == f + 1 || arr[l - 1] != arr[l]) { //如果arr[l]==arr[l-1]，且l!=f+1,那么arr[l-1]已经作为第二个
                    //元素输出了。
                    System.out.println(arr[f] + "," + arr[l] + "," + arr[r]);
                }
                l++;
                r--;
            }
        }
    }


    /**
     * 未排序正数数组中 累加和为给定值的最长子数组长度
     * 滑动窗口;left=0,right=0.
     */

    private int getMaxLen(int[] arr, int k) {

        int left=0;
        int right = 0;
        int res = 0;
        int sm = 0;
        while(right<arr.length){
            if(sm==k){
                res = Math.min(right-left+1,res);
                sm -= arr[left++];
            }else if(sm<k){
                right++;
                if(right==arr.length){
                    break;
                }
                sm +=arr[right];
            }else{
                sm -=arr[left];
                left++;
            }
        }
        return res;
    }

    /**
     * 1.无序数组，正负、0，给定k，求累加和为k的最长子数组长度
     * 2.                       求子数组中正数和负数个数相等的最长子数组长度
     * 3.       元素只有1和0,求0和1个数相等的最长子数组长度
     *  核心：s[i]为arr[0..i]的累加和，arr[j...i]=s[i]-s[j]
     *  利用map保存s[i]和i
     */
    private int maxLen(int[] arr,int k){

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); // ** 有可能出现arr[0..i]为k  arr[0..i..j]为k。
        int len =0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(i-map.get(sum-k),len);
            }
            if(!map.containsKey(sum)){ //求得是最长子数组长度，所以保留s[i]的最初始出现的idx
                map.put(sum,i);
            }
        }
        return len;
    }
    //问题2. 将正数转为1。负数转为-1,0不变
    // 问题3.将0变为-1,1不变，求k为0的最长子数组

    /**
     * 未排序数组中累加和小于或等于给定值的最长子数组长度
     */
    private int maxLen_3(int[] arr,int k){

        int[] h = new int[arr.length+1];
        h[0] = 0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            h[i+1] = Math.max(h[i],sum); // 去当前arr[i] 0。。。i中最大的累加和；单调递增
        }
        sum =0;
        int pre = 0;
        int len = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre = getLessLen(h,sum-k); // 找到里idx=0最近的累加和大于等于sum-k的值。
            len = pre==-1?0:i-pre+1;  //如果等于-1,则表示当前累加和全部小于sum-k，那么pre..i之间的累加和必然大于k
            res = Math.max(len,res);
        }
        return res;
    }

    private int getLessLen(int[] h, int k) {
        int low = 0;
        int high = h.length-1;
        int mid =0;
        int res = -1;
        while(low<=high){
            mid = (low+high)/2;
            if(h[mid]>=k){   // 当arr[0..i]中有累加和大于sum-k时，尽量再往左找，找到最左边的
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }


}



