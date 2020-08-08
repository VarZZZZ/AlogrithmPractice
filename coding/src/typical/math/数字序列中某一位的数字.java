package typical.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: ly
 * @Date: 2020/8/6 17:20
 * @Version 1.0
 */
public class 数字序列中某一位的数字 {
    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     *
     * 请写一个函数，求任意第n位对应的数字。
     *
     * 对于要确定cur位于哪个区间范围内，如果无法直接计算，那么利用count-- ，循环相减
     */
    private int findNthDigit(int n){
        int digit =1;
        int start=1;
        int count = 9;
        while(n>count){
            n -=count;
            digit = digit+1;
            start *=10;
            count = 9*digit*start;
        }
        int num= start+(n-1)/digit;
        return String.valueOf(num).charAt((n-1)%digit)-'0'; //判断奇偶
    }

    public String minNumber(int[] nums) {
        Integer[] num = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i]=nums[i];
        }
        Arrays.sort(num,(a,b)->{
            String ab = new StringBuilder().append(a).append(b).toString();
            String ba = new StringBuilder().append(b).append(a).toString();
            return ab.compareTo(ba);
        });
        StringBuilder sb = new StringBuilder();
        for(int i:nums){
            sb.append(i);
        }
        return sb.toString();
    }
}
